package com.github.voml.rainbow_intellij.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

abstract class DeclareNode(node: ASTNode) : ASTWrapperPsiElement(node),
    NavigatablePsiElement,
    PsiNameIdentifierOwner {
    abstract override fun getNameIdentifier(): PsiElement;

    override fun getName(): String? {
        return nameIdentifier.text
    }
    override fun getNavigationElement(): PsiElement {
        return nameIdentifier
    }
    override fun getTextOffset(): Int {
        return nameIdentifier.textOffset
    }
}