package br.com.alura.alugames.principal

import br.com.alura.alugames.services.ConsumoApi

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()
    val listaJogoJson = consumoApi.buscaJogosJson()

    val gamerCaroline = listaGamers.get(3)
    val jogoREVillage = listaJogoJson.get(10)

    println(gamerCaroline)
    println(jogoREVillage)

    val aluguel = gamerCaroline.alugarJogo(jogoREVillage)

    println(aluguel)
}