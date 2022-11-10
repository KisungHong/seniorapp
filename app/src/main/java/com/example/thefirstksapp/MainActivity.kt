package com.example.thefirstksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fl: FrameLayout by lazy {
        findViewById(R.id.fl_)
    }

    private val bn: BottomNavigationView by lazy {
        findViewById(R.id.bnv_main)
    }

    private val rv: RecyclerView by lazy { findViewById(R.id.rv_home) }

    private val fragmentOne by lazy { HomeFragment() }
    private val fragmentTwo by lazy { PopularFragment() }
    private val fragmentThree by lazy { SearchFragment() }

//    lateinit var homeAdapter: FirstRankListAdapter
//    private val datas = mutableListOf<ProductData>()
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigationBar()


    }


    private fun initNavigationBar() {
        bn.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        changeFragment(fragmentOne)
                    }
                    R.id.popular -> {
                        changeFragment(fragmentTwo)
                    }
                    R.id.search -> {
                        changeFragment(fragmentThree)
                    }
                }
                true
            }
            selectedItemId = R.id.home
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_, fragment)
            .commit()
    }


}