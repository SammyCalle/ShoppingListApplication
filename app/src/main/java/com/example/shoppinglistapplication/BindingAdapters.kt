package com.example.shoppinglistapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("productImage")
fun bindProductImage(image : ImageView,url: String){
    Picasso.get().load(url).into(image)
}

