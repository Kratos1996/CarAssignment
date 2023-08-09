package com.harleenkaur.carShop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_place_detail.*

class PlaceDetail : AppCompatActivity() {
    private lateinit var obj: UserDefinedData
    private var image: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        obj = Gson().fromJson(intent.getStringExtra("myVisitingPlaceList")!!,UserDefinedData::class.java)
        setData(obj)

    }

    private fun setData(obj: UserDefinedData) {

        makeDetailId.text = obj.make
        modelDetailId.text= obj.model
        ratingDetailId.text = obj.condition
        yearDetailId.text = obj.year
        specs1.text = obj.engineCylinder
        specs2.text = obj.numberOfDoors
        specs3.text  = obj.price
        specs4.text = obj.color
        specs5.text = obj.dateSold
        yearView.text = obj.year
        tvDetailId.setImageResource(obj.carImageId)


    }
}