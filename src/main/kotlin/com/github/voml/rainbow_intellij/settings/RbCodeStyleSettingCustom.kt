package com.github.voml.rainbow_intellij.settings

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

class RbCodeStyleSettingCustom(settings: CodeStyleSettings?) : CustomCodeStyleSettings(
    "RainbowCodeStyleSettings",
    settings
)