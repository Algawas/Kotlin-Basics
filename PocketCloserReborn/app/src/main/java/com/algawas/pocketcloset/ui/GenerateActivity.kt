package com.algawas.pocketcloset.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.algawas.pocketcloset.R
import com.algawas.pocketcloset.database.ProjectDB
import com.algawas.pocketcloset.model.clothes.ClothesModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GenerateActivity : AppCompatActivity() {
    lateinit var adapter: HomeAdapter
    lateinit var recyclerList: RecyclerView
    lateinit var outfit: ArrayList<ClothesModel>
    lateinit var item: ClothesModel
    lateinit var fab: FloatingActionButton
    private val db = ProjectDB(this)
    private var phone: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate)
        outfit = arrayListOf<ClothesModel>()
        phone = intent.getIntExtra("phone", -1)
        onResume()
        toolBar()
      //  fab()
    }
    private fun toolBar(){
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.setOnClickListener{
            finish()
        }
    }

    private fun fab(){
        fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            onResume()
        }
    }



    override fun onResume() {
        super.onResume()
        outfit.add(db.getSuitableClothes(phone,"Top",20) ?: ClothesModel())
        outfit.add(db.getSuitableClothes(phone,"Bottom",20) ?: ClothesModel())
        outfit.add(db.getSuitableClothes(phone,"Footwear",20) ?: ClothesModel())
        outfit.add(db.getSuitableClothes(phone,"Outerwear",20) ?: ClothesModel())
        outfit.add(db.getSuitableClothes(phone,"Accessories",20) ?: ClothesModel())

        outfit.removeAll { it.name == "" }

        adapter = HomeAdapter(outfit as ArrayList<ClothesModel>)
        recyclerList = findViewById<RecyclerView>(R.id.recycler)
        recyclerList.adapter = adapter
    }
}