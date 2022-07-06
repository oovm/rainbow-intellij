package com.github.voml.rainbow_intellij.ide.todo

import com.github.voml.rainbow_intellij.language.psi.RbLexerAdapter
import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.language.psi.RB_COMMENT
import com.intellij.lexer.Lexer
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.search.IndexPatternBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class VomlTodoIndexPatternBuilder : IndexPatternBuilder {
    override fun getIndexingLexer(file: PsiFile): Lexer? {
        return if (file is RainbowFile) RbLexerAdapter() else null
    }

    override fun getCommentTokenSet(file: PsiFile): TokenSet? {
        return if (file is RainbowFile) RB_COMMENT else null
    }

    override fun getCommentStartDelta(tokenType: IElementType?): Int {
        return if (tokenType in RB_COMMENT) 2 else 0
    }

    override fun getCommentEndDelta(tokenType: IElementType?): Int = 0
}
