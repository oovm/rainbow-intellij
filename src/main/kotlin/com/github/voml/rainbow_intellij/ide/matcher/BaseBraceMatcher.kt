package com.github.voml.rainbow_intellij.ide.matcher


import com.github.voml.rainbow_intellij.language.psi.JSS_COMMENT
import com.github.voml.rainbow_intellij.language.psi.RbToken
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class BaseBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean {
        return next in InsertPairBraceBefore
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val PAIRS = arrayOf(
            BracePair(RbToken.BRACE_L, RbToken.BRACE_R, true),
            BracePair(RbToken.BRACKET_L, RbToken.BRACKET_R, true),
            BracePair(RbToken.PARENTHESIS_L, RbToken.PARENTHESIS_R, true),
            // BracePair(VomlTypes.EXT_PREFIX, VomlTypes.BRACKETR, false)
        )

        private val InsertPairBraceBefore = TokenSet.orSet(
            JSS_COMMENT,
            TokenSet.create(
                TokenType.WHITE_SPACE,
                RbToken.COMMA,
                RbToken.PARENTHESIS_R,
                RbToken.BRACKET_R,
                RbToken.BRACE_R,
            )
        )
    }
}
