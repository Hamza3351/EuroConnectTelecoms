package com.example.euroconnecttelecoms

import java.io.File

object CsvLoader {
    fun loadEdgesFromCsv(file: File): List<Edge> {
        return file.readLines()
            .drop(1) // Skip header
            .mapNotNull { line ->
                val parts = line.split(",")
                if (parts.size == 3) {
                    val from = parts[0].trim()
                    val to = parts[1].trim()
                    val weight = parts[2].trim().toIntOrNull()
                    if (weight != null) Edge(from, to, weight) else null
                } else null
            }
    }
}
