package br.com.alura.alugames.principal

import br.com.alura.alugames.enums.TipoPlano
import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.services.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()
    val listaJogoJson = consumoApi.buscaJogosJson()

    val gamerCaroline = listaGamers[3]
    val jogoREVillage = listaJogoJson[10]
    val jogoSpider = listaJogoJson[13]
    val jogoTLOU1 = listaJogoJson[2]
    val jogoDandara = listaJogoJson[5]
    val jogoAssassins = listaJogoJson[4]
    val jogoCyber = listaJogoJson[6]
    val jogoGod = listaJogoJson[7]
    val jogoSkyrim = listaJogoJson[18]

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(11))

    gamerCaroline.alugarJogo(jogoREVillage, periodo1)
    gamerCaroline.alugarJogo(jogoSpider, periodo2)
    gamerCaroline.alugarJogo(jogoTLOU1, periodo3)

    val gamerCamila = listaGamers[5]
    gamerCamila.plano = PlanoAssinatura(TipoPlano.PRATA, 9.90, 3, 0.15)

    gamerCamila.alugarJogo(jogoREVillage, periodo1)
    gamerCamila.alugarJogo(jogoSpider, periodo2)
    gamerCamila.alugarJogo(jogoTLOU1, periodo3)
    gamerCamila.alugarJogo(jogoTLOU1, periodo3)

//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)

//    println(gamerCamila)

    gamerCamila.alugarJogo(jogoREVillage, periodo1)
//    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoREVillage, 7)
    gamerCamila.recomendarJogo(jogoTLOU1, 10)

    gamerCaroline.recomendarJogo(jogoREVillage, 8)
    gamerCaroline.recomendarJogo(jogoTLOU1, 9)

//    println("Recomendações da Camila:")
//    println(gamerCamila.jogosRecomendados)
//
//    println("Recomendações da Caroline:")
//    println(gamerCaroline.jogosRecomendados)

    gamerCamila.recomendarJogo(jogoREVillage, 7)
    gamerCamila.recomendarJogo(jogoTLOU1, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)
}