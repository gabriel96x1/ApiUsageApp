package com.rzs.apiusageapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rzs.apiusageapp.R
import com.rzs.apiusageapp.domain.model.Store

class StoreAdapter  (   private val stores: List<Store>,
                        private val quantity: Int
) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var name: TextView = itemView.findViewById(R.id.txt_title)
        var address: TextView = itemView.findViewById(R.id.txt_desc)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)


        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.store_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = stores.get(position).name
        holder.address.text = stores.get(position).address
        //holder.imageView.setImageResource(R.drawable.ic_store)
        Glide.with(holder.itemView).load(stores.get(position).image).into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return quantity
    }
}