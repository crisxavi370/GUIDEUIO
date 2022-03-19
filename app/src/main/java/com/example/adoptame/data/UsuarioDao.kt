package com.example.adoptame.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.adoptame.model.Usuario


@Dao
interface  UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(usuario: Usuario)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Usuario>>

    @Query("SELECT * FROM user_table WHERE email=:email AND password=:password")
    fun findUserByEmailPassword(email: String, password: String) : LiveData<List<Usuario>>

   @Update
    suspend fun updateUser(usuario: Usuario)

    @Delete
    suspend fun deleteUser(usuario: Usuario)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

}