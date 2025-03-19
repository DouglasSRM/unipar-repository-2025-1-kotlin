fun main() {
    while (true) {
        var resposta = readlnOrNull()?.toIntOrNull();

        val fibonacciArray = IntArray(readlnOrNull()?.toIntOrNull()!!)

        if (resposta != null && resposta > 0) {


            if (resposta > 0) fibonacciArray[0] = 1
            if (resposta > 1) fibonacciArray[1] = 1


            for (i in 2 until resposta!!) {
                fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2]
            }
        } else {
            println("Valor inválido!")
        }

        println(fibonacciArray[resposta - 1])
    }
}