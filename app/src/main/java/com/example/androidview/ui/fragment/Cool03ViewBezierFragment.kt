package com.example.androidview.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidview.R
import com.example.androidview.databinding.CoolViewBezierBinding

class Cool03ViewBezierFragment : Fragment() {
    private lateinit var binding: CoolViewBezierBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.cool_view_bezier, container, false)
        return binding.root
    }

}
