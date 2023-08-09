package com.harleenkaur.carShop

object MyCarListData {

    operator fun invoke(): CarList {
        var carList = ArrayList<UserDefinedData>()
        carList.add(
            UserDefinedData(
                "Hyundi",
                "Hyundai i20",
                "4.4",
                "v4 engine",
                "2000",
                "4 doors",
                "7.19 lakh -  11.33 lakh",
                "Red Color",
                false,
                "10/11/2009",
                R.drawable.hyundi

                )
        )
        carList.add(
            UserDefinedData(
                "Maruti",
                "Maruti Alto K10",
                "4.6",
                "v4 engine",
                "2010",
                "5 doors",
                "3.99 lakh - 5.99 lakh",
                "Red Color",
                false,
                "12/12/2012",
                R.drawable.alto
                )
        )
        carList.add(
            UserDefinedData(
                "Mercedes",
                "Mercedes-Benz GLE",
                "4.8",
                "v6 engine",
                "2020",
                "5 doors",
                "87.91 lakh - 1.05 crore",
                "Red Color",
                false,
                "02/01/2020",
                R.drawable.merbenz
                )
        )
        carList.add(
            UserDefinedData(
                "Tata",
                "Tata Punch",
                "4.1",
                "v4 engine",
                "2021",
                "4 doors",
                "5.49 lakh - 9.4 lakh",
                "Blue Color",
                true,
                "12/10/2023",
                R.drawable.punch
                )
        )
        carList.add(
            UserDefinedData(
                "Renault",
                "Renault Kiger RXL",
                "4.6",
                "v4 engine",
                "2021",
                "4 doors",
                "7.92 lakh - 9 lakh",
                "White Color",
                false,
                "10/02/2022",
                R.drawable.reanault
                )
        )
        carList.add(
            UserDefinedData(
                "Mahindra",
                "Mahindra Thar",
                "4.3",
                "v4 engine",
                "1970",
                "3 doors",
                "9.99 lakh - 16.49 lakh",
                "Red Color",
                false,
                "10/03/2000",
                R.drawable.thar
                )
        )
        carList.add(
            UserDefinedData(
                "Tiago",
                "Tata Tiago Ev",
                "4.3",
                "v4 engine",
                "2023",
                "5 doors",
                "5.54 lakh - 8.00 lakh",
                "Nave Blue Color",
                true,
                "21/03/2023",
                R.drawable.tiago
                )
        )
        carList.add(
            UserDefinedData(
                "Toyota",
                "Toyota Fortuner",
                "4.1",
                "v4 engine",
                "2005",
                "4 doors",
                "32.59 lakh - 50.34 lakh",
                "Black Color",
                false,
                "03/01/2008",
                R.drawable.toyota
                )
        )


        carList.add(
            UserDefinedData(
                "Volkswagen",
                "Volkswagen Virtus",
                "4.7",
                "v6 engine",
                "2022",
                "5 doors",
                "11.48 lakh - 18.57 lakh",
                "Red Tint Color",
                true,
                "09/03/2023",
                R.drawable.volkswagen
                )
        )
        carList.add(
            UserDefinedData(
                "Maruti",
                "Maruti Baleno",
                "4,3",
                "v4 engine",
                "2016",
                "5 doors",
                "6.56 lakh - 9.83 lakh",
                "Brown Color",
                false,
                "07/10/2018",
                R.drawable.marutibaleno
                )
        )
        return CarList(carList = carList)
    }


}