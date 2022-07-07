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
import javax.swing.Icon

abstract class MixinMeta(node: ASTNode) : DeclareNode(node),
    RainMetaStatement {
    override fun getNameIdentifier(): RainIdentifier {
        return this.identifier
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.ClassInitializer

    override fun setName(name: String): PsiElement {
        // TODO: check duplicate name
        this.identifier.replace(RbNodeFactory(this.project).createMetaID(name))
        return this.identifier
    }
}