package com.github.voml.rainbow_intellij.file

import com.intellij.lang.Language
import org.jetbrains.annotations.NonNls

class RainbowLanguage private constructor() : Language("Rainbow") {
    companion object {
        @JvmStatic
        val INSTANCE = RainbowLanguage()

        @NonNls
        const val BUNDLE = "messages.RbBundle"
    }
}


