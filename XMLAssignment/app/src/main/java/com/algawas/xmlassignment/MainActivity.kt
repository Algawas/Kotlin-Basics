package com.algawas.xmlassignment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar

//Functions must be INSIDE OF MAIN ACTIVITY
class MainActivity : AppCompatActivity() {

    private lateinit var counter: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counter = findViewById<Button>(R.id.counter)

        counter()
        toHome()
        //  printUser()
    }
    /*If we want to take a value from a 2nd page, to the first page do the following:
      We must do this out of onCreate(), and also do more steps in the other page*/
    val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode==100){
            counter.text = it.data?.getStringExtra("counter")
        }
    }

    fun counter(){
       // val counter = findViewById<Button>(R.id.counter)

        val newCounter = intent.getStringExtra("counter")
        if (newCounter != null) {
            counter.text = newCounter
        }
    }

    fun toHome(){
        val logIn = findViewById<Button>(R.id.logIn)

        logIn.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            val username = findViewById<TextView>(R.id.editTextTextPersonName) //This must be inside the listener if we want to carry this text with us
            intent.putExtra("userName", username.text.toString())
        // We removed this to get the value from the 2nd page
            //startActivity(intent)
            result.launch(intent) //Use this to get value form 2nd page
            //startActivityForResult(intent, 0)
        }
    }

    fun printUser () {

/* val title = findViewById<TextView>(R.id.title)*/
        val username = findViewById<TextView>(R.id.editTextTextPersonName)
        val logIn = findViewById<Button>(R.id.logIn)
        //username is a view, so it requires you access the .text attribute
        logIn.setOnClickListener{
            val snackBar = Snackbar.make(it,username.text,Snackbar.LENGTH_LONG) //If you wanna do actions
            snackBar.setAction("ADD"){
                Toast.makeText(applicationContext,username.text,Toast.LENGTH_LONG).show()
            }
            snackBar.show()
            //Toast.makeText(applicationContext,username.text,Toast.LENGTH_LONG).show()
            // Snackbar.make(it, username.text, Snackbar.LENGTH_INDEFINITE).show()
        }
    }
}