package br.com.vitorino.templatehexagonalarch.infrastructure.visitor

interface Host<T> {

    fun accept(visitor: Visitor<T>) = visitor.visit(this as T)

}