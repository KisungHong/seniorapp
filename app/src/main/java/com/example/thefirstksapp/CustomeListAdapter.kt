package com.example.thefirstksapp

import android.security.identity.AccessControlProfile
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomViewHolder(v:View) : RecyclerView.ViewHolder(v) {

}

class CustomeListAdapter : RecyclerView.Adapter<CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.custom_list, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount() = 4

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

    }


}