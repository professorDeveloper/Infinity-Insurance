package com.azamovhudstc.infinityinsurance.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object LocalObjectExt {
    fun containsThreeLetters(text: String): Boolean {
        var letterCount = 0
        for (char in text) {
            if (char.isLetter()) {
                letterCount++
                if (letterCount >= 3) {
                    return true
                }
            }
        }
        return false
    }

    fun containsThreeNumbers(text: String): Boolean {
        var numberCount = 0
        for (char in text) {
            if (char.isDigit()) {
                numberCount++
                if (numberCount >= 3) {
                    return true
                }
            }
        }
        return false
    }

    fun containsUpperCase(text: String): Boolean {
        for (char in text) {
            if (char.isUpperCase()) {
                return true
            }
        }
        return false
    }
    fun parseCode(message: String): String {
        val p: Pattern = Pattern.compile("\\b\\d{6}\\b")
        val m: Matcher = p.matcher(message)
        var code = ""
        while (m.find()) {
            code = m.group(0)
        }
        return code
    }
}