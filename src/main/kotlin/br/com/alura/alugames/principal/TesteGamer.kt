package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Gamer

fun main() {
    val gamer1 = Gamer("Felipe", "felipe@gmail.com", "22/12/2005", "felipinho")
    println(gamer1)

    val gamer2 = Gamer("Beltrano", "beltrano@gmail.com")

    gamer2.let {
        it.dataNascimento = "27/05/2014"
        it.usuario = "teste"
    }.also {
        println(gamer1.idInterno)
    }
    println(gamer1)

    gamer1.usuario = "usuario"
    println(gamer1)

    println(gamer2)
}