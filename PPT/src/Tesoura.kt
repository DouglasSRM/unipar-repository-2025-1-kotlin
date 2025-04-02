class Tesoura {
    fun luta(elemento: String): Int{
        if(elemento == "PEDRA"){
            println("Você perdeu!")
            return -1
        }
        if(elemento == "PAPEL"){
            println("Você ganhou!")
            return 1
        }
        println("Empate!")
        return 0
    }
}