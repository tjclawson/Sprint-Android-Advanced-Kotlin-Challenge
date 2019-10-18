package com.example.sprintchallengeadvancedkotlin

import java.io.Serializable

class Matrix(var matrix: Array<IntArray>, val height: Int, val width: Int): Serializable {

    operator fun times(m: Matrix): Matrix {
        val r1 = height
        val c1 = width
        val r2 = width
        val c2 = height

        val firstMatrix = matrix
        val secondMatrix = m.matrix


        val productMatrix = Matrix(Array(r1) { IntArray(c2) }, height, width)
        for (i in 0..r1 - 1) {
            for (j in 0..c2 - 1) {
                for (k in 0..c1 - 1) {
                    productMatrix.matrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j]
                }
            }
        }

        return productMatrix
    }

   /* operator fun plus(m: Matrix): Matrix {
        val r1 = height
        val c1 = width
        val r2 = width
        val c2 = height

        val firstMatrix = matrix
        val secondMatrix = m.matrix


        val productMatrix = Matrix(Array(r1) { IntArray(c2) }, height, width)
        for (i in 0..r1 - 1) {
            for (j in 0..c2 - 1) {
                for (k in 0..c1 - 1) {
                    productMatrix.matrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j]
                }
            }
        }

        return productMatrix
    }*/
}