package com.algawas.databaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider

class RegisterActivity : AppCompatActivity() {
    val db = UserDB(this)
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        toolBar()
        register()

    }

    fun toolBar() {
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.setOnClickListener {
            finish()
        }
    }

    fun register() {
        val register = findViewById<Button>(R.id.register)
        Log.d("TAG", "register")
        register.setOnClickListener {
            val phone = findViewById<EditText>(R.id.phoneInput)
            val name = findViewById<EditText>(R.id.nameInput)
            val email = findViewById<EditText>(R.id.emailInput)
            val phoneStr = phone.text.toString()
            Log.d("TAG", "setOnClickListener: $phoneStr")
            if (viewModel.checkPhone(phoneStr)) {
                if (db.getUser(phoneStr.toInt()) != null) {
                    Toast.makeText(
                        applicationContext,
                        "$phoneStr is already registered",
                        Toast.LENGTH_LONG).show()
                } else {
                    db.insertUser(phoneStr.toInt(), name.text.toString(), email.text.toString())
                    Toast.makeText(
                        applicationContext,
                        "$phoneStr Registered",
                        Toast.LENGTH_LONG).show()
                    finish()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "This is not a valid phone number",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}