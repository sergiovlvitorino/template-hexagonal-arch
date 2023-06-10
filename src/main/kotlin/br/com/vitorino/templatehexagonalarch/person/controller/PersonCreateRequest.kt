package br.com.vitorino.templatehexagonalarch.person.controller

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

class PersonCreateRequest {

    @JsonProperty("name")
    @NotEmpty
    lateinit var name: String

    @JsonProperty("email")
    @NotEmpty
    @Email
    lateinit var email: String


}