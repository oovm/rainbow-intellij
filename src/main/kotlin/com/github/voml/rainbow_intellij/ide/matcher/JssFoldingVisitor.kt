package com.github.voml.rainbow_intellij.ide.matcher

import com.github.voml.rainbow_intellij.language.psi.RainBraceBlock
import com.github.voml.rainbow_intellij.language.psi.RainBracketBlock
import com.github.voml.rainbow_intellij.language.psi.RbRecursiveVisitor
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.psi.PsiElement

class JssFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : RbRecursiveVisitor() {
    override fun visitBraceBlock(o: RainBraceBlock) {
        fold(o)
    }

    override fun visitBracketBlock(o: RainBracketBlock) {
        fold(o)
    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}
