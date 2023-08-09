package com.harleenkaur.carShop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sharedPre: SharedPre
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPre= SharedPre.getInstance(this)!!
        my_recycler.adapter = Adapter(sharedPre.savedCarList.carList)
        my_recycler.layoutManager = LinearLayoutManager(this)
    }
}