package com.omarali.shoestore.ui.shoeslist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.omarali.shoestore.R
import com.omarali.shoestore.databinding.FragmentShoesListBinding
import com.omarali.shoestore.databinding.ItemShoeBinding
import com.omarali.shoestore.model.SharedPreference
import com.omarali.shoestore.ui.shoesdetails.ShoesDetailsViewModel

class ShoesListFragment : Fragment() {

    private lateinit var viewModel: ShoesDetailsViewModel
    private lateinit var binding: FragmentShoesListBinding
    private lateinit var sharedPreference: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = SharedPreference(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)

        Log.i("ShoesListFragment", "Called ViewModelProvider!")
        viewModel = ViewModelProvider(requireActivity())[ShoesDetailsViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        binding.toolbarList.inflateMenu(R.menu.menu_main)
        binding.toolbarList.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.logout -> {
                    sharedPreference.logout()
                    view.findNavController().navigate(R.id.action_shoesListFragment_to_loginFragment)

//                    Toast.makeText(context, "Sure?", Toast.LENGTH_LONG).show()
                    true
                }
                else -> {
                    super.onOptionsItemSelected(it)
                }
            }
        }

        binding.fab.setOnClickListener {
            view.findNavController().navigate(R.id.action_shoesListFragment_to_shoesDetailsFragment)
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            it.forEach {
                val bindingItem: ItemShoeBinding = ItemShoeBinding.inflate(layoutInflater)
                bindingItem.txtBrand.text = it.brand
                bindingItem.txtSizeColor.text = it.size + " , " + it.color
                bindingItem.txtPrice.text = it.price+" $"
                binding.shoeList.addView(bindingItem.root)
            }
            binding.shoeList.invalidate();
            binding.invalidateAll()
        })
    }
}