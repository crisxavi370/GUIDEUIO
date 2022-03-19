package com.example.adoptame.LoginSignup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adoptame.R
import com.example.adoptame.Activity_Dashboard
import com.example.adoptame.viewmodel.CategoriasViewModel
import com.example.adoptame.viewmodel.LugaresViewModel
import com.example.adoptame.viewmodel.UsuarioViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mUsuarioViewModel: UsuarioViewModel

    private lateinit var mCategoriasViewModel: CategoriasViewModel

    private lateinit var mLugaresViewModel: LugaresViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mUsuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        mCategoriasViewModel = ViewModelProvider(this).get(CategoriasViewModel::class.java)
        mLugaresViewModel = ViewModelProvider(this).get(LugaresViewModel::class.java)

        btn_login.setOnClickListener {
            val email = et_login_email.editText?.text.toString().trim()
            val password = et_login_password.editText?.text.toString().trim()

            if(inputCheck(email, password)){
                var userpassword = mUsuarioViewModel.findUserByEmailPassword(email, password)
                userpassword.observe(this, Observer { emailandpassword ->
                   if(emailandpassword.isEmpty()){
                       Toast.makeText(this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
                   } else {
                       sharePreferenceEmailPassword(email, password)
                       // call user dashboard intent
                       userDashboard()
                       Toast.makeText(this, "Inicio de sesión Correcto", Toast.LENGTH_SHORT).show()
                   }
                })
            } else {
                Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        login_back_button.setOnClickListener {
            //super.onBackPressed()
            userDashboard()
        }

        create_account_btn.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun inputCheck(email: String, password: String): Boolean {
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))
    }

    fun sharePreferenceEmailPassword(email: String, password: String) {
        val spf = getSharedPreferences("myuserpassword", Context.MODE_PRIVATE)
        val spe = spf.edit()
        // Using put method to write the data in SharedPreferences
        spe.putString("email", email)
        spe.putString("password", password)
        spe.apply()
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

    fun logout() {
        val spf = getSharedPreferences("myuserpassword", Context.MODE_PRIVATE)
        val spe = spf.edit()
        spe.clear()
        spe.apply()
        finish()
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
    }

    fun userDashboard() {
        var intent = Intent(this, Activity_Dashboard::class.java)
        startActivity(intent)
    }
}