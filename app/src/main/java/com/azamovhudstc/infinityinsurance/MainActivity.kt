package com.azamovhudstc.infinityinsurance

import android.content.res.Configuration
import android.os.Bundle
import com.prongbang.localization.LocalizationAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : LocalizationAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        block?.invoke()
        openPrepareLocalize()
        super.onConfigurationChanged(newConfig)
    }

    fun mySetLocate(locale: Locale, _block: (() -> Unit)) {
        block = _block
        setLocale(locale)
    }

    private var block: (() -> Unit)? = null

}