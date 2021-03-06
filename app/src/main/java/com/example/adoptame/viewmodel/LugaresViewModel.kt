package com.example.adoptame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.adoptame.data.GUIDEUIODB
import com.example.adoptame.model.Place
import com.example.adoptame.repository.LugaresRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LugaresViewModel(application: Application): AndroidViewModel(application) {

    val readAllDataPlace: LiveData<List<Place>>

    val readAllDataPlaceWithFeature: LiveData<List<Place>>

    lateinit var readAllPlaceByCategory: LiveData<List<Place>>

    private val repository: LugaresRepository

    init {
        val placeDao = GUIDEUIODB.getDatabase(application).placeDao()

        repository = LugaresRepository(placeDao)
        readAllDataPlace = repository.readAllDataPlace
        readAllDataPlaceWithFeature = repository.readAllDatPlaceWithFeature
    }

    fun addPlace(place: Place) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addPlace(place)
        }
    }


    fun readAllPlaceByCategory(categoryId: Int) : LiveData<List<Place>> {
        return repository.readAllPlaceByCategory(categoryId)
    }

    fun searchPlace(search: String) : LiveData<List<Place>> {
        return repository.searchPlace(search)
    }

}