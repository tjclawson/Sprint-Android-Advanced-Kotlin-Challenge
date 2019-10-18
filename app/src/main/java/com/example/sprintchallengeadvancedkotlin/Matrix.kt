package com.example.sprintchallengeadvancedkotlin

import java.io.Serializable

class Matrix(var matrix: Array<IntArray>, val height: Int, val width: Int): Serializable {

    operator fun times(m: Matrix): Matrix {
        val r1 = width
        val c1 = height
        val r2 = m.height
        val c2 = m.width

        val firstMatrix = matrix
        val secondMatrix = m.matrix

        val productMatrix = Matrix(Array(r1) { IntArray(c2) }, height, m.width)
        for (i in 0..r1 - 1) {
            for (j in 0..c2 - 1) {
                for (k in 0..c1 - 1) {
                    productMatrix.matrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j]
                }
            }
        }
        return productMatrix
    }
}