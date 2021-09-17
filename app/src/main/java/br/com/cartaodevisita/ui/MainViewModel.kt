package br.com.cartaodevisita.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.cartaodevisita.data.CartaoVisita
import br.com.cartaodevisita.data.CartaoVisitaRepository

class MainViewModel(private val cartaodevisitaRepository: CartaoVisitaRepository) : ViewModel() {

    fun insert (cartaoVisita: CartaoVisita) {
        cartaodevisitaRepository.insert(cartaoVisita)

    }

    fun getAll() : LiveData<List<CartaoVisita>> {
        return cartaodevisitaRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: CartaoVisitaRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }


}