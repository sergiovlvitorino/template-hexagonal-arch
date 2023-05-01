package br.com.vitorino.templatehexagonalarch.person.validator

import br.com.vitorino.templatehexagonalarch.infrastructure.exception.PersonBannedException
import br.com.vitorino.templatehexagonalarch.infrastructure.validator.Validator
import br.com.vitorino.templatehexagonalarch.person.model.Person
import br.com.vitorino.templatehexagonalarch.person.service.PersonBannedService
import org.springframework.stereotype.Component

@Component
class PersonBannedValidator(private val personBannedService: PersonBannedService):Validator<Person> {
    override fun validate(person: Person) {
        personBannedService.call(person).takeIf { it }.apply {
            throw PersonBannedException("Person is banned")
        }
    }
}