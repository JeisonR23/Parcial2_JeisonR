package edu.ucne.parcticaparcial2hoy.repository

import edu.ucne.parcticaparcial2hoy.data.remote.dto.verbosDTO
import edu.ucne.parcticaparcial2hoy.data.remote.verbosApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VerbosRepository @Inject constructor(
    val api : verbosApi
){

    suspend fun getVerbos() : List<verbosDTO>
    {
        return withContext(Dispatchers.IO){
            val response = api.getverbos()
            response.body()?: emptyList()
        }
    }
}