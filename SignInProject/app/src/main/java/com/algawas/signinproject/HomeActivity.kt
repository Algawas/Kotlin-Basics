package com.algawas.signinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text
import android.content.Intent


/*
Home Page:
Contains toolbar and 1 text view.
Give a welcome message using the name you got from sign in page.
Navigate back to the sign in activity using the toolbar.
 */
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val user = findViewById<TextView>(R.id.welcome)
        val nameFromFirstActivity = intent.getStringExtra("user")
        user.text = user.text.toString().replace("X", nameFromFirstActivity.toString())
        toolBar()
    }



    fun toolBar(){
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.setNavigationOnClickListener{
            finish()
        }
    }

}