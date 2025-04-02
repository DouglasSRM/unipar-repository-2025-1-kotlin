class Papel {
    fun luta(elemento: String): Int{
        if(elemento == "TESOURA"){
            println("Você perdeu!")
            return -1
        }
        if(elemento == "PEDRA"){
            println("Você ganhou!")
            return 1
        }
        println("Empate!")
        return 0
    }
}