package com.algawas.signinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import android.content.Intent
import android.util.Log


/*
Create Android project that consist of 3 pages as follow:
Splash Page:
Without toolbar.
Contains logo of the application.
Navigate only if the user long clicked the root view.
Sign In Page:
Contains toolbar, two texts, two edittexts and 1 Button.
Navigate if the button is clicked and have the correct credential.
The credential must be your name and password of length 5.
If one of the credentials is wrong, show toast to notify the user.
Pass the name value to the home activity.
Home Page:
Contains toolbar and 1 text view.
Give a welcome message using the name you got from sign in page.
Navigate back to the sign in activity using the toolbar.
 */

//Sign In Page
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signIn()
        toolBar()
    }

    fun toolBar(){
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.setNavigationOnClickListener{
            finish()
        }
    }

    fun signIn(){
        val signIn = findViewById<Button>(R.id.signIn)
        signIn.setOnClickListener{
            val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
            val userInput = findViewById<EditText>(R.id.userInput)
            val pwInput = findViewById<EditText>(R.id.pwInput)
            val userStr = userInput.text.toString()
            val pwStr = pwInput.text.toString()

            Log.d("TAG", "confirmlogIn result is: ${viewModel.confirmlogIn(userStr, pwStr)}")
            if(viewModel.confirmlogIn(userStr, pwStr)){
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtra("user",userStr)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Incorrect credentials", Toast.LENGTH_LONG).show()
            }
        }
    }
}