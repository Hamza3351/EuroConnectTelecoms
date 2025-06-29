package com.example.euroconnecttelecoms.ScalaMST

import scala.jdk.CollectionConverters._
import scala.collection.mutable

class ScalaMSTFunctional(inputEdges: java.util.List[EdgeScala]) {
  def findMST(): java.util.List[EdgeScala] = {
    val edges = inputEdges.asScala.toList
    val sortedEdges = edges.sortBy(_.weight)

    val parent = mutable.Map[String, String]()

    def find(city: String): String = {
      if (parent(city) != city) parent(city) = find(parent(city))
      parent(city)
    }

    def union(a: String, b: String): Unit = {
      val rootA = find(a)
      val rootB = find(b)
      if (rootA != rootB) parent(rootB) = rootA
    }

    val cities = edges.flatMap(e => List(e.from, e.to)).distinct
    cities.foreach(c => parent(c) = c)

    val result = mutable.ListBuffer[EdgeScala]()

    for (edge <- sortedEdges) {
      if (find(edge.from) != find(edge.to)) {
        result += edge
        union(edge.from, edge.to)
      }
    }

    result.asJava
  }
}
