package br.com.cartaodevisita.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.cartaodevisita.App
import br.com.cartaodevisita.databinding.ActivityMainBinding
import br.com.cartaodevisita.util.Image
import kotlinx.coroutines.InternalCoroutinesApi

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    @InternalCoroutinesApi
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)

    }

    private val adapter by lazy {BusinessCartaoAdapter()}


    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllCartaoVisita()
        insertListener()

    }

    private fun insertListener() {
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddCartaodeVisitaActivity::class.java)
            startActivity(intent)

        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }

    }

    @InternalCoroutinesApi
    private fun getAllCartaoVisita() {
        mainViewModel.getAll().observe(this, { CartaoVisita ->
            adapter.submitList(CartaoVisita)
        })
    }


}