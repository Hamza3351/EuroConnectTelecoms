package com.example.euroconnecttelecoms

class KruskalMST(private val edges: List<Edge>) {

    private val parent = mutableMapOf<String, String>()

    private fun find(city: String): String {
        if (parent[city] != city) {
            parent[city] = find(parent[city]!!)
        }
        return parent[city]!!
    }

    private fun union(city1: String, city2: String) {
        val root1 = find(city1)
        val root2 = find(city2)
        if (root1 != root2) parent[root2] = root1
    }

    fun findMST(): List<Edge> {
        val sortedEdges = edges.sortedBy { it.weight }
        val mst = mutableListOf<Edge>()

        edges.flatMap { listOf(it.from, it.to) }.distinct().forEach { parent[it] = it }

        for (edge in sortedEdges) {
            if (find(edge.from) != find(edge.to)) {
                mst.add(edge)
                union(edge.from, edge.to)
            }
        }

        return mst
    }
}
