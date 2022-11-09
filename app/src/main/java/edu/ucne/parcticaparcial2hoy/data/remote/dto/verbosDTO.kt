package edu.ucne.parcticaparcial2hoy.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class verbosDTO(
    val Verbo : String,
    val Categoria : String,
    val Nivel: String,
    val Imagen : String
)
