package com.algawas.xmlassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        printText()
        backButton()
        counter()
    }

    fun counter(){
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        //var counterInt = 0
        val counter = findViewById<TextView>(R.id.counter)
        val negative = findViewById<TextView>(R.id.negative)
        val positive = findViewById<TextView>(R.id.positive)

        counter.text = viewModel.counter.toString()

        /*fun checkValue(){
            if(counterInt<0) counter.text = "EY NO NEGATIVES HERE: $counterInt"
        }*/

        negative.setOnClickListener{
                counter.text = viewModel.negative()//(--counterInt).toString()
                viewModel.checkValue()
               //counter.text = "EY NO NEGATIVES HERE: ${--counterInt}"

        }

        positive.setOnClickListener {
            counter.text = viewModel.positive()//(++counterInt).toString()
            viewModel.checkValue()
        }

    }

    fun printText(){
        val username = findViewById<TextView>(R.id.userName)
        val nameFromFirstActivity = intent.getStringExtra("userName")

        Log.d("TAG", nameFromFirstActivity ?: "Empty")
        username.text = nameFromFirstActivity
    }

    fun backButton(){
        val backButton = findViewById<Button>(R.id.back)

        backButton.setOnClickListener{
            val counter = findViewById<TextView>(R.id.counter)

            /*val intent = Intent(applicationContext, HomeActivity::class.java)
            intent.putExtra("counter", counter.text.toString())*/

            //to send back from the 2nd page, do this:
            val intent = Intent()
            intent.putExtra("counter", counter.text.toString())
            //The result code is anything of our choice, it's just to help us identify our results
            setResult( 100, intent)
            finish() //This destroy this page, and goes to the previous one
        }
    }
}