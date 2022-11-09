package edu.ucne.parcticaparcial2hoy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcticaparcial2hoy.data.remote.dto.verbosDTO
import edu.ucne.parcticaparcial2hoy.ui.theme.ParcticaParcial2HoyTheme



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParcticaParcial2HoyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VerbosScreen()
                }
            }
        }
    }
}


@Composable
fun VerbosScreen(viewModel: verboViewModel = hiltViewModel())
{
    val uistate = viewModel.uiState.collectAsState()
    LazyColumn{
        items(uistate.value.verbo)
        {
            verbos -> VerbosRow(verbos = verbos)
        }
    }
}



@Composable
fun VerbosRow( verbos : verbosDTO){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Verbos: " + verbos.Verbo)
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Categoria: " + verbos.Categoria)
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Nivel: " + verbos.Nivel)
        Spacer(modifier = Modifier.padding(10.dp))
        AsyncImage(model = verbos.Imagen, contentDescription =null )

    }
}

