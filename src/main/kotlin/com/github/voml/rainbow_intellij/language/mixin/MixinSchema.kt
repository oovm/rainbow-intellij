package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainIdentifier
import com.github.voml.rainbow_intellij.language.psi.RainSchemaStatement
import com.github.voml.rainbow_intellij.language.psi.RbNodeFactory
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class MixinSchema(node: ASTNode) : DeclareNode(node),
    RainSchemaStatement {
    override fun getNameIdentifier(): RainIdentifier = this.identifier

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.MultipleTypeDefinitions

    override fun setName(name: String): PsiElement {
        this.identifier.replace(RbNodeFactory(this.project).createSchemaID(name))
        return this.identifier
    }
}