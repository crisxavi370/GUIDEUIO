package com.example.adoptame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.adoptame.LoginSignup.LoginActivity
import com.example.adoptame.adapter.OnBoardingViewPagerAdapter
import com.example.adoptame.model.OnBoardingData
import com.google.android.material.tabs.TabLayout


class OnBoardingActivity : AppCompatActivity() {

    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null
    var next: TextView? = null
    var position = 0
    var sharedPreference: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(restorePrefData()){
            val i = Intent(applicationContext, UserDashboardActivity::class.java)
            startActivity(i)
            finish()
        }

        setContentView(R.layout.activity_on_boarding)
        //Toast.makeText(this, "Welcome Pheakdey Developer", Toast.LENGTH_SHORT).show()

        tabLayout = findViewById(R.id.tab_indicator)
        next = findViewById(R.id.next)

        // add some data to model
        val onBoardingData:MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Historia de la ciudad de Quito I", "La historia de Quito se remonta a los primeros habitantes que poblaron las regiones orientales del Distrito alrededor del año 1030 a.C., en el sector del Inca. Si bien existen restos arqueológicos que demuestran que la ciudad estuvo poblada durante siglos, se desconoce el momento exacto de su fundación.", R.drawable.searching))
        onBoardingData.add(OnBoardingData("Historia de la ciudad de Quito II", "Más adelante, con la llegada de los Incas, Quito se convertiría en una ciudad importante de la zona norte del Tahuantinsuyo y tras la destrucción de Tomebamba se transformó en la segunda capital de imperio Inca. ", R.drawable.shopping))
        onBoardingData.add(OnBoardingData("Historia de la ciudad de Quito III", "El 6 de diciembre de 1534 la ciudad sería conquistada por los españoles y es, a partir de esa fecha, que se considera su fundación. Durante la colonia sería el centro político del actual Ecuador, la segunda ciudad en ser fundada en territorio ecuatoriano y desde aquella época la capital y principal urbe de la nación.", R.drawable.vlog))

        setOnBoardingViewPagerAdapter(onBoardingData)

        position = onBoardingViewPager!!.currentItem

        next?.setOnClickListener {
            if(position < onBoardingData.size){
                position++
                onBoardingViewPager!!.currentItem = position
            }
            if(position == onBoardingData.size){
                savePrefData()
               // val i = Intent(applicationContext, UserDashboardActivity::class.java)
                val i = Intent(applicationContext, LoginActivity::class.java)
                startActivity(i)
            }
        }

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
               position = tab!!.position
                if(tab.position == onBoardingData.size -1){
                    next!!.text = "Empezar"
                } else {
                    next!!.text = "Siguiente"
                }
            }
        })
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){
        onBoardingViewPager = findViewById(R.id.screenPager)
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    private fun savePrefData(){
        sharedPreference = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreference!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefData(): Boolean {
        sharedPreference = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreference!!.getBoolean("isFirstTimeRun", false)
    }
}