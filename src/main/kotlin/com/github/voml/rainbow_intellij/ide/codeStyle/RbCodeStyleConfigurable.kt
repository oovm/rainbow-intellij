package com.github.voml.rainbow_intellij.ide.codeStyle

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class RbCodeStyleConfigurable(settings: CodeStyleSettings, cloneSettings: CodeStyleSettings?, displayName: String?) :
    CodeStyleAbstractConfigurable(settings, cloneSettings, displayName) {
    override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
        return RbCodeStyleMainPanel(currentSettings, settings)
    }
}