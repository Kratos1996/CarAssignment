package com.harleenkaur.carShop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        allvehicleId.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity((intent))
        }

        avilableId.setOnClickListener {
            val intent = Intent(this, SoldVehicle::class.java)
            intent.putExtra("sold",false)
            startActivity(intent)
        }
        soldVehicleId.setOnClickListener {
            val intent = Intent(this, SoldVehicle::class.java)
            intent.putExtra("sold",true)
            startActivity(intent)
        }
        addDetailsId.setOnClickListener {
            val intent = Intent(this, AddDetails::class.java)
            startActivity(intent)
        }
        modifyDetailsId.setOnClickListener {
            val intent = Intent(this, ModifyVehicles::class.java)
            startActivity(intent)
        }
        companyDetailsId.setOnClickListener {
            val intent = Intent(this, CompanyDetails::class.java)
            startActivity(intent)
        }



    }
}