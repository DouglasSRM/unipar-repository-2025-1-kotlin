var pontos = 0
var jogadores = mutableListOf<String>()
var pontosJogadores = mutableListOf<Int>()

fun main() {
    do {
        println("1 - JOGAR")
        println("2 - PLACAR")
        println("3 - SAIR")
        val opcao: String = readln()
        when (opcao.toInt()) {
            1 -> jogar()
            2 -> placar()
            3 -> println("saindo...")
        }
    }while (opcao.toInt() != 3)
}

fun jogar() {
    print("Digite seu nickname: ")
    var nickname = readLine().toString()

    println("QUE OS JOGOS COMEÇEM!")
    var rodadas = 1
    do{
        println("Faça a sua jogada!")
        println("PEDRA, PAPEL OU TESOURA?")
        var movimento = readln().uppercase()
        var movimentoPC = computador()
        println("O computador jogou: $movimentoPC")

        when (movimento) {
            "PEDRA" -> {
                var  pedra = Pedra()
                pontos += pedra.luta(movimentoPC)
            }
            "PAPEL" -> {
                var papel = Papel()
                pontos += papel.luta(movimentoPC)
            }
            "TESOURA" -> {
                var tesoura = Tesoura()
                pontos += tesoura.luta(movimentoPC)
            }
        }
        rodadas++
        println("NOVA RODADA!")
    }while(rodadas <= 3)
    jogadores.add(nickname)
    pontosJogadores.add(pontos)
}

fun computador(): String {
    val movimento = (1..3).random()
    when(movimento){
        1 -> return "PEDRA"
        2 -> return "PAPEL"
        3 -> return "TESOURA"
        else -> return ""
    }
}

fun placar() {
    println("JOGADORES: ")
    jogadores.forEach {
        println(it)
    }
    println("PONTOS: ")
    pontosJogadores.forEach {
        println(it)
    }
}