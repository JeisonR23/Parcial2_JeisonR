package edu.ucne.parcticaparcial2hoy.data.remote

import edu.ucne.parcticaparcial2hoy.data.remote.dto.verbosDTO
import retrofit2.Response
import retrofit2.http.GET

interface verbosApi {

    @GET("/verbos")
    suspend fun getverbos() : Response<List<verbosDTO>>
}