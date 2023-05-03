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
        }.onSuccess {
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
        val optionalPersonEntity = repository.findById(id)
        optionalPersonEntity.takeIf { it.isPresent }
                .apply {
                    val entity = optionalPersonEntity.get()
                    log.info("Person byId {} obtida com sucesso {}", id, entity)
                    return Optional.of(mapper.mapEntityToModel(entity))
                }.run {
                    log.info("Person byId {} nao encontrou a entidade", id)
                    return Optional.empty()
                }
    }
}