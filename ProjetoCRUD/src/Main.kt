var listaDeConvidados = mutableListOf<Convidado>()

fun main() {


    menu()
}

private fun menu() {
    do {
        println("1 - CRIAR")
        println("2 - LISTAR")
        println("3 - EDITAR")
        println("4 - EXCLUIR")
        println("0 - SAIR")
        val op = readln() //VALIDAR!

        when (op.toInt()) {//Opções do menu
            1 -> criar()
            2 -> println("LISTAR")
            3 -> println("EDITAR")
            4 -> println("EXCLUIR")
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
    val sexo = readln()
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