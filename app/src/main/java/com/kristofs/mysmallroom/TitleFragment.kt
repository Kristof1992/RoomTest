package com.kristofs.mysmallroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kristofs.mysmallroom.databinding.TitleFragmentBinding
import androidx.navigation.fragment.findNavController

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: TitleFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.title_fragment,
            container,
            false)

        binding.titleButton.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_dessertsInventoryFragment)
        }

        return binding.root
    }


}