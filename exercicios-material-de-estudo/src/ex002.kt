
fun main() {
    var lista = mutableListOf<String>()
    val regexAlfa = Regex("^[a-zA-Z]+\$")
    val regexSN = Regex("^[SN]+\$")

    var resposta: String = ""
    var nome: String = ""
    var validaResposta: Boolean = false

    println("Bem vindo a lista!")
    do {
        print("Nome: ")
        nome = readLine().toString()

        if (!regexAlfa.matches(nome)) {
            println("Nome inválido!")
            continue
        }
        lista.add(nome)

        do {
            println("Deseja inserir um novo nome? [s/n]")
            resposta = readLine()!!.toString().toUpperCase()
            validaResposta = regexSN.matches(resposta)

            if (!validaResposta) {
                println("Resposta inválida!")
            }
        } while(!validaResposta)

    } while (resposta != "N")

    println("Segue abaixo a lista completa:")
    for (nome in lista) {
        println(nome)
    }
}