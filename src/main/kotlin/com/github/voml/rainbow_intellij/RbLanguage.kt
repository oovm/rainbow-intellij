package com.github.voml.rainbow_intellij

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class RbLanguage private constructor() : Language("Rainbow") {
    companion object {
        @JvmStatic
        val INSTANCE = RbLanguage()

        @NonNls
        const val BUNDLE = "messages.JssBundle"
    }
}


