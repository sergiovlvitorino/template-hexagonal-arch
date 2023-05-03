package br.com.vitorino.templatehexagonalarch.person.controller

import br.com.vitorino.templatehexagonalarch.person.command.PersonRetrieveFindByIdCommandProcessor
import br.com.vitorino.templatehexagonalarch.person.mapper.PersonMapper
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonRetrieveRestController(private val mapper: PersonMapper,
                                   private val commandProcessor: PersonRetrieveFindByIdCommandProcessor) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping
    fun findById(@PathVariable id: String): PersonResponse {

        log.info("Requisicao recebida com id {}", id)

        val result = commandProcessor.execute(id)

        val response = mapper.mapModelToResponse(result)

        log.info("Retornando Response {}", response)

        return response
    }

}