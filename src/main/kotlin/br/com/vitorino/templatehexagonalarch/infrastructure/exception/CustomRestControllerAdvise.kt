package br.com.vitorino.templatehexagonalarch.infrastructure.exception

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.Exception

@RestControllerAdvice
class CustomRestControllerAdvise(private val validationResult: ValidationResult) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler
    fun handleBadRequestException(exception: BadRequestException): ResponseEntity<Any> {
        log.error("{} {}", exception, validationResult.errors)
        return ResponseEntity.badRequest().build()
    }

    @ExceptionHandler
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<Any> {
        log.error("{}", exception)
        return ResponseEntity.notFound().build()
    }

    @ExceptionHandler
    fun handlePersonBannedException(exception: PersonBannedException): ResponseEntity<Any> {
        log.error("{}", exception)
        return ResponseEntity.unprocessableEntity().body("{\"exception\":\"Person is banned\"}")
    }

    @ExceptionHandler
    fun handleEmailAlreadyException(exception: EmailAlreadyException): ResponseEntity<Any> {
        log.error("{}", exception)
        return ResponseEntity.unprocessableEntity().body(FieldError(field = "email", message = "email already"))
    }

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<Any> {
        log.error("{}", exception)
        return ResponseEntity.internalServerError().build()
    }

}