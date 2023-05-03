package br.com.vitorino.templatehexagonalarch.person.mapper

import br.com.vitorino.templatehexagonalarch.person.controller.PersonCreateRequest
import br.com.vitorino.templatehexagonalarch.person.controller.PersonResponse
import br.com.vitorino.templatehexagonalarch.person.message.PersonMessage
import br.com.vitorino.templatehexagonalarch.person.model.Person
import br.com.vitorino.templatehexagonalarch.person.repository.PersonEntity
import br.com.vitorino.templatehexagonalarch.person.service.PersonBannedRequest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PersonMapper {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun mapModelToEntity(person: Person): PersonEntity {
        val entity = PersonEntity()
        entity.id = person.id
        entity.name = person.name
        entity.email = person.email

        log.info("Convertendo Model {} para Entity {}", person, entity)

        return entity
    }

    fun mapEntityToModel(entity: PersonEntity): Person {
        val model = Person()
        model.id = entity.id
        model.name = entity.name
        model.email = entity.email

        log.info("Convertendo Entity {} para Model {}", entity, model)

        return model
    }

    fun mapCreateRequestToModel(request: PersonCreateRequest): Person {
        val model = Person()
        model.name = request.name
        model.email = request.email

        log.info("Convertendo CreateRequest {} para Model {}", request, model)

        return model
    }

    fun mapModelToResponse(person: Person): PersonResponse {
        val response = PersonResponse()
        response.id = person.id
        response.name = person.name
        response.email = person.email

        log.info("Convertendo Model {} para Response {}", person, response)

        return response
    }

    fun mapModelToMessage(person: Person): PersonMessage {
        val message = PersonMessage()
        message.id = person.id

        log.info("Convertendo Model {} para Message {}", person, message)

        return message
    }

    fun mapModelToBannedRequest(person: Person): PersonBannedRequest {

        val request = PersonBannedRequest()
        request.email = person.email

        log.info("Convertendo Model {} para Request {}", person, request)

        return request
    }

}