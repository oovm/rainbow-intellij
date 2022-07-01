package com.github.voml.rainbow_intellij.language.psi

import com.github.voml.rainbow_intellij.language.psi.RainVisitor
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveVisitor

open class RbRecursiveVisitor : RainVisitor(), PsiRecursiveVisitor {
    override fun visitElement(element: PsiElement) {
        ProgressManager.checkCanceled()
        element.acceptChildren(this)
    }
}
