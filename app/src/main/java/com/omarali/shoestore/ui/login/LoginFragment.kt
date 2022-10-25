package com.omarali.shoestore.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.omarali.shoestore.R
import com.omarali.shoestore.databinding.FragmentLoginBinding
import com.omarali.shoestore.model.LoginData
import com.omarali.shoestore.model.SharedPreference

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding
    private val loginData: LoginData = LoginData()
    private lateinit var sharedPreference: SharedPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        Log.i("LoginFragment", "Called ViewModelProvider!")
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginData = loginData
        sharedPreference = SharedPreference(requireContext())

        binding.btnLogin.setOnClickListener {
            loginData.email = binding.etEmail.text.toString()
            loginData.password = binding.etPassword.text.toString()

            if (loginData.email.isNotEmpty() && loginData.password.isNotEmpty()) {
                sharedPreference.login()
                view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            } else {
                Toast.makeText(context, "Please enter your email & password !!", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}