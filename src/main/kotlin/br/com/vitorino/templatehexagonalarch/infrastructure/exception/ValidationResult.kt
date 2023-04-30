package br.com.vitorino.templatehexagonalarch.infrastructure.exception

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@RequestScope
@Component
class ValidationResult(val errors: ArrayList<FieldError> = arrayListOf())