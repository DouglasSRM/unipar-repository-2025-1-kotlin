package br.unipar.pokedex.controller

import br.unipar.pokedex.model.Pokemon
import br.unipar.pokedex.service.PokemonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PokedexController (
    private val pokemonService: PokemonService
){

    fun cadastrarPokemons(@RequestBody pokemon: Pokemon) : ResponseEntity<Pokemon> {
        return ResponseEntity.ok(
            pokemonService.registrarPokemon(
                pokemon.numeroPokedex!!,
                pokemon.nome,
                pokemon.tipo_1,
                pokemon.tipo_2,
                pokemon.poder,
                pokemon.descricao
            )
        )
    }
}