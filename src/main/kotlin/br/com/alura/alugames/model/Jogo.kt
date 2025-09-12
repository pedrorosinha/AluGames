package br.com.alura.alugames.model

data class Jogo(val titulo: String, val capa: String) {
    var descricao: String? = null

    override fun toString(): String {
        return "Meu jogo: " + "Titulo: $titulo\n" + "Capa: $capa\n" + "Descricao: $descricao"
    }

}