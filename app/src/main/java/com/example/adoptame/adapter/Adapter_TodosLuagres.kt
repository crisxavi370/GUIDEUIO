package com.example.adoptame.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adoptame.Activity_lugar_detalle
import com.example.adoptame.R
import com.example.adoptame.model.Place
import kotlinx.android.synthetic.main.activity_lugar_detalle.view.all_place_rating
import kotlinx.android.synthetic.main.lugares_design.view.*

class Adapter_TodosLuagres: RecyclerView.Adapter<Adapter_TodosLuagres.MyViewHolder>() {

    lateinit var context: Context
    private var placeList = emptyList<Place>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter_TodosLuagres.MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lugares_design, parent, false))
    }

    override fun onBindViewHolder(holder: Adapter_TodosLuagres.MyViewHolder, position: Int) {

        val currentItem = placeList[position]
        holder.itemView.all_place_title.text = currentItem.place_name.toString()
        holder.itemView.all_place_desc.text = currentItem.place_desc.toString()
        holder.itemView.all_place_rating.rating = currentItem.star_point.toFloat()

        val urlImage = currentItem.image_url.toString()
        Glide.with(holder.itemView.context).load(urlImage).into(holder.itemView.all_place_image)

        holder.itemView.all_place_card.setOnClickListener {
            var intent = Intent(holder.itemView.context, Activity_lugar_detalle::class.java)
            intent.putExtra("PLACE_NAME", currentItem.place_name.toString())
            intent.putExtra("PLACE_DESC", currentItem.place_desc.toString())
            intent.putExtra("PLACE_PHONE", currentItem.phone.toString())
            intent.putExtra("PLACE_ADDRESS", currentItem.address.toString())
            intent.putExtra("PLACE_STAR", currentItem.star_point)
            intent.putExtra("OPEN_TIME", currentItem.open_time)
            intent.putExtra("CLOSE_TIME", currentItem.close_time)
            intent.putExtra("DAY_OPEN", currentItem.day_open)
            intent.putExtra("DAY_CLOSE", currentItem.day_close)
            intent.putExtra("IMAGE_URL", currentItem.image_url)
            intent.putExtra("MAP_URL", currentItem.map_url)
            intent.putExtra("WEBSITE", currentItem.website)
            intent.putExtra("REVIEW", currentItem.review)
            holder.itemView.context.startActivity(intent)
            Toast.makeText(holder.itemView.context, holder.itemView.all_place_title.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    fun setData(place: List<Place>) {
        this.placeList = place
        notifyDataSetChanged()
    }

}