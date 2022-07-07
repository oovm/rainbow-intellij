package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainIdentifier
import com.github.voml.rainbow_intellij.language.psi.RainMetaStatement
import com.github.voml.rainbow_intellij.language.psi.RbNodeFactory
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

abstract class MixinMeta(node: ASTNode) : DeclareNode(node),
    RainMetaStatement {
    override fun getNameIdentifier(): RainIdentifier {
        return this.identifier
    }

    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.Nodes.ClassInitializer, "@MetaInfo")
    }

    override fun setName(name: String): PsiElement {
        // TODO: check duplicate name
        this.identifier.replace(RbNodeFactory(this.project).createMetaID(name))
        return this.identifier
    }
}