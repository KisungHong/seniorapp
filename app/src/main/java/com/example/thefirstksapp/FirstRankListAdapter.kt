package com.example.thefirstksapp

import android.graphics.Rect
import android.security.identity.AccessControlProfile
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thefirstksapp.ProductData

class FirstRankListAdapter(private val customList: ArrayList<ProductData>) : RecyclerView.Adapter<FirstRankListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_list, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = customList[position] // 나는 이걸 datas라고 명명했고, 세가지 override가 나오기 전에 선언했다. 근데 영진님은 onBindViewHolder 안에 선언했다.
        holder.imgMain.setImageResource(currentItem.img)
        holder.txtName.text = currentItem.name
        holder.txtPrice.text = currentItem.price


    }

    override fun getItemCount(): Int { // 여긴 똑같다. 다만 나는 약식을 사용
        return customList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgMain: ImageView = itemView.findViewById(R.id.main_product)
        val txtName: TextView = itemView.findViewById(R.id.main_productname)
        val txtPrice: TextView = itemView.findViewById(R.id.main_price)

        }

    }


