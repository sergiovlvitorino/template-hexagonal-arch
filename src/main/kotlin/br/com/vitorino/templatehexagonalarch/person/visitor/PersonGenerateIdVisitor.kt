package br.com.vitorino.templatehexagonalarch.person.visitor

import br.com.vitorino.templatehexagonalarch.infrastructure.visitor.Visitor
import br.com.vitorino.templatehexagonalarch.person.model.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class PersonGenerateIdVisitor : Visitor<Person> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun visit(person: Person) {
        person.id = UUID.randomUUID().toString()
        log.info("Adicionando Id para person {}", person)
    }
}