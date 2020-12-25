package com.example.androidview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidview.R
import com.example.androidview.databinding.*

class CustomView06_PathMeasureViewFragment :  Fragment() {
    private lateinit var binding: CustomeViewPathmeasureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.custome_view_pathmeasure, container, false)
        return binding.root
    }
}