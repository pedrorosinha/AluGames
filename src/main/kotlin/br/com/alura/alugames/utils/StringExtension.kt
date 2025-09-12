package br.com.alura.alugames.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformarEmIdade(): Int {
    val regex = Regex("""\d{1,2}/\d{1,2}/\d{2,4}""")
    require(this.matches(regex)) { "Data em formato inválido. Use dd/MM/yyyy" }
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataNascimento = LocalDate.parse(this, formatter)
    val hoje = LocalDate.now(java.time.ZoneId.of("America/Sao_Paulo"))
    check(!dataNascimento.isAfter(hoje)) { "Data de nascimento não pode ser futura." }
    return Period.between(dataNascimento, hoje).years
}