package br.com.vitorino.templatehexagonalarch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy
class Start

fun main(args: Array<String>) {
	runApplication<Start>(*args)
}
