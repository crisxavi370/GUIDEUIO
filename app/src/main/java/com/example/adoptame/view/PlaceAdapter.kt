package com.example.adoptame.view


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.R
import com.example.adoptame.model.Lugares
import com.example.adoptame.view.interfaces.IRecyclerClick
import com.example.adoptame.viewmodel.DataViewModel


class PlaceAdapter(internal var context: Context, internal var listOfPlace: List<Lugares>, recyclerViewF: RecyclerView):
    RecyclerView.Adapter<PlaceAdapter.MyViewHolder>() {

    lateinit var viewModel: DataViewModel
    var recyclerViewFF = recyclerViewF

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_place, parent, false)
        viewModel = ViewModelProviders.of(context as FragmentActivity).get(DataViewModel::class.java)
        return MyViewHolder(v)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtidf.text = listOfPlace.get(position).id.toString()
        holder.txtnamev.text = listOfPlace.get(position).name
        holder.txtdescv.text = listOfPlace.get(position).descripcion
        holder.txtPricev.text = listOfPlace.get(position).location
        holder.estrellas.rating = listOfPlace.get(position).estrellas
        holder.imag.setImageURI(Uri.parse(listOfPlace.get(position).imagen))

        holder.setClick(object: IRecyclerClick {
            override fun onClick(view: View, position: Int) {
               //NOTHING
            }
        })

        holder.itemView.setOnLongClickListener {
            //Toast.makeText(context,"Click largo", Toast.LENGTH_LONG).show()
            viewModel.deleteRecord(context, listOfPlace.get(position).id.toString(), this@PlaceAdapter, position,recyclerViewFF)
            false
        }



        holder.EditF.setOnClickListener {
            //Toast.makeText(context,"Click en EDITAR", Toast.LENGTH_SHORT).show()
            val intent = Intent(context,Contentplace::class.java)
            intent.putExtra("Activity","UPDATE")
            intent.putExtra("nombre",listOfPlace[position].name)
            intent.putExtra("Descripcion",listOfPlace[position].descripcion)
            intent.putExtra("Ubicacion",listOfPlace[position].location)
            intent.putExtra("cantEst",listOfPlace[position].estrellas)
            intent.putExtra("id",listOfPlace[position].id.toString())
            intent.putExtra("imagenurl",listOfPlace[position].imagen)
            context.startActivity(intent)
        }

        holder.vMas.setOnClickListener{
            val intent = Intent(context,Moreinfo::class.java)
            intent.putExtra("nombre",listOfPlace[position].name)
            intent.putExtra("Descripcion",listOfPlace[position].descripcion)
            intent.putExtra("Ubicacion",listOfPlace[position].location)
            intent.putExtra("cantEst",listOfPlace[position].estrellas)
            intent.putExtra("id",listOfPlace[position].id.toString())
            intent.putExtra("imagenurl",listOfPlace[position].imagen)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listOfPlace.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var txtidf = itemView.findViewById(R.id.txtID) as TextView
        var txtnamev = itemView.findViewById(R.id.txtNombre) as TextView
        var txtdescv = itemView.findViewById(R.id.idDesc) as TextView
        var txtPricev = itemView.findViewById(R.id.idPrecio) as TextView
        var estrellas = itemView.findViewById(R.id.Rating) as RatingBar
        var imag = itemView.findViewById(R.id.imgFood) as AppCompatImageView
        var vMas = itemView.findViewById(R.id.LlVermas) as LinearLayout
        var EditF = itemView.findViewById(R.id.LlVerma) as LinearLayout

        lateinit var iRecyclerClick: IRecyclerClick

        init {
            txtidf = itemView.findViewById(R.id.txtID) as TextView
            txtnamev = itemView.findViewById(R.id.txtNombre) as TextView
            txtdescv = itemView.findViewById(R.id.idDesc) as TextView
            txtPricev = itemView.findViewById(R.id.idPrecio) as TextView
            estrellas = itemView.findViewById(R.id.Rating) as RatingBar
            imag = itemView.findViewById(R.id.imgFood) as AppCompatImageView
            vMas = itemView.findViewById(R.id.LlVermas) as LinearLayout
            EditF = itemView.findViewById(R.id.LlVerma) as LinearLayout
            itemView.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
           //if(adapterPosition!=0){
               iRecyclerClick.onClick(p0!!, adapterPosition)
           //}
        }

        fun setClick(iRecyclerClick: IRecyclerClick){
            this.iRecyclerClick = iRecyclerClick
        }

    }

}