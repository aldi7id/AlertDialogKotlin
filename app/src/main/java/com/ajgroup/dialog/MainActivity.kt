package com.ajgroup.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.ajgroup.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancelable")
        dialog.setMessage("Dialog cancelagle bisa ditutup dengan klik bagian luar dialog")
        dialog.setCancelable(true)
        dialog.show()
    }
}