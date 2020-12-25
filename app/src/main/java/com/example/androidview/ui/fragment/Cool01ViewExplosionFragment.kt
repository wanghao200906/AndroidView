package com.example.androidview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidview.R
import com.example.androidview.databinding.CoolViewExplosionBinding
import com.example.androidview.databinding.CustomeViewMeasureBinding

class Cool01ViewExplosionFragment : Fragment() {
    private lateinit var binding: CoolViewExplosionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.cool_view_explosion, container, false)
        return binding.root
    }
}