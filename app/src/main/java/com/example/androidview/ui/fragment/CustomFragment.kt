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
import com.example.androidview.databinding.CustomeMainBinding

class CustomFragment : Fragment() {
    private lateinit var binding: CustomeMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.custome_main, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btn1.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(Custom01ViewMeasureFragment::class.java.canonicalName)
                replace<Custom01ViewMeasureFragment>(R.id.container)
            }
        }
        binding.btn2.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CustomView01_ShaderFragment::class.java.canonicalName)
                replace<CustomView01_ShaderFragment>(R.id.container)
            }
        }
        binding.btn3.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CustomView02_PorterDuffFragment::class.java.canonicalName)
                replace<CustomView02_PorterDuffFragment>(R.id.container)
            }
        }
        binding.btn4.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CustomView03_ColorFilterFragment::class.java.canonicalName)
                replace<CustomView03_ColorFilterFragment>(R.id.container)
            }
        }
        binding.btn5.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CustomView04_TransformViewFragment::class.java.canonicalName)
                replace<CustomView04_TransformViewFragment>(R.id.container)
            }
        }
        binding.btn6.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CustomView05_PathViewFragment::class.java.canonicalName)
                replace<CustomView05_PathViewFragment>(R.id.container)
            }
        }
        binding.btn7.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CustomView06_PathMeasureViewFragment::class.java.canonicalName)
                replace<CustomView06_PathMeasureViewFragment>(R.id.container)
            }
        }
    }

}