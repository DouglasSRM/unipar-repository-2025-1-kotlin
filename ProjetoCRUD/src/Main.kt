var listaDeConvidados: MutableList<Convidado> = mutableListOf<Convidado>()

fun main() {
    menu()
}

private fun menu() {
    do {
        println("\n1 - CRIAR")
        println("2 - LISTAR")
        println("3 - EDITAR")
        println("4 - EXCLUIR")
        println("0 - SAIR")
        val op = readln() //VALIDAR!

        when (op.toInt()) {//Opções do menu
            1 -> criar()
            2 -> listar()
            3 -> editar()
            4 -> excluir()
            5 -> buscar()
            0 -> println("Saindo...")
        }
    } while (op.toInt() != 0)
}

private fun criar() {
    println("CRIAR")
    print("Nome do convidado: ")
    val nome = readln()

    print("Qual o seu presente: ")
    val presente = readln()

    print("Alguma restrição alimentar? ")
    val restricao = readln()

    print("Sexo: M ou F")
    val regex = Regex("^[MF]$")
    val sexo = readln()
    if(regex.matches(sexo)) {
        when (sexo) {
            "M" -> {
                val homem: Homem = Homem()
                homem.nome = nome
                homem.restricao = restricao
                homem.vestuario = presente

                listaDeConvidados.add(homem)
            }

            "F" -> {
                val mulher: Mulher = Mulher()
                mulher.nome = nome
                mulher.restricao = restricao
                mulher.brinquedo = presente

                listaDeConvidados.add(mulher)
            }
        }
    }
}

private fun listar() {
    var i = 0

    listaDeConvidados.forEach {convidado ->
        print("Posição: ${i++}, "+
                "nome: ${convidado.nome}, "+
                "alimentação: ${convidado.restricao}, "+
                "presente: ")

    }
}

private fun excluir() {
    if(validar()){
        listar()
        println("Qual posição deseja remover o convidado: ")
        val regex = readln
    }


}

private fun validar(): Boolean {
    if(listaDeConvidados.isEmpty()){
        println("Sem convidados")]
        return false
    }
    return true
}

private fun editar() {
    TODO("Not yet implemented")
}

private fun buscar() {
    TODO("Not yet implemented")
}