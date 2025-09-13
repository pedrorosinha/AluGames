package br.com.alura.alugames.model

import br.com.alura.alugames.enums.TipoPlano

open class Plano(val tipo: TipoPlano) {
    open fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
