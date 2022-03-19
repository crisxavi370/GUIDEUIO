package com.example.adoptame.repository

import androidx.lifecycle.LiveData
import com.example.adoptame.data.LugaresDao
import com.example.adoptame.model.Place


class LugaresRepository(private val lugaresDao: LugaresDao) {

    val readAllDataPlace: LiveData<List<Place>> = lugaresDao.readAllDataPlace()

    val readAllDatPlaceWithFeature: LiveData<List<Place>> = lugaresDao.readAllDatPlaceWithFeature()

    suspend fun addPlace(place: Place) {
        lugaresDao.addPlace(place)
    }

    fun readAllPlaceByCategory(categoryId: Int) : LiveData<List<Place>> {
        return lugaresDao.readAllPlaceByCategory(categoryId)
    }

    fun searchPlace(search: String) : LiveData<List<Place>> {
        return lugaresDao.searchPlace(search)
    }

}