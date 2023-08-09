package com.harleenkaur.carShop.companyDetails

import com.harleenkaur.carShop.CompanyDetailsData

object CompanyData {
    operator fun invoke(): CompanyDetailsData{
        return CompanyDetailsData(
            companyName = "Auto Hub",
            companyBio = "Used Car Dealer",
            address = "P193, 1, Ultadanga Main Rd",
             timing = "7:00 Am to 6:00 PM",
             phone = "9876543210",
            icon = "")

    }
}