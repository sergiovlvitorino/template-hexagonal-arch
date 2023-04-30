package br.com.vitorino.templatehexagonalarch.person.command

import br.com.vitorino.templatehexagonalarch.infrastructure.command.CommandProcessor
import br.com.vitorino.templatehexagonalarch.person.model.Person
import br.com.vitorino.templatehexagonalarch.person.repository.PersonRepo
import br.com.vitorino.templatehexagonalarch.person.validator.PersonUniqueEmailValidator
import org.springframework.stereotype.Component

@Component
class PersonCreateCommandProcessor(private val personUniqueEmailValidator: PersonUniqueEmailValidator
                                    private val personRepo: PersonRepo
) : CommandProcessor<Person, Person> {
    override fun execute(person: Person): Person {
        personUniqueEmailValidator.validate(person)

        TODO("Not yet implemented")
    }
}