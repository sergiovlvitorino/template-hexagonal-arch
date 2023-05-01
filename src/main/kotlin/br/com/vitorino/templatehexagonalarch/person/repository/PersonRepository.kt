package br.com.vitorino.templatehexagonalarch.person.repository

import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<PersonEntity, String> {
    fun existsByEmail(email: String): Boolean
}