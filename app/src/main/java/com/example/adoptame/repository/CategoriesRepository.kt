package com.example.adoptame.repository

import androidx.lifecycle.LiveData
import com.example.adoptame.data.CategoriesDao
import com.example.adoptame.model.Categories


class CategoriesRepository(private val categoriesDao: CategoriesDao) {

    val readAllDataCategory: LiveData<List<Categories>> = categoriesDao.readAllData()

    suspend fun addCategory(categories: Categories){
        categoriesDao.addCategory(categories)
    }

}