package br.com.vitorino.templatehexagonalarch.infrastructure.message

interface Producer<T> {

    fun publish(o: T)

}