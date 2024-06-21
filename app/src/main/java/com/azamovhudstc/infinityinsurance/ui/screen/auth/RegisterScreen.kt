package com.azamovhudstc.infinityinsurance.ui.screen.auth

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.infinityinsurance.R
import com.azamovhudstc.infinityinsurance.databinding.RegisterScreenBinding
import com.azamovhudstc.infinityinsurance.utils.LocalObjectExt.containsThreeLetters
import com.azamovhudstc.infinityinsurance.utils.LocalObjectExt.containsThreeNumbers
import com.azamovhudstc.infinityinsurance.utils.LocalObjectExt.containsUpperCase
import com.azamovhudstc.infinityinsurance.utils.checkPhone
import com.azamovhudstc.infinityinsurance.utils.slideStart
import com.azamovhudstc.infinityinsurance.utils.slideTop
import com.azamovhudstc.infinityinsurance.utils.slideUp


class RegisterScreen : Fragment() {
    private var _binding: RegisterScreenBinding? = null
    private val binding get() = _binding!!
    private var isCorrectPassword = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RegisterScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            initClick()
            editText.slideStart(1000L, 0L)
            binding.passwordHelper.slideStart(1000L, 0L)
            imageView5.slideTop(1000L, 0L)
            frameLayout.slideStart(1000L, 0L)
            textView5.slideStart(1000L, 0L)
            retruntPassword.slideStart(1000L, 0L)
            initEdittext()
        }
    }


    private fun initClick() {
        binding.apply {
            clickRegister.setOnClickListener {
//             val bundle = Bundle()
//
//             bundle.putSerializable(
//                 "verify",
//                 AuthRequests.RegisterRequest(
//                     "",
//                     registerPassword.text.toString(),
//                     "+998"+phone_register.unMaskedText.toString()
//                 )
//             )
//             findNavController().navigate(R.id.verifyScreen, bundle)
            }
            openLoginTxt.setOnClickListener {
                findNavController().popBackStack()
            }
            openLoginTxt.slideUp(1000L, 0L)
            clickRegister.slideUp(1000L, 0L)
            val text =
                "<font color=#A4A4A4>Если Вы уже зарегистрированы\nто можете просто </font> <font color=#84BA42>Войти</font> <font color=#A4A4A4> в приложению</font>"
            openLoginTxt.text = Html.fromHtml(text)
        }
    }


    private fun initEdittext() {
        binding.apply {
            val array = mutableListOf<Boolean>(false, false, false, false)
            phoneRegister.addTextChangedListener { it ->

                val phoneTxt = StringBuilder()
                it.toString().split(" ").onEach {
                    phoneTxt.append(it)
                }
                (isCorrectPassword && registerPassword.text.toString() == confirmPassword.text.toString() &&
                        "+998$phoneTxt".checkPhone()).also { clickRegister.isEnabled = it }
            }
            confirmPassword.addTextChangedListener {
                val txt = it.toString()
                clickRegister.isEnabled =
                    txt.trim().length > 6 && containsThreeLetters(txt) && containsThreeNumbers(txt) && containsUpperCase(
                        txt
                    ) && registerPassword.text.toString() == txt

            }

            registerPassword.addTextChangedListener {
                if (it.toString().trim().length >= 6) {
                    array[0] = true
                    containerCircle1.setBackgroundResource(R.drawable.bg_password_correct)
                    txtCorrect1.setTextColor(Color.parseColor("#064575"))
                } else {
                    array[0] = false

                    containerCircle1.setBackgroundResource(R.drawable.bg_password_current)
                    txtCorrect1.setTextColor(Color.parseColor("#BCC4CB"))
                }

                if (containsThreeLetters(it.toString())) {
                    array[1] = true
                    container2Circle.setBackgroundResource(R.drawable.bg_password_correct)
                    txtCorrect2.setTextColor(Color.parseColor("#064575"))
                } else {
                    array[1] = false
                    container2Circle.setBackgroundResource(R.drawable.bg_password_current)
                    txtCorrect2.setTextColor(Color.parseColor("#BCC4CB"))
                }

                if (containsThreeNumbers(it.toString())) {
                    array[2] = true
                    containerCircle3.setBackgroundResource(R.drawable.bg_password_correct)
                    txtCorrect3.setTextColor(Color.parseColor("#064575"))
                } else {
                    array[2] = false
                    containerCircle3.setBackgroundResource(R.drawable.bg_password_current)
                    txtCorrect3.setTextColor(Color.parseColor("#BCC4CB"))
                }
                if (containsUpperCase(it.toString())
                ) {
                    array[3] = true

                    containerCircle4.setBackgroundResource(R.drawable.bg_password_correct)
                    txtCorrect4.setTextColor(Color.parseColor("#064575"))
                } else {
                    array[3] = false

                    containerCircle4.setBackgroundResource(R.drawable.bg_password_current)
                    txtCorrect4.setTextColor(Color.parseColor("#BCC4CB"))
                    clickRegister.isEnabled = false
                }
                isCorrectPassword = array.all { it }
                clickRegister.isEnabled =
                    isCorrectPassword && it.toString() == confirmPassword.text.toString() && phoneRegister.text.toString()
                        .checkPhone()
            }

        }
    }
}