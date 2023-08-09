package com.harleenkaur.carShop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.harleenkaur.carShop.databinding.ActivityModifyVehiclesBinding
import com.harleenkaur.carShop.databinding.ActivitySoldvehicleBinding
import kotlinx.android.synthetic.main.activity_main.my_recycler

class ModifyVehicles : AppCompatActivity() {
    lateinit var sharedPre: SharedPre
    private lateinit var binding: ActivityModifyVehiclesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_modify_vehicles)
        sharedPre= SharedPre.getInstance(this)!!
        binding.toolbar.title.text = getString(R.string.cars)
        binding.toolbar.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        sharedPre= SharedPre.getInstance(this)!!
        my_recycler.adapter = ModifiedAdapter(sharedPre.savedCarList.carList)
    }
}