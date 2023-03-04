package com.example.a4pics1word

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4pics1word.databinding.ActivityCloudBinding
import com.example.a4pics1word.databinding.ActivityMainBinding

class CloudActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCloudBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCloudBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

}