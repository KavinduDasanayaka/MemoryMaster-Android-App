package com.example.memorymaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memorymaster.databinding.ActivityStartBinding


class StartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lastSavedScore = loadScore() // Load the last saved score
        binding.HightestScore.text = lastSavedScore.toString()

        binding.btnStart.setOnClickListener{
            startActivity(Intent(this@StartActivity,MainActivity::class.java))
        }
    }

    // Function to save the score in SharedPreferences
    private fun saveScore(score: Int) {
        // Get SharedPreferences instance
        val sharedPref = getSharedPreferences("Highest_score:", MODE_PRIVATE)
        // Get SharedPreferences Editor
        val editor = sharedPref.edit()
        // Put the score in SharedPreferences
        editor.putInt("score", score)
        // Apply changes to persistently save the score
        editor.apply()
    }

    // Function to load the score from SharedPreferences
    private fun loadScore(): Int {
        // Get SharedPreferences instance
        val sharedPref = getSharedPreferences("Highest_score:", MODE_PRIVATE)
        // Get the score from SharedPreferences, default value is 0 if not found
        return sharedPref.getInt("score", 0)
    }
}