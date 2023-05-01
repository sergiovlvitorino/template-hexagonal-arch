package br.com.vitorino.templatehexagonalarch.person.command

import br.com.vitorino.templatehexagonalarch.infrastructure.command.CommandProcessor
import br.com.vitorino.templatehexagonalarch.person.message.PersonCreatedHubProducer
import br.com.vitorino.templatehexagonalarch.person.model.Person
import br.com.vitorino.templatehexagonalarch.person.repository.PersonRepo
import br.com.vitorino.templatehexagonalarch.person.validator.PersonBannedValidator
import br.com.vitorino.templatehexagonalarch.person.validator.PersonUniqueEmailValidator
import br.com.vitorino.templatehexagonalarch.person.visitor.PersonGenerateIdVisitor
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PersonCreateCommandProcessor(
        private val personUniqueEmailValidator: PersonUniqueEmailValidator,
        private val personBannedValidator: PersonBannedValidator,
        private val personGenerateIdVisitor: PersonGenerateIdVisitor,
        private val personRepo: PersonRepo,
        private val personCreatedHubProducer: PersonCreatedHubProducer,
) : CommandProcessor<Person, Person> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(person: Person): Person {
        log.info("Iniciando o processamento {}", person)

        personUniqueEmailValidator.validate(person)

        personBannedValidator.validate(person)

        person.accept(personGenerateIdVisitor)

        val result = personRepo.save(person)

        personCreatedHubProducer.publish(result)

        log.info("Processamento concluido com sucesso {}", result)

        return result
    }
}