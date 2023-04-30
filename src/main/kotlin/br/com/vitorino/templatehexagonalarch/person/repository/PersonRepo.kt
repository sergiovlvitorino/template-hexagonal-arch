package br.com.vitorino.templatehexagonalarch.person.repository

import br.com.vitorino.templatehexagonalarch.person.mapper.PersonMapper
import br.com.vitorino.templatehexagonalarch.person.model.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PersonRepo(private val mapper: PersonMapper,
                 private val repository: PersonRepository): IPersonRepo<Person, String> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun save(person: Person): Person {

        var entity = mapper.mapToEntity(person)

        runCatching {
            log.info("Salvando a Entity {}", entity)
            entity = repository.save(entity)
        }.onSuccess {
            log.info("Entity salva com sucesso {}", entity)
        }.onFailure {
            log.error("Erro ao salvar a entity {} {}", entity, it)
            throw it
        }

        return mapper.mapToModel(entity)
    }

    override fun existsByEmail(email: String): Boolean {
        return repository.existsByEmail(email)
    }
}