package br.com.alura.alugames.model

data class Aluguel(val gamer: Gamer, val jogo: Jogo, val periodo: Periodo) {

    val valorAluguel = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "\nAluguel do ${jogo.titulo} foi alugado por ${gamer.nome} pelo valor de R$$valorAluguel"
    }
}
