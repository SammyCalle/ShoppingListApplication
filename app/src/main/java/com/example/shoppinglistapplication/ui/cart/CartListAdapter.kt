package com.example.shoppinglistapplication.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.databinding.CartItemBinding
import com.example.shoppinglistapplication.databinding.ProductItemBinding
import com.example.shoppinglistapplication.model.domain.ProductsItem
import com.example.shoppinglistapplication.model.domain.cart.CartProductsItem
import com.example.shoppinglistapplication.ui.main.ProductClick

class CartListAdapter(val addcallback : AddProductClick, val deletecallback : DeleteProductClick)
    : RecyclerView.Adapter<CartItemsViewHolder>() {
    var itemsData : List<CartProductsItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsViewHolder {
        val withDataBinding : CartItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),CartItemsViewHolder.LAYOUT,
            parent,false)

        return CartItemsViewHolder(withDataBinding)

    }

    override fun onBindViewHolder(holder: CartItemsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.productsItem = itemsData[position]
        }
    }

    override fun getItemCount() = itemsData.size
}

class CartItemsViewHolder(val viewDataBinding: CartItemBinding):
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object{
        @LayoutRes
        val LAYOUT = R.layout.cart_item
    }
}

class AddProductClick(val block: (CartProductsItem) -> Unit) {
    fun onClick(productsItem: CartProductsItem) = block(productsItem)
}

class DeleteProductClick(val block: (CartProductsItem) -> Unit) {
    fun onClick(productsItem: CartProductsItem) = block(productsItem)
}