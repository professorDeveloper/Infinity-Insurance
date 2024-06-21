package com.azamovhudstc.infinityinsurance.ui.screen.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.infinityinsurance.R
import com.azamovhudstc.infinityinsurance.databinding.LoginScreenBinding
import com.azamovhudstc.infinityinsurance.utils.animationTransaction
import com.azamovhudstc.infinityinsurance.utils.slideStart
import com.azamovhudstc.infinityinsurance.utils.slideTop
import com.azamovhudstc.infinityinsurance.utils.slideUp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreen : Fragment() {

    private var _binding: LoginScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginClick.slideUp(1000L, 0L)
            frameLayout.slideStart(1000L, 0L)
            editText.slideStart(1000L, 0L)
            linearLayout6.slideStart(1000L, 0L)
            textView5.slideStart(1000L, 0L)
            imageView3.slideTop(1000L, 0L)
            regiserScreenOpen.slideUp(1000L, 0L)
            regiserScreenOpen.setOnClickListener {
                findNavController().navigate(
                    R.id.registerScreen,
                    null,
                    animationTransaction().build()
                )
            }

            loginClick.setOnClickListener {
                if (phoneLogin.unMaskedText.toString().isEmpty()) {
                    phoneLogin.setError("Поле, обязательное для заполнения")
                }
                if (phoneLogin.text!!.isEmpty()) {
                    phoneLogin.setError("Поле, обязательное для заполнения")

                }
                else {
//                    findNavController().
                }
            }
        }
    }

}