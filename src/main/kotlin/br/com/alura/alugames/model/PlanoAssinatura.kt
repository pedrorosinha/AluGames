package br.com.alura.alugames.model

import br.com.alura.alugames.enums.TipoPlano

class PlanoAssinatura(tipo: TipoPlano, val mensalidade: Double, val jogosIncluidos: Int) : Plano(tipo) {}