package br.com.vitorino.templatehexagonalarch.person.model

import br.com.vitorino.templatehexagonalarch.infrastructure.visitor.Host

class Person : Host<Person> {

    lateinit var id: String

    lateinit var name: String

    lateinit var email: String

}