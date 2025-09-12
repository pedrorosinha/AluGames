package br.com.alura.alugames.utils

import br.com.alura.alugames.model.InfoJogoJson
import br.com.alura.alugames.model.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}