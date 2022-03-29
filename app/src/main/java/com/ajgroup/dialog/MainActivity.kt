package com.ajgroup.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ajgroup.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialogStandard.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Cancelable")
            dialog.setMessage("Dialog cancelagle bisa ditutup dengan klik bagian luar dialog")
            dialog.setCancelable(true)
            dialog.show()
        }
        binding.btnDialogButton.setOnClickListener {
            val dialogWithButton = AlertDialog.Builder(this)
            dialogWithButton.setTitle("Dialog Dengan Button")
            dialogWithButton.setMessage("Dialog Dengan Button untuk berbagai Aksi")
            dialogWithButton.setIcon(R.mipmap.ic_launcher_round)
            
            dialogWithButton.setCancelable(false)
            dialogWithButton.setPositiveButton("Positive Button"){
                dialogInterface, p1 ->
                Toast.makeText(this, "Positif Button Clicked", Toast.LENGTH_SHORT).show()
            }
            dialogWithButton.setNegativeButton("Negative Button"){
                dialogInterface, p1->
                Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_SHORT).show()
            }
            dialogWithButton.setNeutralButton("Neutral Button"){
                dialogInterface, p1 ->
                Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_SHORT).show()
            }
        dialogWithButton.show()

        }
        binding.btnDialogCustom.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(view)
            val dialog = dialogBuilder.create()
            Toast.makeText(this, "Custom Dialog Closed", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            dialog.show()
        }
    }
}