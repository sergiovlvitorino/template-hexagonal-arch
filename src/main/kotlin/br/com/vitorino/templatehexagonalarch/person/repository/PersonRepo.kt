package br.com.vitorino.templatehexagonalarch.person.repository

import br.com.vitorino.templatehexagonalarch.person.mapper.PersonMapper
import br.com.vitorino.templatehexagonalarch.person.model.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component
class PersonRepo(private val mapper: PersonMapper,
                 private val repository: PersonRepository) : IPersonRepo<Person, String> {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun save(person: Person): Person {

        var entity = mapper.mapModelToEntity(person)
        entity.id = UUID.randomUUID().toString()

        runCatching {
            log.info("Salvando a Entity {}", entity)
            entity = repository.save(entity)
            log.info("Entity salva com sucesso {}", entity)
        }.onFailure {
            log.error("Erro ao salvar a entity {} {}", entity, it)
            throw it
        }

        return mapper.mapEntityToModel(entity)
    }

    override fun existsByEmail(email: String): Boolean {
        return repository.existsByEmail(email)
    }

    override fun findById(id: String): Optional<Person> {
        log.info("Buscando Person byId {}", id)

        var optionalPerson: Optional<Person> = Optional.empty()

        runCatching {
            repository.findById(id).takeIf { it.isPresent }
                    .apply {
                        val personEntity = requireNotNull(this).get()

                        log.info("PersonEntity encontrada {} com id {}", personEntity, id)

                        val person = mapper.mapEntityToModel(personEntity)

                        optionalPerson = Optional.of(person)
                    }.run {
                        log.info("Person nao foi encontrada com id {}", id)
                    }
        }.onFailure {
            log.error("Erro ao buscar Person com Id {} exception {}", id, it)
            throw it
        }

        return optionalPerson
    }
}