package br.unipar.pokedex.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Pokemon (
    @Id
    var id: Int,

    var nome: String,

    var tipo_1: Tipo,

    var tipo_2: Tipo?,

    var poder: Int
)