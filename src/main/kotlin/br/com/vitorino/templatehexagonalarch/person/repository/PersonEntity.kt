package br.com.vitorino.templatehexagonalarch.person.repository

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class PersonEntity {

    @Id
    lateinit var id: String

    lateinit var name: String

    lateinit var email: String

}