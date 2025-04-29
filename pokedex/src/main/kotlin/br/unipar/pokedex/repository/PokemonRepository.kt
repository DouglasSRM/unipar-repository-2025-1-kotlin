package br.unipar.pokedex.repository

import br.unipar.pokedex.model.Pokemon
import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Repository

@Repository
class PokemonRepository(
    private val firestore : Firestore = FirestoreClient.getFirestore()//Buscar em um JSON
) {
    private val collectionName = "pokedex" //O nome da coleção é o que está no firebase

    fun salvar (pokemon: Pokemon): Pokemon{
        val documento = firestore.collection(collectionName).document(pokemon.numeroPokedex!!)//Busca um documento pelo ID

        val pokemonRegistrado = pokemon.copy(numeroPokedex = documento.id)//Cópia do que foi resgatado do banco
        documento.set(pokemonRegistrado)//Edita ou cria os valores de cada CHAVE
        return pokemonRegistrado
    }

}