package com.example.adoptame.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.adoptame.model.Categorias


@Dao
interface CategoriasDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCategory(categorias: Categorias)

    @Query("SELECT * FROM categories_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Categorias>>

}