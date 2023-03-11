package com.example.a4pics1word

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.a4pics1word.databinding.ActivityMainBinding
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var level = 0
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

    }

    override fun onResume(){
        super.onResume()

        val pref: SharedPreferences = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        val editor = pref.getInt("last_que", 0 )

        val coin = pref.getInt("count_coin", 0)
        binding.coinsCount.text = coin.toString()

        val level = editor + 1
        binding.level.text = level.toString()

        val que = Constants.getQuestions()[editor]
        binding.apply {

            pic1.setImageResource(que.images[0])
            pic2.setImageResource(que.images[1])
            pic3.setImageResource(que.images[2])
            pic4.setImageResource(que.images[3])


        }

    }

}


