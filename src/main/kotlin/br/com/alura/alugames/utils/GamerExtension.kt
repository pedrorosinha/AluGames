package br.com.alura.alugames.utils

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.InfoGamerJson

fun InfoGamerJson.criarGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}