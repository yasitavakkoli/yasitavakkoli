package com.example.mylingo.ui.ContactUs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylingo.databinding.FragmentAboutUsBinding
import com.example.mylingo.databinding.FragmentContactUsBinding

class ContactUsFragment : Fragment() {
    private var _binding: FragmentContactUsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactUsBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        binding.ComposeButton.setOnClickListener {
            val EmailText:String
            EmailText=binding.CommentTextMultiLine.text.toString()
            Send(arrayOf("reza1939@gmail.com"),"Email Sent",EmailText)
        }
        return view
    }

    fun Send(Addresses: Array<String>, Subject: String , Comment:String){
        val intent = Intent( Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, Addresses)
            putExtra(Intent.EXTRA_SUBJECT, Subject)
            putExtra(Intent.EXTRA_TEXT, Comment)
        }
        if (activity?.packageManager?.let { intent.resolveActivity(it) } != null){
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}