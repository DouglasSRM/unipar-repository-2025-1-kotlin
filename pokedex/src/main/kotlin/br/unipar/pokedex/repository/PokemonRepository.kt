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

    fun buscarId(): List<Pokemon> {
        val query = firestore.collection(collectionName)
            .get().get() //Retorna todos os documentos da coleção
        //a query vem em vários JSON, basta converter para uma lista um de cada vez
        return query.documents.mapNotNull {pokemons ->
            pokemons.toObject(Pokemon::class.java)
        }
    }

    fun excluirId(numeroPokedex: String): Boolean{
        //Busca um documento igual na buscaID, mas aqui deleta ele
        firestore.collection(collectionName).document(numeroPokedex).delete()
        return true
    }
    
}
