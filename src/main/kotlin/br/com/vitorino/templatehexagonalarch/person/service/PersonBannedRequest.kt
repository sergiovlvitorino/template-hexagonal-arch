package br.com.vitorino.templatehexagonalarch.person.service

import com.fasterxml.jackson.annotation.JsonAlias

class PersonBannedRequest {

    @JsonAlias("email")
    lateinit var email: String

}