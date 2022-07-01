package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainSchemaStatement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class MixinSchema(node: ASTNode) : DeclareNode(node),
    RainSchemaStatement {
    override fun getNameIdentifier(): PsiElement {
        return this.identifier
    }
    
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}