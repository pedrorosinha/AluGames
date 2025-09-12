package br.com.alura.alugames.model

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo) {

    val valorAluguel = jogo.preco * periodo.emDias

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} foi alugado por ${gamer.nome} pelo valor de R$$valorAluguel"
    }
}
