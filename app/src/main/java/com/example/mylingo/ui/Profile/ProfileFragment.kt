package com.example.mylingo.ui.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mylingo.data.customer
import com.example.mylingo.databinding.FragmentProfileBinding
import com.example.mylingo.ui.Login.LgnFragmentArgs
import com.example.mylingo.ui.Main_Activity.Users
import com.google.android.material.snackbar.Snackbar

class ProfileFragment:Fragment() {

    private var _binding:FragmentProfileBinding?=null
    private val binding get() = _binding!!
    val arguments: ProfileFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        val user:customer? = Users.find{ Users: customer -> Users.Id==arguments.id }
        if (user!=null){
            binding.NameET.text.to(user.Name)
            binding.AddressET.text.to(user.Address)
            binding.EmailET.text.to(user.EmailAddress)
            binding.TelNoET.text.to(user.Tel)
            binding.PasswordET.text.to(user.password)
            binding.UserNameET.text.to(user.username)
        }
        binding.RegBtn.setOnClickListener(){
            if (binding.UserNameET.text.toString()!="" && binding.PasswordET.text.toString()!=""){
                if (user != null) {
                    user.Name= binding.NameET.text.toString()
                    user.Address=binding.AddressET.text.toString()
                    user.EmailAddress=binding.EmailET.text.toString()
                    user.Tel=binding.TelNoET.text.toString()
                    user.password=binding.PasswordET.text.toString()
                    user.username=binding.UserNameET.text.toString()
                    Snackbar.make(binding.root, "Done", Snackbar.LENGTH_LONG).show()
                }
            }
            else{
                Snackbar.make(binding.root, "Please Input Username and Password.", Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}