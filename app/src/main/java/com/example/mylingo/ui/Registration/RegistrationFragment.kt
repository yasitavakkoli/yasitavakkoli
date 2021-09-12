package com.example.mylingo.ui.Registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylingo.data.customer
import com.example.mylingo.databinding.FragmentRegistrationBinding
import com.example.mylingo.ui.Main_Activity.Users
import com.google.android.material.snackbar.Snackbar

class RegistrationFragment : Fragment() {
    private var _binding:FragmentRegistrationBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        binding.RegBtn.setOnClickListener(){
            if (binding.UserNameET.text.toString()!="" && binding.PasswordET.text.toString()!=""){
                val user:customer? = Users.find{ Userlist: customer -> Userlist.username==binding.UserNameET.text.toString() && Userlist.password==binding.PasswordET.text.toString() }
                if (user!=null){
                    Snackbar.make(binding.root, "Username or Password Already Exist.", Snackbar.LENGTH_LONG).show()
                }
                else{
                    Users.add(customer(
                        Users.size.toString(),binding.NameET.text.toString(),binding.UserNameET.text.toString(),binding.PasswordET.text.toString(),
                        binding.EmailET.text.toString(),binding.TelNoET.text.toString(),binding.AddressET.text.toString()))
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