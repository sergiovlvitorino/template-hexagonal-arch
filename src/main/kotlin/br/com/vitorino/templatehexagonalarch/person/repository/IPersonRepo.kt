package br.com.vitorino.templatehexagonalarch.person.repository

import java.util.Optional

interface IPersonRepo<T, ID> {

    fun save(o: T): T

    fun existsByEmail(email: String): Boolean

    fun findById(id:ID):Optional<T>

}