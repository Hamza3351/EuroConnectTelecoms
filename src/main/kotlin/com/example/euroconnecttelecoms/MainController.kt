package com.example.euroconnecttelecoms

import com.example.euroconnecttelecoms.ScalaMST.*
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.paint.*
import javafx.scene.shape.*
import javafx.scene.text.*
import javafx.stage.FileChooser
import java.io.File
import kotlin.math.*

class MainController {

    @FXML
    private lateinit var languageChoiceBox: ChoiceBox<String>

    @FXML
    private lateinit var paradigmChoiceBox: ChoiceBox<String>

    @FXML
    private lateinit var statusLabel: Label

    @FXML
    private lateinit var graphPane: Pane

    private var selectedFile: File? = null

    lateinit var originalEdges: List<Edge>

    @FXML
    private lateinit var edgeListView: ListView<String>

    @FXML
    fun initialize() {
        languageChoiceBox.items.addAll("Kotlin", "Scala")
        languageChoiceBox.selectionModel.selectFirst()

        paradigmChoiceBox.items.addAll("Object-Oriented", "Functional")
        paradigmChoiceBox.selectionModel.selectFirst()
    }

    @FXML
    fun onLoadFile() {
        val fileChooser = FileChooser()
        fileChooser.title = "Select Distance File"
        fileChooser.extensionFilters.add(FileChooser.ExtensionFilter("CSV Files", "*.csv"))
        val file = fileChooser.showOpenDialog(null)
        if (file != null) {
            selectedFile = file
            statusLabel.text = "File loaded: ${file.name}"
            originalEdges = CsvLoader.loadEdgesFromCsv(file)
            edgeListView.items.setAll(originalEdges.map { "${it.from} - ${it.to}: ${it.weight}" })
            drawGraph(originalEdges, emptySet())
        }
    }

    @FXML
    fun onRunMST() {
        if (selectedFile == null) {
            statusLabel.text = "Please load a file first."
            return
        }

        val language = languageChoiceBox.value
        val paradigm = paradigmChoiceBox.value

        val output = when (language) {
            "Kotlin" -> "Working"
            "Scala" -> ScalaMST.sayHello()
            else -> "Unknown"
        }

        statusLabel.text = "[$language - $paradigm] $output"

        val mstEdges = when {
            language == "Kotlin" && paradigm == "Object-Oriented" ->
                KruskalMST(originalEdges).findMST()

            language == "Kotlin" && paradigm == "Functional" ->
                functionalKruskalMST(originalEdges)

            language == "Scala" && paradigm == "Object-Oriented" -> {
                val scalaEdges = originalEdges.map {
                    EdgeScala(it.from, it.to, it.weight)
                }
                val scalaMST = ScalaMSTOO(scalaEdges)
                scalaMST.findMST().map {
                    Edge(it.from(), it.to(), it.weight())
                }
            }

            language == "Scala" && paradigm == "Functional" -> {
                val scalaEdges = originalEdges.map {
                    EdgeScala(it.from, it.to, it.weight)
                }
                val scalaMST = ScalaMSTFunctional(scalaEdges)
                scalaMST.findMST().map {
                    Edge(it.from(), it.to(), it.weight())
                }
            }

            else -> emptyList()
        }

        edgeListView.items.setAll(mstEdges.map { "${it.from} - ${it.to}: ${it.weight}" })
        drawGraph(originalEdges, mstEdges.toSet())
    }

    private fun computeCityPositions(edges: List<Edge>): Map<String, Pair<Double, Double>> {
        val cities = edges.flatMap { listOf(it.from, it.to) }.distinct()
        val radius = 150.0
        val centerX = 400.0
        val centerY = 200.0
        val angleStep = 2 * Math.PI / cities.size

        return cities.mapIndexed { index, city ->
            val angle = angleStep * index
            val x = centerX + radius * cos(angle)
            val y = centerY + radius * sin(angle)
            city to (x to y)
        }.toMap()
    }

    private fun drawGraph(edges: List<Edge>, mst: Set<Edge>) {
        graphPane.children.clear()
        val positions = computeCityPositions(edges)

        val showOnlyMST = mst.isNotEmpty()

        // Draw edges
        val edgesToDraw = if (showOnlyMST) mst else edges.toSet()
        edgesToDraw.forEach { edge ->
            val (x1, y1) = positions[edge.from]!!
            val (x2, y2) = positions[edge.to]!!

            val line = Line(x1, y1, x2, y2)
            line.strokeWidth = 4.0
            line.stroke = Color.GREEN

            val label = Label(edge.weight.toString())
            label.layoutX = (x1 + x2) / 2
            label.layoutY = (y1 + y2) / 2
            label.style = "-fx-background-color: white; -fx-padding: 2;"

            graphPane.children.addAll(line, label)
        }

        // Draw nodes
        positions.forEach { (city, pos) ->
            val (x, y) = pos
            val circle = Circle(x, y, 18.0, Color.LIGHTBLUE)
            val text = Text(x - 6, y + 4, city)
            text.fill = Color.BLACK
            text.font = Font.font(14.0)
            graphPane.children.addAll(circle, text)
        }
    }
}
