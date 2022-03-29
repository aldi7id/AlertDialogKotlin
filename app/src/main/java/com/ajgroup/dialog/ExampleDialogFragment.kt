package com.ajgroup.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.ajgroup.dialog.databinding.FragmentDialogBinding

class ExampleDialogFragment(): DialogFragment() {
    lateinit var name: String
    lateinit var binding: FragmentDialogBinding

    constructor(name: String) : this() {
        this.name = name
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            binding.tvHello.text = name


        binding.btnClose.setOnClickListener {
            Toast.makeText(
                activity,
                "DialogFragment Ditutup dari dalam fragment",
                Toast.LENGTH_LONG
            ).show()
            dialog?.dismiss()
        }
    }
}