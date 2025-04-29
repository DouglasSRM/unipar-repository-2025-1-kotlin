package br.unipar.pokedex.model

data class Pokemon (
    var numeroPokedex: String? = null,//ID do documento

    var nome: String,

    var tipo_1: Tipo,

    var tipo_2: Tipo?,

    var poder: Int,

    var descricao: String? = null
)
