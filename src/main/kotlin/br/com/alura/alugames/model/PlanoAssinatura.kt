package br.com.alura.alugames.model

import br.com.alura.alugames.enums.TipoPlano

class PlanoAssinatura(
    tipo: TipoPlano, val mensalidade: Double, val jogosIncluidos: Int, val percentualDescontoReputacao: Double
) : Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1

        return if (totalJogosNoMes <= jogosIncluidos) 0.0
        else {
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal
        }
    }
}