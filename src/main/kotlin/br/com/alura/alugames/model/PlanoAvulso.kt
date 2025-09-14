package br.com.alura.alugames.model

import br.com.alura.alugames.enums.TipoPlano

class PlanoAvulso(tipo: TipoPlano) : Plano(tipo) {
    override fun obterValor(aluguel: Aluguel): Double {
        var valorOriginal = super.obterValor(aluguel)
        if (aluguel.gamer.media > 8) valorOriginal -= valorOriginal * 0.1
        return valorOriginal
    }
}
