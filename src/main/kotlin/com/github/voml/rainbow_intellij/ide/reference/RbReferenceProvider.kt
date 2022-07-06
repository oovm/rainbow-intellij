package com.github.voml.rainbow_intellij.ide.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceService
import com.intellij.util.ProcessingContext


class RbReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        TODO("Not yet implemented")
    }

    override fun acceptsHints(element: PsiElement, hints: PsiReferenceService.Hints): Boolean {
        return super.acceptsHints(element, hints)
    }
}
