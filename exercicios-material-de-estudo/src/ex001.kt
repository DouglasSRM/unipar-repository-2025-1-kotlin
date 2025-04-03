fun main() {
    println("SOMAR!")

    print("Insira o primeiro numero: ")
    val n1: Int = readln().toInt()

    print("Insira o segundo numero: ")
    val n2: Int = readln().toInt()

    val soma = n1 + n2

    println("A soma de ${n1} e ${n2} é ${soma}!")
}