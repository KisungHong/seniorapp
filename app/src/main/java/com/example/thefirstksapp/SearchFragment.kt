package com.example.thefirstksapp

import android.app.SearchManager
import android.content.Context
import android.content.Context.SEARCH_SERVICE
import android.os.Binder
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thefirstksapp.databinding.FragmentSearchBinding

private var _binding: FragmentSearchBinding? = null
private val binding get() = _binding!!

class SearchFragment : Fragment(){
    private lateinit var searchView: SearchView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                // 검색 버튼 누를 때 호출

                return true


//                Toast.makeText(this@SearchFragment, "토스트 메세지 띄우기 입니다.", Toast.LENGTH_SHORT)
//                    .show()
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                // 검색창에서 글자가 변경이 일어날 때마다 호출

                return true
            }
        })




    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    }









//
//
//
//            val menuItem = menu?.findItem(R.id.menu3)
//
//            val searchView = menuItem?.actionView as SearchView
//
//
//
//            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//
//                    //검색어 입력 순간마다의 이벤트...
//
//                    return true
//
//                }
//
//
//
//                override fun onQueryTextSubmit(query: String?): Boolean {
//
//                    //키보드에서 검색 버튼을 누르는 순간의 이벤트
//
//                    Toast.makeText(this@MainActivity,"$query",Toast.LENGTH_SHORT).show()
//
//                    searchView.setQuery("", false)
//
//                    searchView.isIconified = true
//
//                    return true
//
//                }
//
//            })
//
//
//
//            return super.onCreateOptionsMenu(menu)
//
//        }
//
//
//    }
//



//class SearchFragment : Fragment(){
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_search, container, false)


