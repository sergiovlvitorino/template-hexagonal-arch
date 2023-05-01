package br.com.vitorino.templatehexagonalarch.person.controller

import com.fasterxml.jackson.annotation.JsonAlias

class PersonResponse {

    @JsonAlias("id")
    lateinit var id: String

    @JsonAlias("name")
    lateinit var name: String

    @JsonAlias("email")
    lateinit var email: String

}