package com.example.chatwiseassignment

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.product_page, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = productList[position]

            holder.title.text = currentItem.title
            holder.description.text = currentItem.description
            holder.price.text = currentItem.price.toString()
            holder.rating.text = currentItem.rating.toString()
            holder.discount.text = currentItem.discountPercentage.toString()

        Picasso.get().load(currentItem.thumbnail).into(holder.image);

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.product_thumbnail)
        val title: TextView = itemView.findViewById(R.id.product_title)
        val description: TextView = itemView.findViewById(R.id.product_description)
        val price: TextView = itemView.findViewById(R.id.product_price)
        val rating: TextView = itemView.findViewById(R.id.product_rating)
        val discount: TextView = itemView.findViewById(R.id.product_discount)

    }
}