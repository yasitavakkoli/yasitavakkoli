package com.example.mylingo.ui.Shopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.mylingo.databinding.FragmentShoppingBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.mylingo.R
import com.example.mylingo.ui.Dashboard.DashboardFragmentDirections
import com.google.android.material.snackbar.Snackbar


@AndroidEntryPoint
class ShoppingFragment : Fragment(R.layout.fragment_shopping) {

    private val viewModel by viewModels<ShoppingViewModel>()
    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!!

    val args: ShoppingFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentShoppingBinding.bind(view)
        val adapter = itemsAdapter()
        binding.apply {
            itemsRecyclerView.setHasFixedSize(true)
            itemsRecyclerView.adapter = adapter
        }

        viewModel.Items.observe(viewLifecycleOwner, {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        })
            viewModel.searchitems(args.category)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        binding.ShopListFloatingButton.setOnClickListener {
            if (SaleList.isNotEmpty()){
              val action =ShoppingFragmentDirections.actionShoppingFragment3ToShopListFragment()
              Navigation.findNavController(view).navigate(action)
            }
            else {
                Snackbar.make(binding.root, "Your Shopping List is Empty.", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}