import kotlin.text.replace

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
            2 -> gerarNumeroAleatorio()
            3 -> {}
            4 -> println("Saindo...")
        }

    } while (opcao != 4)
}

private fun gerarNumeroAleatorio() {
    println("# Gerar número aleatório #")
    var inicio: Int = 0
    var fim: Int = 0

    do {
        inicio = getInt("Insira o número inicial: ")
        fim = getInt("Insira o número final: ")

        if (inicio > fim) {
            println("O número final deve ser maior que o número inicial! Tente novamente.")
        }
    } while (inicio > fim)

    var resultado = (inicio..fim).random()
    println("Número gerado: $resultado")

    print("Pressione ENTER para voltar ao menu")
    readln().toString()
}

private fun somarNumerosReais() {
    var quanti = getInt("Informe quantos números deseja informar (de 1 até 99): ", Regex("^[1-9][0-9]?\$"))
    var lista = mutableListOf<Float>()
    montarLista(quanti, lista)

    var soma = 0F
    var resultado = ""

    for (i in 0..((quanti.toInt()) - 1)) {
        soma += lista[i]
        if (i == 0) {
            resultado = lista[i].toString()
            continue
        }
        resultado += " + " + lista[i]
    }

    println("# Resultado da soma #")
    println("$resultado: $soma")

    print("Pressione ENTER para voltar ao menu")
    readln().toString()
}

// # Anotações sobre a expressão regular #
// ^ -> marca o início da string
// [1-9] -> indica que o primeiro dígito deve estar entre 1 e 9
// \\d* -> indica que a string pode ter 0 ou mais dígitos adicionais
// $ -> indica o fim da string
//"^[1-9]\\d*\$"
private fun getInt(mensagem: String = "Informe um número: ",
                      regex: Regex = Regex("^-?\\d+\$"),
                   msgInvalida: String = "Número inválido!"): Int {
    var numero = ""
    do {
        print(mensagem)
        numero = readln().toString()
        var valida: Boolean = regex.matches(numero)

        if (!valida) {
            println(msgInvalida)
        }
    } while (!valida)
    return numero.toInt()
}

private fun montarLista(quanti: Int, lista: MutableList<Float>) {
    for (i in 1..quanti) {
        lista.add(getFloat("Número $i: "))
    }
}

private fun getFloat(mensagem: String = "Informe um número: "): Float {
    var numero = ""
    do {
        print(mensagem)
        numero = readln().toString()
        numero = numero.replace(',', '.')
        var valida: Boolean = validaNumero(numero)

        if (!valida) {
            println("Opção inválida!")
        }
    } while (!valida)
    return numero.toFloat()
}
private fun validaNumero(input: String): Boolean {
    return input.toFloatOrNull() != null
}

private fun getOpcao(): Int {
    return getInt("Insira uma opção: ", Regex("^[1-4]\$"), "Opção inválida!")
}