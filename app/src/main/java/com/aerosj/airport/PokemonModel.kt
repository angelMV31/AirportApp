package com.aerosj.airport

data class PokemonListResponse(
    val results: List<PokemonBasic>
)

data class PokemonBasic(
    val name: String,
    val url: String
) {
    fun getId(): Int = url.trimEnd('/').split("/").last().toInt()
    fun getSpriteUrl(): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getId()}.png"
}