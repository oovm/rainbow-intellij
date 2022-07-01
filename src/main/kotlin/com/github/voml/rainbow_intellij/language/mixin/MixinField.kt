package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainFieldStatement
import com.github.voml.rainbow_intellij.language.psi.RainKey
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class MixinField(node: ASTNode) : DeclareNode(node),
    RainFieldStatement {
    override fun getNameIdentifier(): RainKey {
        return this.key
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}