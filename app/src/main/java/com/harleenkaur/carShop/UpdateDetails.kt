package com.harleenkaur.carShop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson
import com.harleenkaur.carShop.databinding.ActivityAddDetailsBinding
import com.harleenkaur.carShop.databinding.UpdateDetailsBinding
import kotlinx.android.synthetic.main.activity_place_detail.makeDetailId
import kotlinx.android.synthetic.main.activity_place_detail.modelDetailId
import kotlinx.android.synthetic.main.activity_place_detail.ratingDetailId
import kotlinx.android.synthetic.main.activity_place_detail.specs1
import kotlinx.android.synthetic.main.activity_place_detail.specs2
import kotlinx.android.synthetic.main.activity_place_detail.specs3
import kotlinx.android.synthetic.main.activity_place_detail.specs4
import kotlinx.android.synthetic.main.activity_place_detail.specs5
import kotlinx.android.synthetic.main.activity_place_detail.tvDetailId
import kotlinx.android.synthetic.main.activity_place_detail.yearDetailId

class UpdateDetails : AppCompatActivity() {
    private lateinit var binding: UpdateDetailsBinding
    lateinit var sharedPre: SharedPre

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.update_details)
        val obj = Gson().fromJson(intent.getStringExtra("myVisitingPlaceList")!!,UserDefinedData::class.java)
        val pos = intent.getIntExtra("pos", -1)
        setData(obj,binding)
      sharedPre = SharedPre.getInstance(this)!!
        val carDetail = UserDefinedData()
        val carList = sharedPre.savedCarList.carList
        binding.saveDetailsBtn.setOnClickListener {
            carDetail.make =obj.make
            carDetail.model =obj.model
            if(obj.isAvailable) {
                if (binding.priceRangeTxt.text.toString().isNullOrEmpty()) {
                    Toast.makeText(
                        this@UpdateDetails,
                        "Please Enter Price range  ",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    carDetail.color = binding.colorTxt.text.toString()
                    carDetail.price = binding.priceRangeTxt.text.toString()
                    carDetail.year = binding.modelTxt.text.toString()
                    carDetail.engineCylinder = binding.engineCylinderTxt.text.toString()
                    carDetail.numberOfDoors = binding.doorsTxt.text.toString()
                    carDetail.condition = obj.condition
                    carDetail.carImageId = obj.carImageId
                    if (binding.dateOfSoldTxt.text.isNullOrEmpty()) {
                        carDetail.dateSold = ""
                        carDetail.isAvailable = true
                    } else {
                        carDetail.dateSold = binding.dateOfSoldTxt.text.toString()
                        carDetail.isAvailable = false
                    }
                    carList[pos] = carDetail
                    sharedPre.savedCarList = CarList(carList)
                    onBackPressed()
                }
            }else{
                Toast.makeText(
                    this@UpdateDetails,
                    "This Car is Already Sold ",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        setupToolbar()
    }
    private fun setData(obj: UserDefinedData,binding: UpdateDetailsBinding) {

        binding.carDetailsTxt.text = "${obj.model} (${obj.make})"
        binding.makeTxt.text = obj.make
        binding.modelNameTxt.text = obj.model
        binding.modelTxt.text = obj.year
        binding.engineCylinderTxt.text = obj.engineCylinder
        binding.doorsTxt.text = obj.numberOfDoors
        binding.priceRangeTxt.setText(obj.price)
        binding.colorTxt.text = obj.color
        binding.dateOfSoldTxt.setText( obj.dateSold)
        binding.tvDetailId.setImageResource(obj.carImageId)
    }
    private fun setupToolbar() {
        binding.toolbar.title.text = getString(R.string.modify_vehicles_detail)
        binding.toolbar.backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}