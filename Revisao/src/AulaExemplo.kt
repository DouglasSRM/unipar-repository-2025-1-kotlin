fun main(){
    var gato = Gato()
    gato.nome = "Gato"
    gato.dieta = "Peixe"
    gato.habitat = "Apartamento"
    gato.especie = "Felino"

    //val gato: Gato = animal as Gato // Não recomentado

    println(gato.nome)

    println(gato.somAnimal())

    var cachorro = Cachorro()
    cachorro.nome = "Cachorro"
    cachorro.dieta = "Ração"
    cachorro.habitat = "Quintal"
    cachorro.especie = "Canino"

    println(cachorro.nome)
    println(cachorro.somAnimal())

    var capivara = Capivara()
    capivara.nome = "Capivara"
    capivara.dieta = "Peixe"
    capivara.habitat = "Lago"
    capivara.especie = "Roedor"

    println(capivara.nome)
    println(capivara.somAnimal())

    val listaDeAnimais: MutableList<Animal> = ArrayList()

    listaDeAnimais.add(gato)
    listaDeAnimais.add(cachorro)
    listaDeAnimais.add(capivara)

    println(listaDeAnimais[2].habitat)
}