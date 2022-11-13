package com.example.thefirstksapp

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class PopularFragment : Fragment()  {
    private lateinit var toolbar: Toolbar
    private lateinit var toolbar_title: TextView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerNavigationView: NavigationView

    private lateinit var adapter: FirstRankListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingArrayList: ArrayList<ProductData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_popular, container, false)

        toolbar = view.findViewById(R.id.toolbar)
        toolbar_title = toolbar.findViewById(R.id.toolbar_title)
        toolbar.setNavigationIcon(R.drawable.ic_baseline_dehaze_24)
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        drawerLayout = view.findViewById(R.id.drawer_layout)
        drawerNavigationView = drawerLayout.findViewById(R.id.nav_view)
        drawerNavigationView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.menu_item1 -> reloadFragment("롯데홈쇼핑")
                R.id.menu_item2 -> reloadFragment("현대홈쇼핑")
                R.id.menu_item3 -> reloadFragment("NH홈쇼핑")
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        getRankingList()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FirstRankListAdapter(rankingArrayList)
        recyclerView.adapter = adapter


        return view
    }


    private fun getRankingList(){

        rankingArrayList = arrayListOf(
            ProductData(img = R.drawable.ic_baseline_home_24, name = "이름1", price = "15,000원"),
            ProductData(img = R.drawable.ic_baseline_home_24, name = "이름2", price = "20,000원"),
            ProductData(img = R.drawable.ic_baseline_home_24, name = "이름3", price = "25,000원")
        )

    }

    private fun reloadFragment(text: String) {

        toolbar_title = toolbar.findViewById(R.id.toolbar_title)
        toolbar_title.text = text
    }

}


