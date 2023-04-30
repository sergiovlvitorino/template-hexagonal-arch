package br.com.vitorino.templatehexagonalarch.infrastructure.visitor

interface Visitor<T> {

    fun visit(o: T)

}
