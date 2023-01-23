package com.algawas.databaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class LoginActivity : AppCompatActivity() {
    val db = UserDB(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        toolBar()
        login()
    }

    fun toolBar(){
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.setOnClickListener{
            finish()
        }
    }
    fun login() {
        val logIn = findViewById<Button>(R.id.login)
        logIn.setOnClickListener {
            val phone = findViewById<EditText>(R.id.phoneInput)
            val phoneStr = phone.text.toString().toInt()
            Log.d("TAG", "setOnClickListener: $phoneStr")
            if (db.getUser(phoneStr) != null) {
                Log.d("TAG", "setOnClickListener: True")
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtra("phone", phoneStr)
                startActivity(intent)
            } else {
                Log.d("TAG", "setOnClickListener: True")
                Toast.makeText(
                    applicationContext,
                    "Phone# $phoneStr does not exist, please register your phone number first",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}