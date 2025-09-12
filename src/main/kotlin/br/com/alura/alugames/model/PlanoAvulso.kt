package br.com.alura.alugames.model

import br.com.alura.alugames.enums.TipoPlano

data class PlanoAvulso(val tipo: TipoPlano) {
    fun obterValor(aluguel: Aluguel) : Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
