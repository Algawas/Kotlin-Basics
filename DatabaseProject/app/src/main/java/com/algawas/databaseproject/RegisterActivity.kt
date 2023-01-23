package com.algawas.databaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider

class RegisterActivity : AppCompatActivity() {
    private lateinit var phone : EditText
    private lateinit var name : EditText
    private lateinit var email : EditText
    private lateinit var register: Button
    val db = UserDB(this)
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        register()
        toolBar()
    }
    fun toolBar(){
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.setOnClickListener{
            finish()
        }
    }
/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }
*/
    fun register() {
        register = findViewById<Button>(R.id.register)
        Log.d("TAG", "register")
        register.setOnClickListener {
            phone = findViewById<EditText>(R.id.phoneInput)
            name = findViewById<EditText>(R.id.nameInput)
            email = findViewById<EditText>(R.id.emailInput)
            //Sadly I can't send these to the View Model
            val phoneStr = phone.text.toString()
            val nameStr = name.text.toString().trim()
            val emailStr =  email.text.toString().trim()
            Log.d("TAG", "setOnClickListener: $phoneStr")
            if (viewModel.isPhoneValid(phoneStr, nameStr, emailStr)) {
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
                    "Invalid credentials",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}