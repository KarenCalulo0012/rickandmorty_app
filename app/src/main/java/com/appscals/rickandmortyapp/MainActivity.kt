package com.appscals.rickandmortyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.appscals.rickandmortyapp.databinding.ActivityMainBinding
import com.appscals.rickandmortyapp.viewmodel.CharacterVM
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    // Store the binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharacterVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the content view (replacing `setContentView`)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CharacterVM::class.java]
        viewModel.getAllCharacters(6)
        initViews()
    }

    private fun initViews() {
        viewModel.characterLiveData.observe(this) {
            if (it == null) {
                Timber.e("Unsuccessful Response")
                return@observe
            }
            binding.tvLabel.text = it.name
        }
    }
}