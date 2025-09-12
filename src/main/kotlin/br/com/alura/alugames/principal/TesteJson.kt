package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.services.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()
    val listaJogoJson = consumoApi.buscaJogosJson()

    val gamerCaroline = listaGamers.get(3)
    val jogoREVillage = listaJogoJson.get(10)

    println(gamerCaroline)
    println(jogoREVillage)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))

    val aluguel = gamerCaroline.alugarJogo(jogoREVillage, periodo)

    println(aluguel)
}