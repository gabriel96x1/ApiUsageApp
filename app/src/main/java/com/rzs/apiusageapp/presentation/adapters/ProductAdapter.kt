package com.rzs.apiusageapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rzs.apiusageapp.R
import com.rzs.apiusageapp.domain.model.Product

class ProductAdapter (private val products: List<Product>,
                      private val quantity: Int
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var name: TextView = itemView.findViewById(R.id.txt_title)
        var desc: TextView = itemView.findViewById(R.id.txt_desc)
        val price: TextView = itemView.findViewById(R.id.txt_price)


        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = products.get(position).name
        holder.desc.text = products.get(position).description
        holder.price.text = "$ " + products.get(position).price.toString()
    }

    override fun getItemCount(): Int {
        return quantity
    }


}