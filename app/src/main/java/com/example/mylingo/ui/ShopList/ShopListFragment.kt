package com.example.mylingo.ui.ShopList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylingo.databinding.FragmentShopListBinding
import com.example.mylingo.ui.Shopping.SaleList


class ShopListFragment:Fragment() {
   // private val viewModel by viewModels<ShoppingViewModel>()
    private var _binding: FragmentShopListBinding? = null
    private val binding get() = _binding!!

  //  val args: ShoppingFragmentArgs by navArgs()

   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentShopListBinding.bind(view)
        val adapter = ListAdapter(SaleList)
        binding.apply {
            listRecyclerView.setHasFixedSize(true)
            listRecyclerView.adapter = adapter
            //listRecyclerView.layoutManager=LinearLayoutManager(context)
        }


      /*  viewModel.Items.observe(viewLifecycleOwner, Observer {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        })
        viewModel.searchitems(args.category)*/

    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopListBinding.inflate(layoutInflater,container,false)
        val view = binding.root










    //    _binding = FragmentShopListBinding.bind(view)
        val adapter = ListAdapter(SaleList)
        binding.apply {
            listRecyclerView.setHasFixedSize(true)
            listRecyclerView.adapter = adapter
            //listRecyclerView.layoutManager=LinearLayoutManager(context)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





