package com.kakyiretechnologies.dictionary_cleanarchitecturewithmvvm.presentation.ui

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kakyiretechnologies.dictionary_cleanarchitecturewithmvvm.databinding.ActivityMainBinding
import com.kakyiretechnologies.domain.common.Resource
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<DictionaryViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchWord()
        updateUi()
    }

    private fun searchWord() = with(binding) {

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.wordUseCaseMeaning(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun updateUi() = with(viewModel) {
        wordMeaning.observe(this@MainActivity) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    Log.d(TAG, "updateUi: Loading")
                }
                is Resource.Success -> {
                    resource.data?.let {

                        binding.apply {

                            wordOrigin.text = it.origin
                            wordPhonetic.text = it.phonetic
                        }
                    }
                }
                is Resource.Error -> {
                    Log.d(TAG, "updateUi: ${resource.message}")
                }
            }
        }
    }
}