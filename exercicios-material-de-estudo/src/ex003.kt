fun main(){
    exibirMenu()
}

private fun exibirMenu() {
    var opcao: Int
    do {
        println("# Menu Principal #")
        println("1 - Somar vários números reais")
        println("2 - Gerar número aleatório")
        println("3 - Leitura de números positivos e negativos")
        println("4 - Sair")

        opcao = getOpcao()

        when (opcao.toInt()) {
            1 -> somarNumerosReais()
            2 -> {}
            3 -> {}
            4 -> println("Saindo...")
        }

    } while (opcao != 4)
}

private fun getOpcao(): Int {
    val regexOp = Regex("^[1-4]\$")
    var opcao = ""
    do {
        print("Insira uma opção: ")
        opcao = readln().toString()
        var valida: Boolean = regexOp.matches(opcao)

        if (!valida) {
            println("Opção inválida!")
        }
    } while (!valida)

    if (opcao.toIntOrNull() == null) {
        return 0
    }
    return opcao.toInt()
}

fun somarNumerosReais() {
    var quanti = getQuanti()
    var lista = mutableListOf<Float>()
    montarLista(quanti, lista)

    var soma = 0F

    for (numero in lista) {
        soma += numero
    }

    println("Resultado da soma: $soma")
}

private fun getQuanti(): String {
    // # Anotações sobre a expressão regular #
    // ^ -> marca o início da string
    // [1-9] -> indica que o primeiro dígito deve estar entre 1 e 9
    // \\d* -> indica que a string pode ter 0 ou mais dígitos adicionais
    // $ -> indica o fim da string
    // val regex = Regex("^[1-9]\\d*\$")

    // mudei para uma opção que limita a quantidade para o máximo de 99
    // pq acho q faz mais sentido :)
    // ? -> indica que o segundo dígito é opcional

    val regex = Regex("^[1-9][0-9]?\$")
    var quanti = ""
    do {
        print("Informe quantos números deseja informar (de 1 até 99): ")
        quanti = readln().toString()
        var valida: Boolean = regex.matches(quanti)

        if (!valida) {
            println("Opção inválida!")
        }
    } while (!valida)
    return quanti
}

private fun montarLista(quanti: String, lista: MutableList<Float>) {
    for (i in 1..quanti.toInt()) {
        do {
            print("Número $i: ")
            var input = readln().toString()
            input = input.replace(',', '.')

            var valida: Boolean = validaNumero(input)
            if (!valida) {
                println("Número inválido!")
                continue
            }
            lista.add(input.toFloat())
        } while (!valida)
    }
}

fun validaNumero(input: String): Boolean {
    return input.toFloatOrNull() != null
}