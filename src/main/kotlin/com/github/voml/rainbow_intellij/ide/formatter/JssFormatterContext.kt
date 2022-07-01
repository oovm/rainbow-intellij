package com.github.voml.rainbow_intellij.ide.formatter

import com.github.voml.rainbow_intellij.file.RainbowLanguage
import com.github.voml.rainbow_intellij.language.psi.RbToken

import com.intellij.formatting.SpacingBuilder
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CommonCodeStyleSettings
import com.intellij.psi.tree.TokenSet

data class JssFormatterContext(
    val commonSettings: CommonCodeStyleSettings,
    val spacingBuilder: SpacingBuilder
) {
    companion object {
        fun create(settings: CodeStyleSettings): JssFormatterContext {
            val commonSettings = settings.getCommonSettings(RainbowLanguage.INSTANCE)
            return JssFormatterContext(commonSettings, createSpacingBuilder(commonSettings))
        }

        private val remove_space_before = TokenSet.create(
            RbToken.PARENTHESIS_R,
            RbToken.BRACKET_R,
            RbToken.COMMA,
            RbToken.SEMICOLON
        )
        private val remove_space_after = TokenSet.create(
            RbToken.PARENTHESIS_L,
            RbToken.BRACKET_L,
            RbToken.COLON,
        )
        private val remove_space_newline_after = TokenSet.create(RbToken.IDIOM_MARK, RbToken.PROPERTIES_MARK)

        private val separators = TokenSet.create(RbToken.COMMA, RbToken.SEMICOLON)

        private fun createSpacingBuilder(commonSettings: CommonCodeStyleSettings): SpacingBuilder {
            val custom = SpacingBuilder(commonSettings)
                // ,
                .after(separators).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // k: v
                .after(RbToken.COLON).spacing(1, 1, 0, false, 0)
                // k = v
                .around(RbToken.EQ).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)
                // SpacingBuilder { }
                .before(RbToken.PROPERTIES_BLOCK).spacing(1, 1, 0, commonSettings.KEEP_LINE_BREAKS, 0)

            return custom
                .before(remove_space_before).spaceIf(false)
                .after(remove_space_after).spaceIf(false)
                .after(remove_space_newline_after).spacing(0, 0, 0, false, 0)
        }
    }
}