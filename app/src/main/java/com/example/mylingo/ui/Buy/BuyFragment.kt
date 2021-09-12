package com.example.mylingo.ui.Buy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mylingo.data.items
import com.example.mylingo.databinding.FragmentBuyBinding
import com.example.mylingo.ui.Shopping.SaleList

var CalcResult:Float= 0F

class BuyFragment : Fragment() {
    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!
    val arguments: BuyFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        binding.UserTextView.text=arguments.name
        CalcSum(SaleList)
        binding.TotalCostTextView.text= CalcResult.toString()
        return view
    }
    fun CalcSum(SL:MutableList<items>){
        var i=0
        var total=0
        for (item in SL)
        {
            total+=SL[i].likes
            ++i
        }
        CalcResult =total.toFloat()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}