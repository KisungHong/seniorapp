package com.example.thefirstksapp

import android.app.Activity
import android.graphics.Rect
import android.os.Bundle
import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home){

    private lateinit var adapter: FirstRankListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var customArrayList: ArrayList<ProductData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRankingList()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_home)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FirstRankListAdapter(customArrayList)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(HomeFragmentDeco())

    }

    private fun initRankingList(){

        customArrayList = arrayListOf(
            ProductData(img = R.drawable.ic_baseline_home_24, name = "이름1", price = "15,000원"),
            ProductData(img = R.drawable.ic_baseline_home_24, name = "이름2", price = "20,000원"),
            ProductData(img = R.drawable.ic_baseline_home_24, name = "이름3", price = "25,000원")
        )

    }



}