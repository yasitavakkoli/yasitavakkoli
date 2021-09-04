package com.example.mylingo.ui.intro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.mylingo.ui.Main_Activity.MainActivity
import com.example.mylingo.R
import com.example.mylingo.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var Anim: Animation
    private lateinit var image: ImageView
    private lateinit var binding:ActivityIntroBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Anim= AnimationUtils.loadAnimation(this, R.animator.intro_animation)
        image=binding.IntroImage
        image.setAnimation(Anim)
        val intent= Intent(this, MainActivity::class.java)
        Anim.setAnimationListener(object:Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
            }
            override fun onAnimationEnd(p0: Animation?) {
                finish()
                startActivity(intent)
            }
            override fun onAnimationRepeat(p0: Animation?) {
            }
        })
    }

}