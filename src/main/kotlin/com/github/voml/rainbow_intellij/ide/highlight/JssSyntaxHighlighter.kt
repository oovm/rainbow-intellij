package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.language.psi.RbLexerAdapter
import com.github.voml.rainbow_intellij.language.psi.RbToken.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class JssSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return RbLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): Color? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
            BRACKET_L, BRACKET_R -> Color.BRACKETS
            BRACE_L, BRACE_R -> Color.BRACES
            COLON, EQ -> Color.SET
            COMMA -> Color.COMMA
            // atom
            INTEGER -> Color.INTEGER
            DECIMAL -> Color.DECIMAL
            URL -> Color.URL
            STRING -> Color.STRING
            SYMBOL -> Color.IDENTIFIER
            // 注释
            COMMENT -> Color.LINE_COMMENT
            COMMENT_BLOCK -> Color.BLOCK_COMMENT
            COMMENT_DOCUMENT -> Color.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
            else -> null
        }
    }
}
