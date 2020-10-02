package br.com.digitalhouse.desafio

class Aluno (val nome: String, val sobrenome: String, var codAluno: Int) {

    override fun equals(other: Any?): Boolean {
        other as Aluno
        return this.codAluno == other.codAluno && this == other
    }


}