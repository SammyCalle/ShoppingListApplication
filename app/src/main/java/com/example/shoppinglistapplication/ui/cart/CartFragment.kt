package com.example.shoppinglistapplication.ui.cart

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.data.Repository
import com.example.shoppinglistapplication.databinding.CartFragmentBinding
import com.example.shoppinglistapplication.ui.main.MainViewModel
import com.example.shoppinglistapplication.ui.main.MainViewModelFactory
import com.example.shoppinglistapplication.ui.main.ProductClick
import com.example.shoppinglistapplication.ui.main.ProductsListAdapter

class CartFragment : Fragment() {

    private val viewModel by viewModels<CartViewModel>{
        CartViewModelFactory(Repository.getRepository(requireActivity().application))
    }

    private var viewModelAdapter : CartListAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllProducts()
        viewModel.listForRecycler.observe(viewLifecycleOwner,{
                productData->
            viewModelAdapter?.itemsData = productData
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : CartFragmentBinding = DataBindingUtil.inflate(
            inflater,R.layout.cart_fragment, container, false
        )

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModelAdapter = CartListAdapter(AddProductClick {
            viewModel.updateProdcut(it.quantity+1,it.id)
        }, DeleteProductClick {
            if(it.quantity.equals(1)) {
                viewModel.deleteProduct(it.id)
            }
        })

        binding.root.findViewById<RecyclerView>(R.id.cartproducts_recycler).apply{
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter

        }
        return binding.root
    }


}