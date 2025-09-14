package br.com.alura.alugames.model

data class Jogo(
    val titulo: String, val capa: String
) : Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    private val listaDeNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaDeNotas.average()

    override fun recomendar(nota: Int) {
        listaDeNotas.add(nota)
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "\nMeu Jogo: \nTítulo: $titulo \nCapa: $capa \nDescricao: $descricao \nPreço: $preco \nReputação: $media"
    }
}