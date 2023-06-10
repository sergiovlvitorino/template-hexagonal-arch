package br.com.vitorino.templatehexagonalarch.person.controller

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

class PersonResponse {

    @JsonProperty("id")
    lateinit var id: String

    @JsonProperty("name")
    lateinit var name: String

    @JsonProperty("email")
    lateinit var email: String

}