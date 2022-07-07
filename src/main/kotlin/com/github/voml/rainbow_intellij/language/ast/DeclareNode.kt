package com.github.voml.rainbow_intellij.language.ast

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import javax.swing.Icon

abstract class DeclareNode(node: ASTNode) : ASTWrapperPsiElement(node),
    NavigatablePsiElement,
    PsiNameIdentifierOwner {
    abstract override fun getNameIdentifier(): PsiElement
    abstract override fun getIcon(flags: Int): Icon

    override fun getNavigationElement(): PsiElement = nameIdentifier
    override fun getName(): String = nameIdentifier.text

    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.Nodes.ClassInitializer, name)
    }
    override fun getTextOffset(): Int {
        return nameIdentifier.textOffset
    }
}