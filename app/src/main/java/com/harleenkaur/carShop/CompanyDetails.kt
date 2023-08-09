package com.harleenkaur.carShop

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
import com.harleenkaur.carShop.databinding.ActivityCompanyDetailsBinding


class CompanyDetails : AppCompatActivity() {
    private val READ_STORAGE_PERMISSION_CODE = 101
    private lateinit var binding:ActivityCompanyDetailsBinding
    private lateinit var sharedPre: SharedPre
    private var companyData = CompanyDetailsData()
    var imageUri:String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_company_details)
        sharedPre= SharedPre.getInstance(this)!!
        companyData = sharedPre.companyData
        binding.icon.setOnClickListener {
            // Check for permission before accessing images
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                // Permission is granted, proceed with image selection
                accessImagesFromGallery()
            } else {
                // Permission is not granted, request it
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    READ_STORAGE_PERMISSION_CODE
                )
            }
        }
        imageUri = companyData.icon
        binding.companyName.setText( companyData.companyName)
        binding.companyBio.setText(companyData.companyBio)
        binding.address.setText( companyData.address)
        binding.timing.setText( companyData.timing)
        binding.phone.setText(companyData.phone)
        if(imageUri.isNotEmpty()){
            Glide.with(this)
                .load(imageUri)
                .centerCrop()
                .placeholder(R.drawable.download)
                .into(binding.icon)
        }
        binding.saveDetailsBtn.setOnClickListener {

            sharedPre.companyData =  CompanyDetailsData(
                companyName = binding.companyName.text.toString(),
                companyBio = binding.companyBio.text.toString(),
                address = binding.address.text.toString(),
                timing = binding.timing.text.toString(),
                phone = binding.phone.text.toString(),
                icon = imageUri,
            )
            onBackPressed()
        }

    }

    private fun accessImagesFromGallery() {

// Inside your activity
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            type = "image/*"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        startActivityForResult(intent, READ_STORAGE_PERMISSION_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == READ_STORAGE_PERMISSION_CODE && resultCode == Activity.RESULT_OK) {
            data?.data?.let { selectedImageUri ->
                // Use the selectedImageUri as needed (e.g., display it in an ImageView)
                Glide.with(this)
                    .load(selectedImageUri)
                    .into(binding.icon)
                imageUri = getRealPathFromURI_API19(this@CompanyDetails,selectedImageUri)?:""
                Toast.makeText(this@CompanyDetails , imageUri,Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun getAbsolutePathFromUri(uri: Uri): String? {
        val contentResolver: ContentResolver = contentResolver
        val documentFile = DocumentFile.fromSingleUri(this, uri)
        return documentFile?.uri?.let { documentUri ->
            documentUri.toString()  // This is the absolute path-like representation of the document
        }
    }
    fun getRealPathFromURI_API19(context: Context, uri: Uri?): String? {
        var filePath = ""
        val wholeID = DocumentsContract.getDocumentId(uri)

        // Split at colon, use second item in the array
        val id = wholeID.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        val column = arrayOf(MediaStore.Images.Media.DATA)

        // where id is equal to
        val sel = MediaStore.Images.Media._ID + "=?"
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            column, sel, arrayOf(id), null
        )
        val columnIndex = cursor!!.getColumnIndex(column[0])
        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex)
        }
        cursor.close()
        return filePath
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with image selection
                accessImagesFromGallery()
            } else {
                Toast.makeText(this@CompanyDetails , " Please Allow Permission for Image",Toast.LENGTH_SHORT).show()
                // Permission denied, handle accordingly (show a message or explain why you need the permission)
            }
        }
    }
}