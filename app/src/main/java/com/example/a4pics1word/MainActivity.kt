package com.example.a4pics1word

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.a4pics1word.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val ttbb = AnimationUtils.loadAnimation(this, R.anim.ttbb)
        val stb = AnimationUtils.loadAnimation(this, R.anim.stb)
        val bb1 = AnimationUtils.loadAnimation(this, R.anim.bb1)
        val bb2 = AnimationUtils.loadAnimation(this, R.anim.bb2)


        val clImages = binding.clImages
        val btnNext = binding.btnPlay
        val imageBtn = binding.imageBtn
        val ivFriends = binding.ivFriends

        imageBtn.startAnimation(ttbb)
        clImages.startAnimation(stb)
        btnNext.startAnimation(ttb)
        ivFriends.startAnimation(bb1)

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }

        binding.imageBtn.setOnClickListener {
            val intent = Intent(this, CloudActivity::class.java)
            startActivity(intent)
        }

        binding.ivFriends.setOnClickListener {

        }

    }


}


