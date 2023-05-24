package com.example.micalculadorakotlin

class Calculadora {
    var num1: Int = 0
    var num2: Int = 0

    constructor(num1: Int, num2: Int) {
        this.num2 = num2;
        this.num1 = num1;

    }

    fun suma(): Int {
        return num1 + num2;
    }

    fun resta(): Int {
        return num1 - num2;
    }

    fun multiplicacion(): Int {
        return num1 * num2;
    }

    fun division(): Int {
        if (num2 == 0) {
            throw ArithmeticException("No se puede dividir entre cero")
        }
        return num1 / num2
    }

}