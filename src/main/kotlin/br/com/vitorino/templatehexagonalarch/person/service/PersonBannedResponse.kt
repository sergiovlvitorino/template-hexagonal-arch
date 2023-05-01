package br.com.vitorino.templatehexagonalarch.person.service

import com.fasterxml.jackson.annotation.JsonAlias

class PersonBannedResponse {

    @JsonAlias("is_banned")
    var banned: Boolean = false

}