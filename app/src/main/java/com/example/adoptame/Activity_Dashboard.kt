package com.example.adoptame


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adoptame.LoginSignup.LoginActivity
import com.example.adoptame.LoginSignup.StartUpScreenActivity
import com.example.adoptame.adapter.Adapter_CategoriasCards
import com.example.adoptame.adapter.Adapter_Principales
import com.example.adoptame.script.IngresarData

import com.example.adoptame.viewmodel.CategoriasViewModel
import com.example.adoptame.viewmodel.LugaresViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_dashboard.*


class Activity_Dashboard : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var mCategoriasViewModel: CategoriasViewModel
    private lateinit var mLugaresViewModel: LugaresViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        var navigationView= this.findViewById<NavigationView>(R.id.navigation_view)
        var drawerLayout = this.findViewById<DrawerLayout>(R.id.drawer_layout)

        // Login or Logout menu
        val menu = navigationView.menu
        val navLogout = menu.findItem(R.id.nav_logout)
        val navLogin = menu.findItem(R.id.nav_login)
        val navProfile = menu.findItem(R.id.nav_profile)

        // check with session
        if(isLogin()){
            navLogin.setVisible(false)
            navLogout.setVisible(true)
            navProfile.setVisible(true)
        } else {
            navLogin.setVisible(true)
            navLogout.setVisible(false)
            navProfile.setVisible(false)
        }

        naviagtionDrawer()
        featuredRecycler()
        cardCategoryIconRecycler()

        search_place.setOnClickListener {
            val value_data =  et_search.editText?.text.toString().trim()
            if(inputCheck(value_data)){
                var intent = Intent(applicationContext, Activity_todos_lugares::class.java)
                intent.putExtra("CALL_FOR_SEARCH", "call_for_search")
                intent.putExtra("SEARCH_DATA", value_data)
                startActivity(intent)
            } else {
                Toast.makeText(this, "No se puede buscar datos vacios", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun inputCheck(search: String): Boolean {
        return !(TextUtils.isEmpty(search))
    }

    fun featuredRecycler() {
        //RecyclerView
        val adapter = Adapter_Principales()
        featured_recycler.adapter = adapter
        featured_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // LugaresViewModel
        mLugaresViewModel = ViewModelProvider(this).get(LugaresViewModel::class.java)
        mLugaresViewModel.readAllDataPlaceWithFeature.observe(this, Observer { place ->
            adapter.setData(place)
        })

    }

    fun naviagtionDrawer() {
        navigation_view.bringToFront()
        navigation_view.setNavigationItemSelectedListener(this)
        navigation_view.setCheckedItem(R.id.nav_home)
        drawer_layout.drawerElevation = 0.0F

        menu_icon.setOnClickListener {
            if(drawer_layout.isDrawerVisible(GravityCompat.START))
                drawer_layout.closeDrawer(GravityCompat.START)
            else drawer_layout.openDrawer(GravityCompat.START)
        }
        animateNavigationDrawer()
    }

    fun animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        drawer_layout.setScrimColor(Color.TRANSPARENT)
        drawer_layout.addDrawerListener(object : SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                // Scale the View based on current slide offset
                val diffScaledOffset: Float = slideOffset * (1 - 0.7f)
                val offsetScale = 1 - diffScaledOffset
                content.setScaleX(offsetScale)
                content.setScaleY(offsetScale)

                // Translate the View, accounting for the scaled width
                val xOffset = drawerView.width * slideOffset
                val xOffsetDiff: Float = content.getWidth() * diffScaledOffset / 2
                val xTranslation = xOffset - xOffsetDiff
                content.setTranslationX(xTranslation)
            }
        })
    }

    // Selected Nav Menu
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_all_categories -> {
                Toast.makeText(this, "Todas las categorias", Toast.LENGTH_SHORT).show()
                var i = Intent(applicationContext, Activity_todas_categorias::class.java)
                startActivity(i)
            }
            R.id.nav_all_places -> {
                Toast.makeText(this, "Todos los lugares", Toast.LENGTH_SHORT).show()
                var i = Intent(applicationContext, Activity_todos_lugares::class.java)
                startActivity(i)
            }
            R.id.nav_restaurants ->{
                intentActionGo(1)
            }
            R.id.nav_car_rent ->{
                intentActionGo(2)
            }
            R.id.nav_hotel ->{
                intentActionGo(3)
            }
            R.id.nav_education ->{
                intentActionGo(4)
            }
            R.id.nav_shop ->{
                intentActionGo(5)
            }

            R.id.nav_script -> {
                var i = Intent(applicationContext, IngresarData::class.java)
                startActivity(i)
            }
            R.id.nav_logout -> {
                var i = Intent(applicationContext, StartUpScreenActivity::class.java)
                startActivity(i)
            }
            R.id.nav_login -> {
                var i = Intent(applicationContext, LoginActivity::class.java)
                startActivity(i)
            }
            R.id.nav_profile -> {
                var i = Intent(applicationContext, Activity_perfil::class.java)
                startActivity(i)
            }
        }
        return true
    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerVisible(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else
            super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
    }

    //Normal Functions
    fun callStartupScreens(view: View?) {
        var intent = Intent(this, StartUpScreenActivity::class.java)
        startActivity(intent)
    }

    fun cardCategoryIconRecycler(){
        //RecyclerView
        val adapter = Adapter_CategoriasCards()
        card_cateogry_icon_viewed_recycler.adapter = adapter
        card_cateogry_icon_viewed_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // CategoryViewModel
        mCategoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        mCategoriasViewModel.readAllDataCategory.observe(this, Observer { category ->
            adapter.setData(category)
        })
    }

    fun intentActionGo(categoryId: Int) {
        var intent = Intent(applicationContext, Activity_todos_lugares::class.java)
        intent.putExtra("CALL_FROM_CATEGORY", "call_from_category")
        intent.putExtra("CATEOGRY_ID", categoryId)
        startActivity(intent)
    }

    fun isLogin() : Boolean {
        val spf = getSharedPreferences("myuserpassword", Context.MODE_PRIVATE)
        val email = spf.getString("email", null)
        val password = spf.getString("password", null)
        if(email!=null && password!=null) {
            return true
        }
        return false
    }

}