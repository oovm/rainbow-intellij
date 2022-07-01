package com.github.voml.rainbow_intellij.ide.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceService

class RbReferenceService : PsiReferenceService() {
    private var children: Map<String, PsiReference> = mapOf()
    override fun getReferences(element: PsiElement, hints: Hints): MutableList<PsiReference> {
        TODO("Not yet implemented")
    }

    fun insertReference(name: String, reference: PsiReference) {
        children = children + (name to reference)
    }
}