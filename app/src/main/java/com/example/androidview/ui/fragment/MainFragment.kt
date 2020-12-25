package com.example.androidview.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.Html.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.androidview.R
import com.example.androidview.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btn1.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CustomFragment::class.java.canonicalName)
                replace<CustomFragment>(R.id.container)
            }
        }
        binding.btn2.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(CoolViewFragment::class.java.canonicalName)
                replace<CoolViewFragment>(R.id.container)
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            binding.tv.text = fromHtml(
                resources.getString(R.string.hcpay_repayment_apply_successful_desc_new2),
                FROM_HTML_MODE_COMPACT
            )
        }
    }

}