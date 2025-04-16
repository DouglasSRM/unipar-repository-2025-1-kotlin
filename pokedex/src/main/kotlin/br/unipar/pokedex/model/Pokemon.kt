package br.unipar.pokedex.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero

@Entity
class Pokemon (
    @Id
    var numeroPokedex: Int,

    @NotBlank
    var nome: String,

    @NotBlank
    var tipo_1: Tipo,

    var tipo_2: Tipo?,

    @PositiveOrZero
    var poder: Int
)