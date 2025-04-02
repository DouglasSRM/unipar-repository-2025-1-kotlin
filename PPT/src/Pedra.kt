class Pedra {
    fun luta(elemento: String): Int{
        if(elemento == "PAPEL"){
            println("Você perdeu!")
            return -1
        }
        if(elemento == "TESOURA"){
            println("Você ganhou!")
            return 1
        }
        println("Empate!")
        return 0
    }
}