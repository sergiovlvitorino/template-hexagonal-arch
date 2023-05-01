package br.com.vitorino.templatehexagonalarch.person.controller

import br.com.vitorino.templatehexagonalarch.person.command.PersonCreateCommandProcessor
import br.com.vitorino.templatehexagonalarch.person.mapper.PersonMapper
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
@Validated
class PersonCreateRestController(private val mapper: PersonMapper,
                                 private val commandProcessor: PersonCreateCommandProcessor
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid request: PersonCreateRequest): PersonResponse {

        log.info("Requisicao recebida {}", request)

        val person = mapper.mapToModel(request)

        val result = commandProcessor.execute(person)

        val response = mapper.mapToResponse(result)

        log.info("Retornando Response {}", response)

        return response
    }

}