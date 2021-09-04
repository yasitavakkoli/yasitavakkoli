package com.example.mylingo.ui.Shopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.mylingo.databinding.FragmentShoppingBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.mylingo.R


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

        viewModel.Items.observe(viewLifecycleOwner, Observer {
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

  /* binding.itemsRecyclerView.setOnClickListener{
       C.add(items("",ItemItemsBinding.bind(view).itemsTextView.text.toString().toInt(),"",items.itemsUser("",""),items.itemsUrls("","",ItemItemsBinding.bind(view).UrlTextView.text.toString(),"","")))
   }*/
       /* fun onItemClick(position:Int) {
            C.add(items("",ItemItemsBinding.bind(view).itemsTextView.text.toString().toInt(),"",items.itemsUser("",""),items.itemsUrls("","",ItemItemsBinding.bind(view).UrlTextView.text.toString(),"","")))
}*/
     /*   b =ItemItemsBinding.inflate(inflater)
        b!!.checkBox.setOnClickListener{
           C.add(items("",ItemItemsBinding.bind(it).itemsTextView.text.toString().toInt(),"",items.itemsUser("",""),items.itemsUrls("","",ItemItemsBinding.bind(it).UrlTextView.text.toString(),"","")))
        }*/
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}