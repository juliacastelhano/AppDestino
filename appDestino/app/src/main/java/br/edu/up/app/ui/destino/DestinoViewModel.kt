package br.edu.up.app.ui.destino

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.app.data.Destino
import br.edu.up.app.data.DestinoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DestinoViewModel
    @Inject constructor(val repository: DestinoRepository) : ViewModel() {

    var destino: Destino = Destino()

    private var _destinos = MutableStateFlow(listOf<Destino>())
    val destinos: Flow<List<Destino>> = _destinos

    init {
        viewModelScope.launch {
            repository.destinos.collect{destinos ->
                _destinos.value = destinos
            }
        }
    }

    fun novo(){
        this.destino = Destino()
    }

    fun editar(destino: Destino){
        this.destino = destino
    }

    fun salvar() = viewModelScope.launch {
        repository.salvar(destino)
    }

    fun excluir(destino: Destino) = viewModelScope.launch {
        repository.excluir(destino)
    }
}