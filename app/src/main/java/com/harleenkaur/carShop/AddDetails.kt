package com.harleenkaur.carShop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.harleenkaur.carShop.databinding.ActivityAddDetailsBinding

class AddDetails : AppCompatActivity() {
    private lateinit var binding: ActivityAddDetailsBinding
    lateinit var sharedPre: SharedPre
    var dummyImage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_details)
      sharedPre = SharedPre.getInstance(this)!!
        val carDetail = UserDefinedData()
        val carList = sharedPre.savedCarList.carList
        binding.spinnersOfCars.setOnItemSelectedListener(object  :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when (position) {
                    0 -> {
                        dummyImage = R.drawable.alto
                        carDetail.make ="Maruti"
                        carDetail.model ="Maruti Alto K10"
                    }
                    1 -> {
                        dummyImage = R.drawable.hyundi
                        carDetail.make ="Hyundi"
                        carDetail.model = "Hyundai i20"
                    }
                    2 -> {
                        dummyImage = R.drawable.merbenz
                        carDetail.make ="Mercedes"
                        carDetail.model ="Mercedes-Benz GLE"
                    }
                    3 -> {
                        dummyImage = R.drawable.punch
                        carDetail.make ="Tata"
                        carDetail.model ="Tata Punch"
                    }
                    4 -> {
                        dummyImage = R.drawable.reanault
                        carDetail.make ="Renault"
                        carDetail.model ="Renault Kiger RXL"
                    }
                    5 -> {
                        dummyImage = R.drawable.thar
                        carDetail.make ="Mahindra"
                        carDetail.model ="Mahindra Thar"
                    }
                    6-> {
                        dummyImage = R.drawable.tiago
                        carDetail.make ="Tiago"
                        carDetail.model ="Tata Tiago Ev"
                    }
                    7 -> {
                        dummyImage = R.drawable.toyota
                        carDetail.make ="Toyota"
                        carDetail.model ="Toyota Fortuner"
                    }
                    8 -> {
                        dummyImage = R.drawable.volkswagen
                        carDetail.make ="Volkswagen"
                        carDetail.model ="Volkswagen Virtus"
                    }
                    9 -> {
                        dummyImage = R.drawable.marutibaleno
                        carDetail.make ="Maruti"
                        carDetail.model ="Maruti Baleno"
                    }
                }
                if (dummyImage != null) {
                    binding.tvDetailId.setImageResource(dummyImage!!)
                } else {
                    Toast.makeText(this@AddDetails, "image not found", Toast.LENGTH_SHORT).show()
                }

                binding.makeTxt.setText( carDetail.make)
                binding.modelNameTxt.setText(carDetail.model)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        })
        binding.saveDetailsBtn.setOnClickListener {
            if(binding.makeTxt.text.toString().isNullOrEmpty()){
                Toast.makeText(this@AddDetails, "Please Add Maker Name of Vehicle",Toast.LENGTH_SHORT).show()
            }else if(binding.modelNameTxt.text.toString().isNullOrEmpty()){
                Toast.makeText(this@AddDetails, "Please Enter Model Name of Vehicle ",Toast.LENGTH_SHORT).show()
            }else if(binding.engineCylinderTxt.text.toString().isNullOrEmpty()){
                Toast.makeText(this@AddDetails, "Please Add Engine type ",Toast.LENGTH_SHORT).show()
            }else if(binding.doorsTxt.text.toString().isNullOrEmpty()){
                Toast.makeText(this@AddDetails, "Please Enter Doors ",Toast.LENGTH_SHORT).show()
            }else if(binding.priceRangeTxt.text.toString().isNullOrEmpty()){
                Toast.makeText(this@AddDetails, "Please Enter Price range  ",Toast.LENGTH_SHORT).show()
            }
            else if(binding.colorTxt.text.toString().isNullOrEmpty()){
                Toast.makeText(this@AddDetails, "Please Enter Color of the car  ",Toast.LENGTH_SHORT).show()
            }
            else if(binding.modelTxt.text.toString().isNullOrEmpty()){
                Toast.makeText(this@AddDetails, "Please Enter Year of Purchase  ",Toast.LENGTH_SHORT).show()
            }else{
                carDetail.color = binding.colorTxt.text.toString()
                carDetail.price = binding.priceRangeTxt.text.toString()
                carDetail.year = binding.modelTxt.text.toString()
                carDetail.engineCylinder = binding.engineCylinderTxt.text.toString()
                carDetail.numberOfDoors = binding.doorsTxt.text.toString()
                carDetail.condition = "4.5"
                carDetail.make =binding.makeTxt.text.toString()
                carDetail.model =binding.modelNameTxt.text.toString()
                carDetail.model =binding.modelNameTxt.text.toString()
                carDetail.carImageId = dummyImage
               /* if(binding.dateOfSoldTxt.text.isNullOrEmpty()){
                    carDetail.dateSold = ""
                    carDetail.isAvailable = true
                }else{
                    carDetail.dateSold = binding.dateOfSoldTxt.text.toString()
                    carDetail.isAvailable = true
                }*/
                carDetail.dateSold = ""
                carDetail.isAvailable = true
                carList.add(carDetail)
                sharedPre.savedCarList = CarList(carList)
                onBackPressed()
            }

        }
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.toolbar.title.text = getString(R.string.add_vehicles_detail)
        binding.toolbar.backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}