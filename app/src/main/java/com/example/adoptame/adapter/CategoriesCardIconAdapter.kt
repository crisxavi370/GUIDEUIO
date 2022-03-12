package com.example.adoptame.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.AllPlacesActivity
import com.example.adoptame.R
import com.example.adoptame.model.Categories
import kotlinx.android.synthetic.main.categorias_icono_design.view.*

class CategoriesCardIconAdapter: RecyclerView.Adapter<CategoriesCardIconAdapter.MyViewHolder>() {

    lateinit var context: Context

    private var categoryList = emptyList<Categories>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.categorias_icono_design, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.itemView.card_category_title.text = currentItem.name.toString()
        val image = currentItem.image.toString()
        if(image == "restaurant_image"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.restaurante_icono)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_1)
        } else if(image == "categories_park_icon"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.parque_icono)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_1)
        } else if(image == "hotel_image"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.hotel_icono)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_1)
        } else if(image == "famosos_icono"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.icono_menu)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_1)
        } else if(image == "recomendaciones_icono"){
            holder.itemView.card_categories_image.setImageResource(R.drawable.recomendados_icono)
            holder.itemView.card_cateory_icon.setBackgroundResource(R.drawable.card_1)
        }

        holder.itemView.card_cateory_icon.setOnClickListener {
            val categoryId = currentItem.id
            var intent = Intent(holder.itemView.context, AllPlacesActivity::class.java)
            intent.putExtra("CALL_FROM_CATEGORY", "call_from_category")
            intent.putExtra("CATEOGRY_ID", categoryId)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setData(category: List<Categories>){
        this.categoryList = category
        notifyDataSetChanged()
    }

}