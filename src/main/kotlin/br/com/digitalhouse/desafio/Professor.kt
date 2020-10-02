package br.com.digitalhouse.desafio

abstract class Professor( val nome: String, val sobrenome: String, var tempoCasa: Int, var codProfessor: Int) {

    override fun equals(other: Any?): Boolean {
        other as Professor
        return this.codProfessor == other.codProfessor && this == other
    }


}