package com.example.adoptame.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.adoptame.data.GUIDEUIODB
import com.example.adoptame.model.Usuario
import com.example.adoptame.repository.UsuarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UsuarioViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Usuario>>

    private val repository: UsuarioRepository

    init {
        val userDao = GUIDEUIODB.getDatabase(application).userDao()
        repository = UsuarioRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(usuario)
        }
    }

    fun updateUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(usuario)
        }
    }

    fun deleteUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteUser(usuario)
        }
    }

    fun deleteAllUser(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllUsers()
        }
    }


    fun findUserByEmailPassword(email: String, password: String) : LiveData<List<Usuario>> {
        return repository.findUserByEmailPassword(email, password)
    }


}