package com.example.thefirstksapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class FirstRankListAdapter(private val context: Context) : RecyclerView.Adapter<FirstRankListAdapter.ViewHolder>() {

        var datas = mutableListOf<ProductData>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.custom_list,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int = datas.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(datas[position])
        }

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            private val imgProduct: ImageView = itemView.findViewById(R.id.main_product)
            private val txtProductName: TextView = itemView.findViewById(R.id.main_productname)
            private val imgLogo: ImageView = itemView.findViewById(R.id.main_homelogo)
            private val txtPrice: TextView = itemView.findViewById(R.id.main_price)

            fun bind(item: ProductData) {
                imgProduct //여기를 해결해야함,,
                txtProductName.text = item.name
                imgLogo // 여기를 해결해야함,,
                txtPrice.text = item.price.toString()

                // ProductData 에 이미지를 저장하는 방법에 대해 찾아봐야함,,,

            }
        }


    }