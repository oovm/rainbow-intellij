package com.github.voml.rainbow_intellij.ide.codeStyle

import com.github.voml.rainbow_intellij.RbLanguage
import com.intellij.application.options.GenerationCodeStylePanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.CodeStyleSettings

class RbCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings) :
    TabbedLanguageCodeStylePanel(RbLanguage.INSTANCE, currentSettings, settings) {
    override fun initTabs(settings: CodeStyleSettings) {
        addIndentOptionsTab(settings)
        addWrappingAndBracesTab(settings)
        addTab(GenerationCodeStylePanel(settings, RbLanguage.INSTANCE))
    }
}
