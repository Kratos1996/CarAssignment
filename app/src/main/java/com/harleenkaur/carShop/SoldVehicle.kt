package com.harleenkaur.carShop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.harleenkaur.carShop.databinding.ActivitySoldvehicleBinding

class SoldVehicle : AppCompatActivity() {
    private lateinit var binding: ActivitySoldvehicleBinding
    private lateinit var sharedPre: SharedPre
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_soldvehicle)
       val isSold = intent.getBooleanExtra("sold",false)
        sharedPre = SharedPre.getInstance(this)!!
        val cars = if(isSold) sharedPre.savedCarList.carList.filter { !it.isAvailable }
        else sharedPre.savedCarList.carList.filter { it.isAvailable }
        setupToolbar(isSold)
        binding.myRecycler.adapter = Adapter(ArrayList(cars))
    }

    private fun setupToolbar(isSold :Boolean) {
        binding.toolbar.title.text = if (isSold) getString(R.string.soldCars) else  getString(R.string.available_cars)
        binding.toolbar.backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}
