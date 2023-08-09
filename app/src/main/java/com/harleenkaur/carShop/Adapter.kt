package com.harleenkaur.carShop


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.view.view.*

// myVisitingPlaceList is a list of data of type PlanetData.
class Adapter(var myVisitingPlaceList: List<UserDefinedData>) :
    RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.ivImage!!
        var make = view.tvMake!!
        var model = view.tvModel!!
        var rating = view.tvRating!!
        var year = view.tvYear!!
        var isSold = view.isSold!!
        var priceView = view.price!!
        var doorView = view.doorView!!
        var colorView = view.colorView!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view, parent, false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null
        holder.itemView.setOnClickListener {
            callMyVisitedCarList(holder, position, dummyImage)
        }
        holder.make.text = myVisitingPlaceList[position].make
        holder.model.text = myVisitingPlaceList[position].model
        holder.rating.text = myVisitingPlaceList[position].condition
        holder.year.text = myVisitingPlaceList[position].year
        holder.priceView.text = "Price : "+myVisitingPlaceList[position].price
        holder.doorView.text = "Doors : "+myVisitingPlaceList[position].numberOfDoors
        holder.colorView.text = "Color : "+myVisitingPlaceList[position].color
        if(myVisitingPlaceList[position].isAvailable){
            holder.isSold.text = "(Available)"
        }else{
            holder.isSold.text = "(Sold on ${myVisitingPlaceList[position].dateSold}) "
        }
        holder.image.setImageResource(myVisitingPlaceList[position].carImageId)


    }

    private fun callMyVisitedCarList(
        holder: myViewHolder,
        position: Int,
        dummyImage: Int?
    ) {
        val intent = Intent(holder.itemView.context, PlaceDetail::class.java)
        intent.apply {
            putExtra("myVisitingPlaceList", Gson().toJson(myVisitingPlaceList[position]))
        }
        holder.itemView.context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return myVisitingPlaceList.size
    }
}



