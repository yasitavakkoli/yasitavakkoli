package com.example.mylingo.ui.Login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.mylingo.data.customer
import com.example.mylingo.databinding.FragmentLgnBinding
import com.example.mylingo.ui.Buy.BuyFragmentArgs
import com.example.mylingo.ui.Main_Activity.Users
import com.google.android.material.snackbar.Snackbar

class LgnFragment: Fragment() {
        private var _binding: FragmentLgnBinding?= null
        private val binding get()=_binding!!
        val arguments: LgnFragmentArgs by navArgs()
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding= FragmentLgnBinding.inflate(layoutInflater,container,false)
            val view=binding.root
            binding.LoginBtn.setOnClickListener(){
                val user:customer? = Users.find{ Users: customer -> Users.username==binding.UserNameEditText.text.toString() && Users.password==binding.PasswordEditText.text.toString() }
                if (user!=null){
                if (arguments.behavior=="buy") {
                    val UsrName: String = user.Name
                    val id: String = user.Id
                    val action = LgnFragmentDirections.actionLgnFragmentToBuyFragment(
                        name = UsrName,
                        id = id
                    )
                    Navigation.findNavController(view).navigate(action)
                }
                else {
                    val action = LgnFragmentDirections.actionLgnFragmentToProfileFragment(id=user.Id)
                    Navigation.findNavController(view).navigate(action)
                }
                }
                else {
                        Snackbar.make(binding.root, "Invalid UserName or PassWord. Please Register.", Snackbar.LENGTH_LONG).show()
                    }
            }
            binding.RegisterBtn.setOnClickListener {
                val action = LgnFragmentDirections.actionLgnFragmentToRegistrationFragment()
                Navigation.findNavController(view).navigate(action)
            }
            return view
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
}

