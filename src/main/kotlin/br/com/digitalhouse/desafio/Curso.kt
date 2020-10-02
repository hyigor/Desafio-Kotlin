package br.com.digitalhouse.desafio

class Curso(var nome: String, var codCurso: Int, var quantMaxAluno: Int) {
    lateinit var professorTitular: ProfessorTitular
    lateinit var professorAdjunto: ProfessorAdjunto
    var alunosMatriculados = mutableListOf<Aluno>()


    override fun equals(other: Any?): Boolean {
        other as Curso
        return this.codCurso == other.codCurso && this == other
    }

    fun adicionarUmAluno(umAluno: Aluno) : Boolean{
        if (alunosMatriculados.size == quantMaxAluno){
            return false
        } else{
            alunosMatriculados.add(umAluno)
            return true
        }

    }

    fun excluirALuno(umAluno: Aluno){
        var ver = false
        var i = 0
        for (aluno in alunosMatriculados){
            ver = umAluno.codAluno.equals(aluno.codAluno)
            if (ver == true){
                alunosMatriculados.removeAt(i)
                break
            }
            i++
        }
        if(ver == false){
            throw Exception("Esse aluno não existe.")
        }
    }

}