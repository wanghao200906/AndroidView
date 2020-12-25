package com.example.androidview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.androidview.R
import com.example.androidview.databinding.CoolViewBinding
import com.example.androidview.databinding.CustomeMainBinding

class CoolViewFragment : Fragment() {
    private lateinit var binding: CoolViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.cool_view, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btn1.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(Cool01ViewExplosionFragment::class.java.canonicalName)
                replace<Cool01ViewExplosionFragment>(R.id.container)
            }
        }
        binding.btn2.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(Cool02ViewExposeFragment::class.java.canonicalName)
                replace<Cool02ViewExposeFragment>(R.id.container)
            }
        }

        binding.btn3.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(Cool03ViewBezierFragment::class.java.canonicalName)
                replace<Cool03ViewBezierFragment>(R.id.container)
            }
        }
        binding.btn4.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(Cool04ViewXiaoHongShuSplashFragment::class.java.canonicalName)
                replace<Cool04ViewXiaoHongShuSplashFragment>(R.id.container)
            }
        }

    }

}