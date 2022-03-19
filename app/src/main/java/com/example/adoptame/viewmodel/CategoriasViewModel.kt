package com.example.adoptame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.adoptame.data.GUIDEUIODB
import com.example.adoptame.model.Categorias
import com.example.adoptame.repository.CategoriasRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CategoriasViewModel(application: Application) : AndroidViewModel(application) {

    val readAllDataCategory: LiveData<List<Categorias>>

    private val repository: CategoriasRepository

    init {
        val categoriesDao = GUIDEUIODB.getDatabase(application).categoriesDao()

        repository = CategoriasRepository(categoriesDao)
        readAllDataCategory = repository.readAllDataCategory
    }

    fun addCategory(categorias: Categorias){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCategory(categorias)
        }
    }

}