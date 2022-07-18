package com.peter.shoestoreudacity.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peter.shoestoreudacity.R
import com.peter.shoestoreudacity.databinding.FragmentDetailsBinding
import com.peter.shoestoreudacity.ui.ShoeStoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: ShoeStoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCancel?.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSave?.setOnClickListener {
            Toast.makeText(context!!, "Saving...", Toast.LENGTH_SHORT).show()
        }
    }


}