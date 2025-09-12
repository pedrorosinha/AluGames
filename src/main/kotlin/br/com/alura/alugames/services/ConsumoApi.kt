package br.com.alura.alugames.services

import br.com.alura.alugames.model.*
import br.com.alura.alugames.utils.criaJogo
import br.com.alura.alugames.utils.criarGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    private fun getJsonFromUrl(url: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body()
    }

    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = getJsonFromUrl(endereco)
        val gson = Gson()
        return gson.fromJson(json, InfoJogo::class.java)
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = getJsonFromUrl(endereco)
        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaGamers: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamers.map { infoGamerJson ->
            infoGamerJson.criarGamer()
        }

        return listaGamerConvertida
    }

    fun buscaJogosJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = getJsonFromUrl(endereco)

        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }

        return listaJogoConvertida
    }
}
