package com.example.shoppinglistapplication.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.databinding.ProductItemBinding
import com.example.shoppinglistapplication.model.domain.ProductsItem

class ProductsListAdapter(val callback : ProductClick): RecyclerView.Adapter<ListItemsViewHolder>() {
    var itemsData : List<ProductsItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemsViewHolder {
        val withDataBinding : ProductItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),ListItemsViewHolder.LAYOUT,
            parent,false)

        return ListItemsViewHolder(withDataBinding)

    }

    override fun onBindViewHolder(holder: ListItemsViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.productsItem = itemsData[position]
        }
    }

    override fun getItemCount() = itemsData.size
}

class ListItemsViewHolder(val viewDataBinding: ProductItemBinding):
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object{
        @LayoutRes
        val LAYOUT = R.layout.product_item
    }
}
class ProductClick(val block: (ProductsItem) -> Unit) {
    fun onClick(productsItem: ProductsItem) = block(productsItem)
}