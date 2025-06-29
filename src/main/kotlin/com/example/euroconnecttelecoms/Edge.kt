package com.example.euroconnecttelecoms

data class Edge(val from: String, val to: String, val weight: Int) {
    fun reverse(): Edge = Edge(to, from, weight)
}
