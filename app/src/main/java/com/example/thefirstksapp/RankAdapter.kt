package com.example.thefirstksapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RankAdapter(private val rankList: ArrayList<RankingData>) : RecyclerView.Adapter<RankAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_list, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rankList[position] // 나는 이걸 datas라고 명명했고, 세가지 override가 나오기 전에 선언했다. 근데 영진님은 onBindViewHolder 안에 선언했다.
        Glide.with(holder.itemView.context) // img를 넣을 때 최초에 currentItem.pimgurl 을 썼는데 오류남.
            .load(currentItem.pimgurl)
            .into(holder.img)
        holder.title.text = currentItem.ptitle
        holder.price.text = currentItem.pprice



    }

    override fun getItemCount(): Int { // 여긴 똑같다. 다만 나는 약식을 사용 : return 대신 '=' 사용
        return rankList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img: ImageView = itemView.findViewById(R.id.ranking_p_photo)
        val title: TextView = itemView.findViewById(R.id.ranking_p_name)
        val price: TextView = itemView.findViewById(R.id.ranking_p_price)

        }

    }



