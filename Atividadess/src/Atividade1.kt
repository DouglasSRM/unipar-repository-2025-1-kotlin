fun main(){
    val regex = Regex("^(?:[2-9]|\\d{2,})$")
    var numero: String

    do {
        println("Digite um número acima de 1: ")
        numero = readln()
    } while (!regex.matches(numero))

    println(fibonacci(numero.toInt()))
}

fun fibonacci(n: Int): Int {
    if (n<=1){
        return n
    }

    return fibonacci(n - 1) + fibonacci(n - 2)
}