package com.peter.shoestoreudacity.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.peter.shoestoreudacity.R
import com.peter.shoestoreudacity.databinding.FragmentMainBinding
import com.peter.shoestoreudacity.ui.ShoeStoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: ShoeStoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.list.observe(viewLifecycleOwner) { it ->
            val adapter = ShoesAdapter {
                viewModel.setSelected(it!!)
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToDetailsFragment(
                    )
                )
            }

            binding.rvShoes.adapter = adapter
            adapter.submitList(it)
        }

        binding.fabAdd.setOnClickListener { findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddShoeFragment()) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.auth_menu, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //get item id to handle item clicks
        val id = item.itemId
        //handle item clicks
        if (id == R.id.logout){
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
        }


        return super.onOptionsItemSelected(item)
    }
}