package br.com.digitalhouse.desafio

fun main() {
    var digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarProfessorTitular("Rafael", "Nalon",123,"Swift")
    digitalHouseManager.registrarProfessorTitular("Bruno", "Moretti",124,"Kotlin")

    digitalHouseManager.registrarProfessorAdjunto("Igor","Chagas",1234,10)
    digitalHouseManager.registrarProfessorAdjunto("Carol","Peruzeto",1235,15)

    digitalHouseManager.registrarCurso("Full Stack",20001,3)
    digitalHouseManager.registrarCurso("Android",20002,2)

    digitalHouseManager.matricularAluno("Fernando","Vasconcelos",123)
    digitalHouseManager.matricularAluno("Maria","Vasconcelos",124)
    digitalHouseManager.matricularAluno("Joaquim","Vasconcelos",125)
    digitalHouseManager.matricularAluno("Cacique","Vasconcelos",126)
    digitalHouseManager.matricularAluno("Bazile","Vasconcelos",127)

    try {
        //    var professorTitular1 = ProfessorTitular("Rafael", "Nalon",5,123,"Swift")
//    var professorTitular2 = ProfessorTitular("Bruno", "Moretti",2,124,"Kotlin")
//    var professorAdjunto1 = ProfessorAdjunto("Igor","Chagas",1,1234,15)
//    var professorAdjunto2 = ProfessorAdjunto("Carol","Peruzeto",1,1235,18)


//    var curso1 = Curso("Full Stack",20001,3)
//    var curso2 = Curso("Android",20002,2)

        digitalHouseManager.alocarProfessores(20001,123,1234)
        digitalHouseManager.alocarProfessores(20002,124,1235)



        digitalHouseManager.matricularAlunoCurso(123,20001)
        digitalHouseManager.matricularAlunoCurso(124,20001)



        digitalHouseManager.matricularAlunoCurso(125,20002)

        digitalHouseManager.matricularAlunoCurso(126,20002)

        digitalHouseManager.matricularAlunoCurso(127,20002)

        digitalHouseManager.visualizarInf(123)

        digitalHouseManager.excluirCurso(20002)

        digitalHouseManager.excluirProfessor(123)

        digitalHouseManager.excluirAlunoCurso(123)





        //    println(digitalHouseManager.listaCursos[0].professorTitular.nome)
    //    println(digitalHouseManager.listaCursos[0].professorTitular.codProfessor)
    //    println(digitalHouseManager.listaCursos[0].professorTitular.especialidade)
    //    println(digitalHouseManager.listaCursos[0].nome)
    //
    //    println(digitalHouseManager.listaCursos[0].professorAdjunto.nome)
    //    println(digitalHouseManager.listaCursos[0].professorAdjunto.codProfessor)
    } catch (ex: Exception){
        println(ex.message)
    }





}