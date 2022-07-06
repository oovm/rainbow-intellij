package com.github.voml.rainbow_intellij.ide.reference

import com.github.voml.rainbow_intellij.language.psi_node.RainMetaStatementNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.util.findTopmostParentInFile

// CachingReference
class RbReference(private var source: PsiElement) : PsiReference {
    override fun getElement(): PsiElement {
        return source.parent
    }

    override fun getRangeInElement(): TextRange {
        return element.textRange
    }

    override fun resolve(): PsiElement? {
        return source.findTopmostParentInFile { it is RainMetaStatementNode }
    }

    override fun getCanonicalText(): String {
        return source.text
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement) = true

    override fun isSoft() = false
}