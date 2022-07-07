package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainLanguageStatement
import com.github.voml.rainbow_intellij.language.psi.RbNodeFactory
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.lang.documentation.psi.PsiDocumentationTargetFactory
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiDocCommentBase
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class MixinLanguage(node: ASTNode) : DeclareNode(node),
    RainLanguageStatement {
    override fun getNameIdentifier(): PsiElement {
        return this.identifier.firstChild
    }

    override fun getIcon(flags: Int): Icon = AllIcons.FileTypes.AddAny

    override fun setName(name: String): PsiElement {
        // TODO: check duplicate name
        this.identifier.replace(RbNodeFactory(this.project).createLanguageID(name))
        return this.identifier
    }
}