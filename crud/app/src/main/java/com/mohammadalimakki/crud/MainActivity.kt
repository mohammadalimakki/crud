package com.mohammadalimakki.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mohammadalimakki.crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btInput.setOnClickListener {
            startActivity(this@MainActivity,simpan::class.java)
        }
        binding.btTampil.setOnClickListener {
            Toast.makeText( this@MainActivity"tampil", Toast.LENGTH_SHORT).show()
        }
    }
}