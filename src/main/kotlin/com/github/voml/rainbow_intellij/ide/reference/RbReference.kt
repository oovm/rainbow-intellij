package com.github.voml.rainbow_intellij.ide.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.impl.CachingReference

class RbReference(private var target: PsiElement) : CachingReference() {
    var children: Map<String, PsiReference> = mapOf()
    var kind: RbReferenceKind = RbReferenceKind.UNKNOWN
    override fun getElement(): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getRangeInElement(): TextRange {
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

    override fun resolveInner(): PsiElement? {
        TODO("Not yet implemented")
    }


}