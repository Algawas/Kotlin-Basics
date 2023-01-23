package com.algawas.databaseproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.algawas.databaseproject.R
import com.algawas.databaseproject.database.ProjectDB

class LoginActivity : AppCompatActivity() {
    private lateinit var phone: EditText
    private lateinit var logIn: Button
    val db = ProjectDB(this)
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
        logIn = findViewById<Button>(R.id.login)
        logIn.setOnClickListener {
            phone = findViewById<EditText>(R.id.phoneInput)
            val phoneStr = phone.text.toString().toInt()
            if (db.getUser(phoneStr) != null) {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtra("phone", phoneStr)
                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "Phone# $phoneStr does not exist, please register your phone number first",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}