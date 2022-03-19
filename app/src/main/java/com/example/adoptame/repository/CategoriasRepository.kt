package com.example.adoptame.repository

import androidx.lifecycle.LiveData
import com.example.adoptame.data.CategoriasDao
import com.example.adoptame.model.Categorias


class CategoriasRepository(private val categoriasDao: CategoriasDao) {

    val readAllDataCategory: LiveData<List<Categorias>> = categoriasDao.readAllData()

    suspend fun addCategory(categorias: Categorias){
        categoriasDao.addCategory(categorias)
    }

}