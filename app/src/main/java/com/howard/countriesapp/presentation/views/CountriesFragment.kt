package com.howard.countriesapp.presentation.views

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.howard.countriesapp.databinding.FragmentCountriesBinding
import com.howard.countriesapp.presentation.adapter.CountriesAdapter
import com.howard.countriesapp.presentation.viewmodel.CountriesViewModel
import com.howard.countriesapp.util.UIState

class CountriesFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(CountriesViewModel::class.java)
    }

    private val countriesAdapter by lazy {
        CountriesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)

        binding.rvCountries.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        viewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Loading -> {
                    Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
                }

                is UIState.Success -> {
                    countriesAdapter.updateCountries(it.data)
                }

                is UIState.Error -> {
                    AlertDialog.Builder(requireActivity())
                        .setTitle("Error occured")
                        .setMessage(it.error.localizedMessage)
                        .setNegativeButton("DISMISS") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .create()
                        .show()
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}