package com.ajgroup.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ajgroup.dialog.databinding.ActivityMainBinding
import com.ajgroup.dialog.databinding.CustomDialogBinding


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
            dialogWithButton.setPositiveButton("+",
                DialogInterface.OnClickListener { dialogInterface, i -> Toast.makeText(this, "Positif Button Clicked", Toast.LENGTH_SHORT).show() })
            dialogWithButton.setNegativeButton("-",
                DialogInterface.OnClickListener { dialogInterface, i -> Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_SHORT).show() })
            dialogWithButton.setNeutralButton("0",
                DialogInterface.OnClickListener { dialogInterface, i -> Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_SHORT).show() })
            dialogWithButton.show()

        }
        binding.btnDialogCustom.setOnClickListener {
            val binding: CustomDialogBinding = CustomDialogBinding
                .inflate(LayoutInflater.from(this))
            val builder = AlertDialog.Builder(this)
            builder.setView(binding.getRoot())

            val dialog = builder.create()
            binding.btnDialogClose.setOnClickListener {
            Toast.makeText(this, "Custom Dialog Closed", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            }
            dialog.show()
        }
    }
}