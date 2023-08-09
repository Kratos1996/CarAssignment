package com.harleenkaur.carShop.companyDetails

import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.documentfile.provider.DocumentFile
import com.bumptech.glide.Glide
import com.harleenkaur.carShop.CompanyDetails
import com.harleenkaur.carShop.CompanyDetailsData
import com.harleenkaur.carShop.R
import com.harleenkaur.carShop.SharedPre
import com.harleenkaur.carShop.databinding.ActivityCompanyDetailsViewBinding


class CompanyDetailsView : AppCompatActivity() {

    private lateinit var binding:ActivityCompanyDetailsViewBinding
    private lateinit var sharedPre: SharedPre
    private var companyData = CompanyDetailsData()
    var imageUri:String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_company_details_view)
        sharedPre= SharedPre.getInstance(this)!!
        binding.toolbar.backBtn.setOnClickListener {
            onBackPressed()
        }
        binding.toolbar.title.text = getString(R.string.company_details)

        binding.saveDetailsBtn.setOnClickListener {
            startActivity(Intent(this@CompanyDetailsView , CompanyDetails::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        companyData = sharedPre.companyData
        imageUri = companyData.icon
        binding.companyName.text = "Company Name : "+companyData.companyName
        binding.companyBio.text = "Company Bio : "+companyData.companyBio
        binding.address.text = "Address: "+companyData.address
        binding.timing.text = "Timing : "+companyData.timing
        binding.phone.text = "Company Phone : "+companyData.phone
        if(imageUri.isNotEmpty()){
            Glide.with(this)
                .load(imageUri)
                .centerCrop()
                .placeholder(R.drawable.download)
                .into(binding.icon)
        }
    }
}