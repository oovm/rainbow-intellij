package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainGlobalStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

abstract class MixinGlobal(node: ASTNode) : DeclareNode(node),
    RainGlobalStatement {
    override fun getNameIdentifier(): PsiElement {
        return this.keyword
    }

    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.Nodes.ClassInitializer, "@Global")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}