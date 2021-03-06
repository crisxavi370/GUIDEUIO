package com.example.adoptame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import com.example.adoptame.adapter.Adapter_TodosLuagres
import com.example.adoptame.model.Place
import com.example.adoptame.viewmodel.LugaresViewModel
import kotlinx.android.synthetic.main.activity_todos_lugares.*


class Activity_todos_lugares : AppCompatActivity() {

    lateinit var placeList: ArrayList<Place>

    private lateinit var mLugaresViewModel: LugaresViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos_lugares)

        var intent_extra : String? = ""
        intent_extra = intent.getStringExtra("CALL_FROM_CATEGORY")

        var intent_search : String? = ""
        intent_search = intent.getStringExtra("CALL_FOR_SEARCH")

        // Call all place based on category id
        if(intent_extra!=null){
            val categoryId = intent.getIntExtra("CATEOGRY_ID", 0)
            readAllPlaceByCateogry(categoryId)
            //Toast.makeText(this, "Call from category", Toast.LENGTH_LONG).show()
        } else if(intent_search!=null){
            val search_data = intent.getStringExtra("SEARCH_DATA")
            searchPlaceToVisit(search_data)
        }
        // Call all place to visit
        else {
            //Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()
            placeList = ArrayList()
            allPlaceRecycler()
        }

        back_pressed.setOnClickListener {
            super.onBackPressed()
        }

    }

    // Read All Place
    fun allPlaceRecycler() {
        // RecylerView
        val adapter = Adapter_TodosLuagres()
        all_places_recycler.adapter = adapter
        all_places_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // LugaresViewModel to read all places
        mLugaresViewModel = ViewModelProvider(this).get(LugaresViewModel::class.java)
        mLugaresViewModel.readAllDataPlace.observe(this, Observer { place ->
            adapter.setData(place)
        })
    }

    // Search Place
    fun searchPlaceToVisit(searchData: String) {
        // RecylerView
        val adapter = Adapter_TodosLuagres()
        all_places_recycler.adapter = adapter
        all_places_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // LugaresViewModel to read all places
        mLugaresViewModel = ViewModelProvider(this).get(LugaresViewModel::class.java)
        mLugaresViewModel.searchPlace(searchData).observe(this, Observer { place ->
            if(place.isEmpty()) {
                empty_view.setVisibility(View.VISIBLE)
                empty_view_txt.setVisibility(View.VISIBLE)
                Toast.makeText(this, "Lugar no encontrado", Toast.LENGTH_LONG).show()
            } else {
                adapter.setData(place)
            }
        })
    }

    // Read all place based on Category Id
    fun readAllPlaceByCateogry(category_id: Int) {
        // RecylerView
        val adapter = Adapter_TodosLuagres()
        all_places_recycler.adapter = adapter
        all_places_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // LugaresViewModel for read places by category id
        mLugaresViewModel = ViewModelProvider(this).get(LugaresViewModel::class.java)
        mLugaresViewModel.readAllPlaceByCategory(category_id).observe(this, Observer { place ->
            adapter.setData(place)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_busqueda, menu)
        return super.onCreateOptionsMenu(menu)
    }
}