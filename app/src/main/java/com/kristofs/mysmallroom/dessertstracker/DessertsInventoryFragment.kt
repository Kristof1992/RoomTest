package com.kristofs.mysmallroom.dessertstracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kristofs.mysmallroom.database.DessertsDatabase
import com.kristofs.mysmallroom.databinding.DessertInventoryFragmentBinding

class DessertsInventoryFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DessertInventoryFragmentBinding.inflate(layoutInflater)

        // Application that the Fragment is attached to
        val application = requireNotNull(this.activity).application

        val dataSource = DessertsDatabase.getInstance(application).dessertsDatabaseDao

        val viewModelFactory = DessertsInventoryViewModelFactory(dataSource, application)
        val dessertsInventoryViewModel = ViewModelProvider(this, viewModelFactory).get(DessertsInventoryViewModel::class.java)

        binding.dessertsInventoryViewModel = dessertsInventoryViewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}