package com.github.voml.rainbow_intellij.ide.completion


import com.github.voml.rainbow_intellij.language.psi.RbToken
import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns

class RbCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(RbToken.SYMBOL),
            RbSymbolCompletion()
        )
    }
}

