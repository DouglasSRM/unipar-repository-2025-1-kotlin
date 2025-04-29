package br.unipar.pokedex.service

import br.unipar.pokedex.model.Pokemon
import br.unipar.pokedex.model.Tipo
import br.unipar.pokedex.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class PokemonService (
    private val pokemonRepository: PokemonRepository
){
    fun registrarPokemon(
        numeroPokedex: String,
        nome: String,
        tipo_1: Tipo,
        tipo_2: Tipo?,
        poder: Int,
        descricao: String?
    ): Pokemon{
        return pokemonRepository.salvar(
            Pokemon(
                numeroPokedex = numeroPokedex,
                nome = nome,
                tipo_1 = tipo_1,
                tipo_2 = tipo_2,
                poder = poder,
                descricao = descricao
            )
        )
    }
}