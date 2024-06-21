package com.azamovhudstc.infinityinsurance.data.local.shp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.azamovhudstc.infinityinsurance.utils.enums.CurrentScreenEnum
import com.azamovhudstc.infinityinsurance.utils.enums.LanguageType
import com.azamovhudstc.infinityinsurance.utils.screenCurrentEnum
import com.azamovhudstc.infinityinsurance.utils.screenEnum
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppReference @Inject constructor(
    @ApplicationContext
    context: Context,
) {
    private var sharedPref: SharedPreferences = context.getSharedPreferences("impex_shp", MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPref.edit()


    var currentLanguage: LanguageType
        get() = sharedPref.getString("language", null)!!.screenEnum()
        set(value) {
            editor.putString("language", value.name).apply()
        }





    var currentScreenEnum: CurrentScreenEnum
        get() = sharedPref.getString("current_language", CurrentScreenEnum.LANGUAGE.name)!!.screenCurrentEnum()
        set(value) {
            sharedPref.edit().putString("current_language", value.name).apply()
        }

    var token: String
        get() = sharedPref.getString("token", "null")!!
        set(value) {
            sharedPref.edit().putString("token", value.toString()).apply()
        }

    var phone: String
        get() = sharedPref.getString("phone", "")!!
        set(value) {
            sharedPref.edit().putString("phone", value.toString()).apply()
        }


}