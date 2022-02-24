package com.example.adoptame.viewmodel

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.adoptame.model.Lugares


class DatabaseHandler (context: Context):  SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "GuideUIODB"
        private val TABLE_GUIDEUIO = "GuideUIO"
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_LOCATION = "location"
        private val KEY_DESC = "descripcion"
        private val KEY_IMG = "imagen"
        private val KEY_STARS= "estrellas"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_DATABASE_TABLE = ("CREATE TABLE $TABLE_GUIDEUIO ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$KEY_NAME VARCHAR(100), " +
                "$KEY_LOCATION VARCHAR(100), " +
                "$KEY_DESC VARCHAR(500), " +
                "$KEY_IMG VARCHAR(500), " +
                "$KEY_STARS DECIMAL(1,1));")

        val INSERT_DATA = "INSERT INTO $TABLE_GUIDEUIO($KEY_NAME,$KEY_LOCATION,$KEY_DESC,$KEY_IMG,$KEY_STARS) VALUES" +
                "('Parque metropolitano del Sur'," +
                "'Av. Simón Bolívar en el área de El Troje, al sur de la ciudad de Quito'," +
                "'Si eres de lo que admiran los atardeceres, los miradores de este lugar son para ti. Y algo excepcional: si es un día soleado y despejado, desde esta zona se puede apreciar la famosa avenida de los Volcanes. Imperdible, ¿no crees? Además, puedes llevar a tus mascotas… ¡también son bienvenidas aquí!'," +
                "'android.resource://com.example.adoptame/drawable/parque1'," +
                "4.5)," +
                "('Parque Rumipamba'," +
                "'Nuño de Valderrama s/n, Quito 170147'," +
                "'Es un buen destino para realizar exploraciones arqueológicas o fabricar artesanías con material reciclado. Y si eres de los que prefieren los museos, en Rumipamba hay uno con piezas de cerámica impresionantes. Si te animas a ir, recuerda consultar sus horarios con anticipación.'," +
                "'android.resource://com.example.adoptame/drawable/parque2'," +
                "4.5)," +
                "('Swissôtel Quito'," +
                "'Ave 12 de Octubre 1820 y, Quito 170525'," +
                "'Swissôtel Quito es un hotel de lujo estratégicamente ubicado en el área comercial y residencial de Quito. Una vista inspiradora del volcán Cotopaxi y Pichincha rodean nuestro hotel. Swissôtel Quito cuenta con 275 habitaciones remodeladas y espaciosas suites, todas decoradas con esencia suiza y elegancia europea. Su experiencia en Swissôtel Quito será más que satisfactoria en un ambiente cálido y un estilo encantador.'," +
                "'android.resource://com.example.adoptame/drawable/hotel1'," +
                "5.0)," +
                "('JW Marriott Quito'," +
                "'Avenida Francisco de Orellana 1172 Y, Quito 170150'," +
                "'Discover style and sophistication at JW Marriott Hotel Quito, a luxury hotel in Quito, Ecuador. We offer a spectacular setting near the Galapagos Islands, Santo Domingo Church and more'," +
                "'android.resource://com.example.adoptame/drawable/hotel2'," +
                "5.0),"+
                "('Ciudad Mitad del Mundo'," +
                "'Av. Manuel Córdova Galarza SN, Quito'," +
                "'La Ciudad Mitad del Mundo es un terreno propiedad de la prefectura de la provincia de Pichincha. Está situado en la parroquia de San Antonio del Distrito Metropolitano de Quito, al norte de la ciudad de Quito. '," +
                "'android.resource://com.example.adoptame/drawable/momumento1'," +
                "4.5);"

        p0?.execSQL(CREATE_DATABASE_TABLE)
        p0?.execSQL(INSERT_DATA)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    //Metodo para insertar datos
    fun addPlaces(places: Lugares): Long{
        val db = this.writableDatabase
        //content resolver - to map
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME,places.name)
        contentValues.put(KEY_LOCATION,places.location)
        contentValues.put(KEY_DESC,places.descripcion)
        contentValues.put(KEY_IMG,places.imagen)
        contentValues.put(KEY_STARS,places.estrellas)

        val success = db.insert(TABLE_GUIDEUIO, null, contentValues)
        db.close()
        return success
    }

    //Metodo para actualizar datos
    fun updatePlaces(places: Lugares):Int{
        val db = this.writableDatabase
        //content resolver - to map
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME,places.name)
        contentValues.put(KEY_LOCATION,places.location)
        contentValues.put(KEY_DESC,places.descripcion)
        contentValues.put(KEY_IMG,places.imagen)
        contentValues.put(KEY_STARS,places.estrellas)

        //Actualizando registro
        val success = db.update(TABLE_GUIDEUIO, contentValues,"id="+places.id,null)
        // El segundo argumento es una cadena que contiene nullColumnHack
        db.close() // Cerramos la conexion de la base de datos
        return success
    }

    // método para leer datos
    fun viewPlaces(): List<Lugares>{
        val placesList: ArrayList<Lugares> = ArrayList<Lugares>()
        val selectQuery = "SELECT * FROM $TABLE_GUIDEUIO"
        val db = this.readableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException){
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var name: String
        var location: String
        var descripcion: String
        var imagen: String
        var estrellas: Float

        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex("id"))
                name = cursor.getString(cursor.getColumnIndex("name"))
                location = cursor.getString(cursor.getColumnIndex("location"))
                descripcion = cursor.getString(cursor.getColumnIndex("descripcion"))
                imagen = cursor.getString(cursor.getColumnIndex("imagen"))
                estrellas = cursor.getFloat(cursor.getColumnIndex("estrellas"))
                val place = Lugares(
                    id = id, name = name, location = location, descripcion = descripcion,
                imagen = imagen, estrellas = estrellas)
                placesList.add(place)
            }while (cursor.moveToNext())
        }
        return placesList
    }

    //metodo para eliminar registro
    fun deletePlace(place: Lugares): Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, place.id)
        //Eliminando registro
        val sucess = db.delete(TABLE_GUIDEUIO, "id="+place.id, null)
        db.close()
        return sucess
    }

}