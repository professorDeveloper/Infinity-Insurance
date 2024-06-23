package com.azamovhudstc.infinityinsurance.ui.screen.splash

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.azamovhudstc.infinityinsurance.R
import com.azamovhudstc.infinityinsurance.data.local.shp.AppReference
import com.azamovhudstc.infinityinsurance.databinding.SplashScreenBinding
import com.azamovhudstc.infinityinsurance.utils.*
import com.azamovhudstc.infinityinsurance.utils.enums.CurrentScreenEnum
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreen : BaseFragment<SplashScreenBinding>(SplashScreenBinding::inflate) {
    override fun onViewCreate() {
        lifecycleScope.launch {
            binding.logoImg.slideUp(1000L, 0)
            delay(3000)
            val appReference = AppReference(requireContext())
            when (appReference.currentScreenEnum) {
                CurrentScreenEnum.HOME -> {
                    //Something
                }
                CurrentScreenEnum.LANGUAGE -> {
                    binding.continueBtn.visible()
                    binding.continueBtn.slideUp(700, 0)
                }
            }
            binding.continueBtn.setOnClickListener {
                findNavController().navigate(R.id.loginScreen, null, animationTransactionClearStack(R.id.splashScreen).build())
            }

        }
    }
}