package com.example.mylingo.ui.Dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.mylingo.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        binding.WatchCardView.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragment3ToShoppingFragment3(category ="watch")
            Navigation.findNavController(view).navigate(action)
        }
        binding.HatCardView.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragment3ToShoppingFragment3(category = "hat")
            Navigation.findNavController(view).navigate(action)
        }
        binding.ShoesCardView.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragment3ToShoppingFragment3(category = "shoes")
            Navigation.findNavController(view).navigate(action)
        }
        binding.SocksCardView .setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragment3ToShoppingFragment3(category = "socks")
            Navigation.findNavController(view).navigate(action)
        }
        binding.DressCardView .setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragment3ToShoppingFragment3(category = "dress")
            Navigation.findNavController(view).navigate(action)
        }
        binding.ShirtCardView.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragment3ToShoppingFragment3(category = "shirt")
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}