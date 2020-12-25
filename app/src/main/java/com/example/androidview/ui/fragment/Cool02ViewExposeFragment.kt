package com.example.androidview.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidview.R
import com.example.androidview.databinding.CoolViewExposeBinding
import com.example.androidview.widget.coolView.Cool_01_ExposeView

class Cool02ViewExposeFragment : Fragment() {
    private lateinit var binding: CoolViewExposeBinding
    private lateinit var view: Cool_01_ExposeView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.cool_view_expose, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Handler().post {
//            view.reStart()
            binding.myview.reStart()
        }
    }
}
