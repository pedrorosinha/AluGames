package br.com.alura.alugames.principal

import br.com.alura.alugames.enums.TipoPlano
import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.services.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()
    val listaJogoJson = consumoApi.buscaJogosJson()

    val gamerCaroline = listaGamers[3]
    val jogoREVillage = listaJogoJson[10]
    val jogoSpider = listaJogoJson[13]
    val jogoTLOU1 = listaJogoJson[2]

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(11))

    gamerCaroline.alugarJogo(jogoREVillage, periodo1)
    gamerCaroline.alugarJogo(jogoSpider, periodo2)
    gamerCaroline.alugarJogo(jogoTLOU1, periodo3)

    val gamerCamila = listaGamers[5]
    gamerCamila.plano = PlanoAssinatura(TipoPlano.PRATA, 9.90, 3)

    gamerCamila.alugarJogo(jogoREVillage, periodo1)
    gamerCamila.alugarJogo(jogoSpider, periodo2)
    gamerCamila.alugarJogo(jogoTLOU1, periodo3)
    gamerCamila.alugarJogo(jogoTLOU1, periodo3)

    println(gamerCamila.jogosAlugados)
}