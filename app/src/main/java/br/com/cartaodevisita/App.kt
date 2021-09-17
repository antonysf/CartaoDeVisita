package br.com.cartaodevisita

import android.app.Application
import br.com.cartaodevisita.data.AppDatabase
import br.com.cartaodevisita.data.CartaoVisitaRepository
import kotlinx.coroutines.InternalCoroutinesApi

class App : Application() {
    @InternalCoroutinesApi
    val database by lazy {AppDatabase.getDatabase(this)}
    @InternalCoroutinesApi
    val repository by lazy {CartaoVisitaRepository(database.cartaoDao())}

}