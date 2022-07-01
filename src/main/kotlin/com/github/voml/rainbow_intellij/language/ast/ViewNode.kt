package com.github.voml.rainbow_intellij.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

abstract class ViewNode(node: ASTNode) : ASTWrapperPsiElement(node),
    NavigatablePsiElement {

}