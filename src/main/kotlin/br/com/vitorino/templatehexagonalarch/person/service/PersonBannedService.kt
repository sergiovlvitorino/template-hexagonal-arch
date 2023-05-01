package br.com.vitorino.templatehexagonalarch.person.service

import br.com.vitorino.templatehexagonalarch.infrastructure.service.Service
import br.com.vitorino.templatehexagonalarch.person.mapper.PersonMapper
import br.com.vitorino.templatehexagonalarch.person.model.Person
import org.slf4j.LoggerFactory

@org.springframework.stereotype.Service
class PersonBannedService(private val mapper: PersonMapper) : Service<Person, Boolean> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun call(person: Person): Boolean {

        val request = mapper.mapToRequest(person)

        log.info("Consumindo servico PersonBanned {}", request)

        // TODO

        return false
    }
}