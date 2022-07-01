package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainAttributeStatement
import com.github.voml.rainbow_intellij.language.psi.RainFieldStatement
import com.github.voml.rainbow_intellij.language.psi.RainKey
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

abstract class MixinAttribute(node: ASTNode) : DeclareNode(node),
    RainAttributeStatement {
    override fun getNameIdentifier(): RainKey {
        return this.key
    }
    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.General.OverridingMethod, nameIdentifier.text)
    }
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}