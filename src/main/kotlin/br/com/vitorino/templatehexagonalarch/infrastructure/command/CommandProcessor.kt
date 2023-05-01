package br.com.vitorino.templatehexagonalarch.infrastructure.command

interface CommandProcessor<T, K> {

    fun execute(o: T): K

}