package com.example.adoptame.presentacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.adoptame.DataBase.DBHelper
import com.example.adoptame.R
import com.google.android.material.textfield.TextInputLayout

class LoginActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        supportActionBar?.hide()
        val btnregis: Button = findViewById(R.id.btnregistrar)
        val btnLog: Button = findViewById(R.id.btnLogin)
        val tiName: TextInputLayout = findViewById(R.id.tiName)
        val tiPass: TextInputLayout = findViewById(R.id.tiPasswd)
        var name = tiName.editText?.text.toString()
        var pass = tiPass.editText?.text.toString()
        val db = DBHelper(this, null)
        btnLog.setOnClickListener {
            if (tiName.editText?.text?.isNotEmpty() == false &&
                tiPass.editText?.text?.isNotEmpty() == false)
                Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
            else{
                var logindt:Boolean =
                    db.LoginDatas(tiName.editText?.text.toString(),tiPass.editText?.text.toString());
                if (logindt==true){
                    Toast.makeText(this, "BIENVENIDO",
                        Toast.LENGTH_SHORT).show()
                   // var intent = Intent(this@LoginActivity2, PrincipalActivity::class.java)
                    var intent = Intent(this@LoginActivity2, Inicio::class.java)

                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "CREDENCIALES INCORRECTAS",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
        btnregis.setOnClickListener{
            var intent1 = Intent(this@LoginActivity2, MainActivity::class.java)
            startActivity(intent1)

        }


    }

}