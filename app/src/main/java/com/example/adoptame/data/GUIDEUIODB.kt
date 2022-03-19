package com.example.adoptame.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.adoptame.model.Categorias
import com.example.adoptame.model.Place
import com.example.adoptame.model.Usuario



@Database(entities = [Usuario::class, Categorias::class, Place::class], version = 2, exportSchema = false)
abstract class GUIDEUIODB : RoomDatabase() {

    abstract fun userDao(): UsuarioDao

    abstract fun categoriesDao(): CategoriasDao

    abstract fun placeDao(): LugaresDao

    companion object {

        @Volatile
        private var INSTANCE: GUIDEUIODB? = null

        fun getDatabase(context: Context) : GUIDEUIODB {
            val tempInstance = INSTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GUIDEUIODB::class.java,
                    "city_guide_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}