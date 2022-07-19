package com.peter.shoestoreudacity.ui.add_shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.peter.shoestoreudacity.R
import com.peter.shoestoreudacity.databinding.FragmentAddShoeBinding
import com.peter.shoestoreudacity.models.Shoe
import com.peter.shoestoreudacity.ui.ShoeStoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddShoeFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddShoeBinding
    private val viewModel: ShoeStoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddShoeBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.setSelected(Shoe("shoe4",44.0,"c4","d4", listOf("")))
        binding.btnCancel.setOnClickListener { findNavController().popBackStack() }
        binding.btnSave.setOnClickListener { viewModel.addShoe() }
        viewModel.back.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().popBackStack()
                viewModel.onBackDone()
                Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}