fun main(){
    val regex = Regex("^(?:[2-9]|\\d{2,})$")
    var numero: String

    do {
        println("Digite um número acima de 1: ")
        numero = readln()
    } while (!regex.matches(numero))

    println(fibonnaci(numero.toInt()))
}

fun fibonacci(n: Int): Int {
    if (n<=1){
        return n
    }

    return fibonnaci(n - 1) + fibonnaci(n - 2)
}