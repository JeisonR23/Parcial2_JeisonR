package edu.ucne.parcticaparcial2hoy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcticaparcial2hoy.data.remote.dto.verbosDTO
import edu.ucne.parcticaparcial2hoy.repository.VerbosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

data class verboListUiState(
    val verbo : List<verbosDTO> = emptyList()
)



@HiltViewModel
 class  verboViewModel @Inject constructor(
    val repository: VerbosRepository
):ViewModel(){
    private val _uiState = MutableStateFlow(verboListUiState())
    val  uiState : StateFlow<verboListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                try {
                    it.copy(verbo = repository.getVerbos())
                }catch (io:IOException){
                    it.copy(verbo = emptyList())
                }
            }
        }
    }
}