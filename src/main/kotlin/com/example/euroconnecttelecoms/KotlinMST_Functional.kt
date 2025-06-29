package com.example.euroconnecttelecoms

fun functionalKruskalMST(edges: List<Edge>): List<Edge> {
    val sortedEdges = edges.sortedBy { it.weight }
    val parents = mutableMapOf<String, String>()

    fun find(city: String): String {
        return if (parents[city] != city) {
            parents[city] = find(parents[city] ?: city)
            parents[city]!!
        } else {
            city
        }
    }

    fun union(a: String, b: String): Boolean {
        val rootA = find(a)
        val rootB = find(b)
        return if (rootA != rootB) {
            parents[rootA] = rootB
            true
        } else {
            false
        }
    }

    val cities = edges.flatMap { listOf(it.from, it.to) }.toSet()
    cities.forEach { parents[it] = it }

    return sortedEdges.fold(emptyList()) { mst, edge ->
        if (union(edge.from, edge.to)) mst + edge else mst
    }
}
