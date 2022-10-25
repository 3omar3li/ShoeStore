package com.omarali.shoestore.ui.shoesdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.omarali.shoestore.R
import com.omarali.shoestore.databinding.FragmentShoesDetailsBinding
import com.omarali.shoestore.model.ShoeDetails

class ShoesDetailsFragment : Fragment() {

    private lateinit var viewModel: ShoesDetailsViewModel
    private lateinit var binding: FragmentShoesDetailsBinding
    private val shoeDetails: ShoeDetails = ShoeDetails()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_details, container, false)

        Log.i("ShoesDetailsFragment", "Called ViewModelProvider!")
        viewModel = ViewModelProvider(requireActivity())[ShoesDetailsViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shoeDetails = shoeDetails

        binding.btnAdd.setOnClickListener {
            shoeDetails.brand = binding.etBrand.text.toString()
            shoeDetails.color = binding.etColor.text.toString()
            shoeDetails.size = binding.etSize.text.toString()
            shoeDetails.price = binding.etPrice.text.toString()
            viewModel.addShoe(shoeDetails)
            view.findNavController().navigate(R.id.action_shoesDetailsFragment_to_shoesListFragment)
        }
    }
}