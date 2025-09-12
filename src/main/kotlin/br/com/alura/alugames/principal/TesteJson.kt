package br.com.alura.alugames.principal

import br.com.alura.alugames.services.ConsumoApi

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()

    println(listaGamers)
}