package com.example.custum_sell_prodect

import android.graphics.Color
import android.os.Bundle
import android.widget.Adapter
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import java.util.Locale.filter
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
        lateinit var lv: RecyclerView
        lateinit var adapter: adapter_rec


        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                lv = findViewById(R.id.lv)
                val searchView = findViewById(R.id.searchView) as SearchView
                val adapterq: RecyclerView.LayoutManager = LinearLayoutManager(this)
                lv.layoutManager = adapterq
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                                return false
                        }
                        override fun onQueryTextChange(newText: String?): Boolean {
                                adapter.filter.filter(newText)
                                return false
                        }
                })
                getListOfCountries()
        }
       private fun getListOfCountries() {
               val ar = ArrayList<String>()
               val carphoto = ArrayList<Int>()
               ar.add("Ford")
               ar.add("Marcedic")
               ar.add("Tesla")
               ar.add("Hundai")
               ar.add("Hunda")
               ar.add("PMW")
               ar.add("Nessan")

               carphoto.add(R.drawable.car1)
               carphoto.add(R.drawable.car2)
               carphoto.add(R.drawable.car3)
               carphoto.add(R.drawable.car4)
               carphoto.add(R.drawable.car5)
               carphoto.add(R.drawable.car6)
               carphoto.add(R.drawable.car7)

               adapter = adapter_rec(ar,carphoto)
               lv.adapter = adapter
        }

}
