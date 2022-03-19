package com.example.adoptame.repository

import androidx.lifecycle.LiveData
import com.example.adoptame.data.UsuarioDao
import com.example.adoptame.model.Usuario


class UsuarioRepository(private val usuarioDao: UsuarioDao) {

    val readAllData: LiveData<List<Usuario>> = usuarioDao.readAllData()

    suspend fun addUser(usuario: Usuario){
        usuarioDao.addUser(usuario)
    }

    suspend fun updateUser(usuario: Usuario){
        usuarioDao.updateUser(usuario)
    }

    suspend fun deleteUser(usuario: Usuario){
        usuarioDao.deleteUser(usuario)
    }

    suspend fun deleteAllUsers(){
        usuarioDao.deleteAllUsers()
    }

    fun findUserByEmailPassword(email: String, password: String) :LiveData<List<Usuario>> {
        return usuarioDao.findUserByEmailPassword(email, password)
    }

}