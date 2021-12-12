package com.example.shoppinglistapplication.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapplication.R
import com.example.shoppinglistapplication.data.Repository
import com.example.shoppinglistapplication.databinding.MainFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>{
        MainViewModelFactory(Repository.getRepository(requireActivity().application))
    }

    private var viewModelAdapter : ProductsListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllProducts()
        viewModel.listForRecycler.observe(viewLifecycleOwner,{
            productData->
            viewModelAdapter?.itemsData = productData
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding : MainFragmentBinding = DataBindingUtil.inflate(
            inflater,R.layout.main_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModelAdapter = ProductsListAdapter(ProductClick {
            viewModel.addProductoDataBase(it,1)
        })

        binding.root.findViewById<RecyclerView>(R.id.products_recycler).apply{
            layoutManager = GridLayoutManager(context,2)
            adapter = viewModelAdapter

        }


        return binding.root
    }

}