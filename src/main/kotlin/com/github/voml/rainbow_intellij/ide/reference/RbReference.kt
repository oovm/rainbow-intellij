package com.github.voml.rainbow_intellij.ide.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

class RbReference(var kind: RbReferenceKind, private var target: PsiElement) : PsiReference {
    var children: Map<String, PsiReference> = mapOf()
    override fun getElement(): PsiElement = target

    override fun getRangeInElement(): TextRange = element.textRange

    override fun resolve(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getCanonicalText(): String {
        TODO("Not yet implemented")
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSoft(): Boolean {
        TODO("Not yet implemented")
    }

}