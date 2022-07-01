package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainIdentifier
import com.github.voml.rainbow_intellij.language.psi.RainSchemaStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

abstract class MixinSchema(node: ASTNode) : DeclareNode(node),
    RainSchemaStatement {
    override fun getNameIdentifier(): RainIdentifier {
        return this.identifier
    }

    override fun getTextOffset(): Int {
        return nameIdentifier.textOffset
    }

    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.Nodes.MultipleTypeDefinitions, nameIdentifier.text)
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }
}