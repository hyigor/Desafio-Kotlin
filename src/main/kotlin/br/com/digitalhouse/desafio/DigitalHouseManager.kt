package br.com.digitalhouse.desafio

import java.util.*

class DigitalHouseManager {
    var listaAlunos = mutableListOf<Aluno>()
    var listaProfessores = mutableListOf<Professor>()
    var listaCursos = mutableListOf<Curso>()
    var listaMatricula = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int,
                       quantidadeMaximaDeAlunos: Int)  {
        val curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)
        listaCursos.add(curso)
    }
    fun excluirCurso(codigoCurso: Int) {
        var ver = false
        var i = 0
        for (curso in listaCursos) {
            ver = codigoCurso.equals(curso.codCurso)
            if (ver) {
                listaCursos.removeAt(i)
                println("O curso foi excluido!")
                break
            }
            i++
        }
        if(ver == false){
            throw Exception("Esse curso não existe.")
        }
    }
    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        listaProfessores.add(professorAdjunto)
    }
    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val professorTitular = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
        listaProfessores.add(professorTitular)
    }
    fun excluirProfessor(codigoProfessor: Int){
        var verProf = false
        var i = 0
        for (professor in listaProfessores) {
            verProf = codigoProfessor.equals(professor.codProfessor)
            if ( verProf) {
                listaProfessores.removeAt(i)
                println("Professor excluido!")
                break
            }
            i++
        }
        if(verProf == false){
            throw Exception("O professor Adjunto não existe.")
        }
    }
    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val aluno = Aluno(nome, sobrenome, codigoAluno)
        listaAlunos.add(aluno)
        println("Matriculado! $nome $codigoAluno")
    }
    fun excluirAlunoCurso(codigoAluno: Int){
        var ver= false
        var alu: Aluno? = null


        for (ma in listaMatricula) {
            ver = codigoAluno.equals(ma.aluno.codAluno)
            if (ver) {
                alu = ma.aluno
                ma.curso.excluirALuno(alu)
                println("Aluno excluido do curso de ${ma.curso.nome}")
                break
            }
        }
        if(ver == false){
            throw Exception("O aluno não existe.")
        }
    }

    fun matricularAlunoCurso(codigoAluno: Int, codigoCurso: Int) {
        var alu: Aluno? = null
        var cur2: Curso? = null
        var ver = false
        var verCur = false
        for (aluno in listaAlunos) {
            ver = codigoAluno.equals(aluno.codAluno)
            if (ver) {
                alu = aluno
                break
            }
        }
        if(ver == false){
            throw Exception("O aluno não existe.")
        }
        for (curso in listaCursos) {
            verCur = codigoCurso.equals(curso.codCurso)
            if (verCur) {
                cur2 = curso
                break
            }
        }
        if(verCur == false){
            throw Exception("Esse curso não existe.")
        }
        if (alu != null && cur2 != null) {
            val matricula = Matricula(alu, cur2, Date())
            listaMatricula.add(matricula)
            if(cur2.adicionarUmAluno(alu)){
                println("Matricula efetuada!")
            } else {
                println("Esse curso já está cheio")
            }
        }
    }
    fun alocarProfessores(codigoCurso: Int, codigoProfessor: Int, codigoProfessorAdjunto: Int) {
        var pti: ProfessorTitular? = null
        var pad: ProfessorAdjunto? = null
        var cur: Curso? = null
        var verProfT = false
        var verProfA = false
        var verCur = false
        for (professorTit in listaProfessores) {
            verProfT = codigoProfessor.equals(professorTit.codProfessor)
            if (verProfT) {
                pti = professorTit as ProfessorTitular
                break
            }
        }
        if(verProfT == false){
            throw Exception("O professor não existe.")
        }
        for (professorAdj in listaProfessores) {
            verProfA = codigoProfessorAdjunto.equals(professorAdj.codProfessor)
            if ( verProfA) {
                pad = professorAdj as ProfessorAdjunto
                break
            }
        }
        if(verProfA == false){
            throw Exception("O professor Adjunto não existe.")
        }
        for (curs in listaCursos) {
            verCur = codigoCurso.equals(curs.codCurso)
            if (verCur) {
                cur = curs
                break
            }
        }
        if(verCur == false){
            throw Exception("Esse curso não existe.")
        }
        if (pti != null) {
            cur?.professorTitular = pti
        }
        if (pad != null) {
            cur?.professorAdjunto = pad
        }
    }
    fun visualizarInf(codigoAluno: Int) {
        var ver = false
            for (ma in listaMatricula) {
                ver = codigoAluno.equals(ma.aluno.codAluno)
                if ( ver) {
                    println("O curso que esse aluno faz é de ${ma.curso.nome}")
                    break
                }
        }
        if (ver == false){
            throw Exception("Esse aluno não existe")
        }
    }
}