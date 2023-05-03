package br.com.vitorino.templatehexagonalarch.person.command

import br.com.vitorino.templatehexagonalarch.infrastructure.command.CommandProcessor
import br.com.vitorino.templatehexagonalarch.infrastructure.exception.NotFoundException
import br.com.vitorino.templatehexagonalarch.person.model.Person
import br.com.vitorino.templatehexagonalarch.person.repository.PersonRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PersonRetrieveFindByIdCommandProcessor(private val personRepo: PersonRepo):CommandProcessor<String, Person> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun execute(id: String): Person {
        log.info("Iniciando a busca Byid {}", id)
        val optionalPerson = personRepo.findById(id)
        optionalPerson.takeIf { it.isPresent }
                .apply {
                    return optionalPerson.get()
                }.run {
                    log.warn("Person nao encontrada com o id {}", id)
                    throw NotFoundException("Person nao encontrada")
                }
    }


}