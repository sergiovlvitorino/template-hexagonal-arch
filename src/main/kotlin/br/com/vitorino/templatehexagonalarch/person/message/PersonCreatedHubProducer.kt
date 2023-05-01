package br.com.vitorino.templatehexagonalarch.person.message

import br.com.vitorino.templatehexagonalarch.infrastructure.message.Producer
import br.com.vitorino.templatehexagonalarch.person.mapper.PersonMapper
import br.com.vitorino.templatehexagonalarch.person.model.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PersonCreatedHubProducer(private val mapper: PersonMapper) : Producer<Person> {

    private val log = LoggerFactory.getLogger(this::class.java)
    override fun publish(person: Person) {
        val message = mapper.mapToMessage(person)
        log.info("Enviando para topico PersonCreated {}", message)
        // TODO enviar para o topico
    }
}