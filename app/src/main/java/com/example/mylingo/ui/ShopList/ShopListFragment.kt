package com.example.mylingo.ui.ShopList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylingo.databinding.FragmentShopListBinding
import com.example.mylingo.ui.Shopping.SaleList


class ShopListFragment:Fragment() {
    private var _binding: FragmentShopListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopListBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        val adapter = ListAdapter(SaleList)
        binding.apply {
            listRecyclerView.setHasFixedSize(true)
            listRecyclerView.adapter = adapter
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}





