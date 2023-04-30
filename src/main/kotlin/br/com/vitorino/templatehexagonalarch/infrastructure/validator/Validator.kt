package br.com.vitorino.templatehexagonalarch.infrastructure.validator

interface Validator<T> {

    fun validate(o: T)

}