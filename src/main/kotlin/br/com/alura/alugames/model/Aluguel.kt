package br.com.alura.alugames.model

data class Aluguel(val gamer: Gamer, val jogo: Jogo) {
    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} foi alugado por ${gamer.nome}"
    }
}
