package com.example.retrofit2example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2example.databinding.SingleProductBinding
import com.example.retrofit2example.retrofit.ProductModel

class ProductsAdapter(val allProducts: ArrayList<ProductModel>): RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {


//    inner class ProductsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        var productTitle: TextView
//
//        init {
//            productTitle = itemView.findViewById(R.id.tvProductTitle)
//        }
//    }
    class ProductsViewHolder(val binding: SingleProductBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
//        val v = LayoutInflater.from(parent.context)
//            .inflate(R.layout.single_product, parent, false)
        val v = DataBindingUtil.inflate<SingleProductBinding>(LayoutInflater.from(parent.context),R.layout.single_product, parent, false)
        return ProductsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return allProducts.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        //holder.productTitle.setText( allProducts[position].title)
        holder.binding?.tvProductTitle?.setText( allProducts[position].title)
    }
}