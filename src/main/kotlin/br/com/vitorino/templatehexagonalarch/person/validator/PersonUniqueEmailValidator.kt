package br.com.vitorino.templatehexagonalarch.person.validator

import br.com.vitorino.templatehexagonalarch.infrastructure.exception.EmailAlreadyException
import br.com.vitorino.templatehexagonalarch.infrastructure.validator.Validator
import br.com.vitorino.templatehexagonalarch.person.model.Person
import br.com.vitorino.templatehexagonalarch.person.repository.PersonRepo
import org.springframework.stereotype.Component

@Component
class PersonUniqueEmailValidator(private val personRepo: PersonRepo) : Validator<Person> {

    override fun validate(person: Person) {
        person.email.takeIf { personRepo.existsByEmail(it) }.apply {
            throw EmailAlreadyException(String.format("E-mail already {}", this))
        }
    }

}