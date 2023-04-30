package br.com.vitorino.templatehexagonalarch.person.controller

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

class PersonCreateRequest {

    @JsonAlias("name")
    @NotEmpty
    lateinit var name:String

    @JsonAlias("email")
    @NotEmpty
    @Email
    lateinit var email:String


}