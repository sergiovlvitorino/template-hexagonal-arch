package br.com.vitorino.templatehexagonalarch.person.repository

interface IPersonRepo<T, ID> {

    fun save(o: T): T

    fun existsByEmail(email: String): Boolean

}