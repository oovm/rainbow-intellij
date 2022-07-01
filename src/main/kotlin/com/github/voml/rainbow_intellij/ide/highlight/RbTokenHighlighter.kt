package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.language.psi.RbLexerAdapter
import com.github.voml.rainbow_intellij.language.psi.RbToken.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class RbTokenHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return RbLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): RainbowColor? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> RainbowColor.PARENTHESES
            BRACKET_L, BRACKET_R -> RainbowColor.BRACKETS
            BRACE_L, BRACE_R -> RainbowColor.BRACES
            COLON, EQ -> RainbowColor.SET
            COMMA -> RainbowColor.COMMA
            // atom
            INTEGER -> RainbowColor.INTEGER
            DECIMAL -> RainbowColor.DECIMAL
            URL -> RainbowColor.URL
            STRING, STRING_RAW -> RainbowColor.STRING
            SYMBOL -> RainbowColor.IDENTIFIER
            COLOR_LITERAL -> RainbowColor.COLOR
            // 注释
            COMMENT -> RainbowColor.LINE_COMMENT
            COMMENT_BLOCK -> RainbowColor.BLOCK_COMMENT
            COMMENT_DOCUMENT -> RainbowColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> RainbowColor.BAD_CHARACTER
            else -> null
        }
    }
}
