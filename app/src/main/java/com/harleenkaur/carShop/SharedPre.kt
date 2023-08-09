package com.harleenkaur.carShop

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.harleenkaur.carShop.companyDetails.CompanyData

/*
 * Copyright (c) Ishant Sharma
 * Android Developer
 * ishant.sharma1947@gmail.com
 * 7732993378
 */

class SharedPre constructor(context: Context) {
    var mContext: Context
    var savedCarList: CarList
        get() {
            val gson = Gson()
            val value = getDataString(CAR_LIST)
            if (value?.isEmpty() == true) {
                return CarList()
            }
            return gson.fromJson(value, CarList::class.java)
        }
        set(value) {
            val gson = Gson()
            val json = gson.toJson(value)
            setDataString(CAR_LIST, json)
        }

    var companyData: CompanyDetailsData
        get() {
            val gson = Gson()
            val value = getDataString(COMPANY_DATA)
            if (value?.isEmpty() == true) {
                return CompanyData()
            }
            return gson.fromJson(value, CompanyDetailsData::class.java)
        }
        set(value) {
            val gson = Gson()
            val json = gson.toJson(value)
            setDataString(COMPANY_DATA, json)
        }

    //--------------------------------------Boolean Values--------------------------------------------
    //------------------------------------------------------------------------------------------------
    private fun getDataString(key: String): String? {
        var cbValue: String? = null
        try {
            cbValue = getSharedPreferences(mContext).getString(key, "")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return cbValue
    }

    private fun getDataStringZero(key: String): String? {
        var cbValue: String? = null
        try {
            cbValue = getSharedPreferences(mContext).getString(key, "0.0")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return cbValue
    }

    private fun setDataString(key: String, value: String) {
        val edit = getSharedPreferences(mContext).edit()
        edit.putString(key, value)
        edit.apply()
    }


    private fun getDataInt(key: String): Int {
        return getSharedPreferences(mContext).getInt(key, 0)
    }

    private fun getDataInt(key: String, customVal: Int): Int {
        return getSharedPreferences(mContext).getInt(key, customVal)
    }

    private fun setDataInt(key: String, value: Int) {
        val edit = getSharedPreferences(mContext).edit()
        edit.putInt(key, value)
        edit.commit()
    }

    private fun getDataLong(key: String): Long {
        return getSharedPreferences(mContext).getLong(key, 0)
    }

    private fun setDataLong(key: String, value: Long) {
        val edit = getSharedPreferences(mContext).edit()
        edit.putLong(key, value)
        edit.apply()
    }

    private fun getDataBoolean(key: String): Boolean {
        return getSharedPreferences(mContext).getBoolean(key, false)
    }

    private fun setDataBoolean(key: String, value: Boolean) {
        val edit = getSharedPreferences(mContext).edit()
        edit.putBoolean(key, value)
        edit.apply()
    }

    fun logout() {
        getSharedPreferences(mContext).edit().clear().apply()
        LogoutPrefrences()
    }


    private fun LogoutPrefrences() {
        removePreferences(CAR_LIST, mContext)
    }

    companion object {
        private const val APP_NAME = "Car Shop"
        private const val CAR_LIST = "carlist"
        private const val COMPANY_DATA = "company_data"
        private var Instance: SharedPre? = null

        @JvmStatic
        @Synchronized
        fun getInstance(context: Context): SharedPre? {
            if (Instance == null) {
                Instance = SharedPre(context)
            }
            return Instance
        }

        private fun getSharedPreferences(context: Context): SharedPreferences {
            return context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
        }

        private fun removePreferences(key: String, cntxt: Context) {
            getSharedPreferences(cntxt).edit().remove(key).commit()
        }
    }

    init {
        if (Instance != null) {
            throw RuntimeException("Use getInstance() method to get the single instance of this class( Mr.professional - Ishant ).")
        }
        mContext = context.applicationContext
    }
}