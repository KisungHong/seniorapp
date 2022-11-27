package com.example.thefirstksapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    private lateinit var adapter: HomeAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeList: List<ProductData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHomeList()

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = HomeAdapter(homeList)
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(FragmentDeco()) // Item 간 간격

    }

    private fun initHomeList(){

        homeList = listOf(
            ProductData(img = R.drawable.lottte_rank1, title = getString(R.string.title_1), price = getString(R.string.price_1)),
            ProductData(img = R.drawable.lotte_rank2, title = getString(R.string.title_2), price = getString(R.string.price_2)),
            ProductData(img = R.drawable.lotte_rank3, title = getString(R.string.title_3), price = getString(R.string.price_3))
        )

    }



}