package com.example.thefirstksapp

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.drawerlayout.widget.DrawerLayout

import com.google.android.material.navigation.NavigationView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularFragment : Fragment()  {
    private lateinit var toolbar: Toolbar
    private lateinit var toolbar_title: TextView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerNavigationView: NavigationView

    private lateinit var adapter: RankAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingList: List<RankingData>

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
                R.id.menu_item2 -> reloadFragment("우리홈쇼핑")
                R.id.menu_item3 -> reloadFragment("GS홈쇼핑")
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        getRankingList()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.ranking_recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        return view
    }


    private fun callProductInfo(){

        val call = ApiObject.getProductInfo.getProductInfoAll(shopName = "lotte")
        call.enqueue(object: Callback<List<RankingData>> {

            override fun onResponse(call: Call<List<RankingData>>, response: Response<List<RankingData>>) {
                val tag = "OnResponse : "
                Log.d(tag, "호출 성공함")

                if(response.isSuccessful) {
                    rankingList = response.body() ?: listOf()
                    val tag = "ProductData : "
                    Log.d(tag, rankingList.toString())

                    getRankingList()


                }
            }

            override fun onFailure(call: Call<List<RankingData>>, t: Throwable) {

                val tag = "OnResponse : "
                Log.d(tag, "실패함")
            }
        })

    }

    private fun getRankingList() {

        adapter = RankAdapter(rankingList as ArrayList<RankingData>)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        recyclerView.addItemDecoration(FragmentDeco())
    }

    private fun reloadFragment(text: String) {

        toolbar_title = toolbar.findViewById(R.id.toolbar_title)
        toolbar_title.text = text
    }

}


