package com.example.adoptame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.adoptame.data.CityGuideDatabase
import com.example.adoptame.model.User
import com.example.adoptame.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>

    private val repository: UserRepository

    init {
        val userDao = CityGuideDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteUser(user)
        }
    }

    fun deleteAllUser(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllUsers()
        }
    }


    fun findUserByEmailPassword(email: String, password: String) : LiveData<List<User>> {
        return repository.findUserByEmailPassword(email, password)
    }


}