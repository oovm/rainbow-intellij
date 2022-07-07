package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.psi.RainLanguageStatement
import com.github.voml.rainbow_intellij.language.psi.RbNodeFactory
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

abstract class MixinLanguage(node: ASTNode) : DeclareNode(node),
    RainLanguageStatement {
    override fun getNameIdentifier(): PsiElement {
        return this.identifier.firstChild
    }


    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.FileTypes.AddAny, nameIdentifier.text)
    }

    override fun setName(name: String): PsiElement {
        // TODO: check duplicate name
        this.identifier.replace(RbNodeFactory(this.project).createLanguageID(name))
        return this.identifier
    }
}