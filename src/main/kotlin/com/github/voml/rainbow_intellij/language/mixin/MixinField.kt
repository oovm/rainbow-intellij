package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainFieldStatement
import com.github.voml.rainbow_intellij.language.psi.RainKey
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

abstract class MixinField(node: ASTNode) : DeclareNode(node),
    RainFieldStatement {
    override fun getNameIdentifier(): RainKey {
        return this.key
    }

    override fun getPresentation(): ItemPresentation = when {
        this.array != null -> {
            RbItemPresentation(
                AllIcons.Gutter.OverridingMethod,
                "${nameIdentifier.text}:",
                this.array!!.firstChild.text
            )
        }
        else -> {
            RbItemPresentation(AllIcons.Gutter.OverridingMethod, nameIdentifier.text)
        }
    }


    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}