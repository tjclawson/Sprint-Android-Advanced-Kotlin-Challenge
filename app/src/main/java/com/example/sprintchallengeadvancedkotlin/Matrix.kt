package com.example.sprintchallengeadvancedkotlin

import java.io.Serializable

class Matrix(var matrix: Array<Array<Int>>): Serializable {

    operator fun times(m: Matrix): Matrix {
        val r0c0 = (matrix[0][0] * m.matrix[0][0]) + (matrix[0][1] * m.matrix[1][0])
        val r0c1 = (matrix[0][0] * m.matrix[0][1]) + (matrix[0][1] * m.matrix[1][1])
        val r1c0 = (matrix[1][0] * m.matrix[0][0]) + (matrix[1][1] * m.matrix[1][0])
        val r1c1 = (matrix[1][0] * m.matrix[0][1]) + (matrix[1][1] * m.matrix[1][1])

        val initMatrix = Matrix(Array(2) { Array(2) { 0 } })

        initMatrix.matrix[0][0] = r0c0
        initMatrix.matrix[0][1] = r0c1
        initMatrix.matrix[1][0] = r1c0
        initMatrix.matrix[1][1] = r1c1

        return initMatrix
    }
}