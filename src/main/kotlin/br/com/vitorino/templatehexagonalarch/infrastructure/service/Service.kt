package br.com.vitorino.templatehexagonalarch.infrastructure.service

interface Service<T,K> {

    fun call(o:T): K

}