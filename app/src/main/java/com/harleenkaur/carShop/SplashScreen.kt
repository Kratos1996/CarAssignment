package com.harleenkaur.carShop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.harleenkaur.carShop.companyDetails.CompanyData

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        SharedPre.getInstance(this)?.savedCarList = MyCarListData()
        SharedPre.getInstance(this)?.companyData = CompanyData()
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, menu::class.java)
            startActivity(intent)
        }, 3000)
    }
}