package com.example.thefirstksapp

import android.graphics.drawable.Drawable
import android.widget.ImageView

data class ProductData(

    val img : Int,
    val name : String,
    val price : String


)

// img 는 Int 로 넣어도 될듯
//  add(ProductData(img = R.drawable.profile4, name = "노스페이스와 레드페이스", price = 230,000원)) 이런식으로 해도 될듯,,
// drawable 에 dummy image 를 넣자는 얘기