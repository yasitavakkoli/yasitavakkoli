package com.example.mylingo.ui.ShopList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.mylingo.databinding.FragmentShopListBinding
import com.example.mylingo.ui.Shopping.SaleList
import com.google.android.material.snackbar.Snackbar

class ShopListFragment:Fragment() {
    private var _binding: FragmentShopListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopListBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        if (SaleList.isEmpty()) {
          binding.EmptyListTextView.isVisible=true
        }
        else{
        val adapter = ListAdapter(SaleList)
        binding.BuyButton.setOnClickListener() {
            if (SaleList.isNotEmpty()) {
                val action =
                    ShopListFragmentDirections.actionShopListFragmentToLgnFragment(behavior = "buy")
                Navigation.findNavController(view).navigate(action)
            }
            else{
                Snackbar.make(binding.root, "Your Shopping List is Empty.", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
        binding.apply {
            listRecyclerView.setHasFixedSize(true)
            listRecyclerView.adapter = adapter
            BuyButton.isVisible=true
        }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





