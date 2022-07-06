package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.reference.RbReference
import com.github.voml.rainbow_intellij.language.psi.RainNamespace
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

abstract class MixinNamespace(node: ASTNode) : ASTWrapperPsiElement(node),
    RainNamespace {
    override fun getReference(): PsiReference? {
        return references.lastOrNull()
    }

    override fun getReferences(): Array<PsiReference> {
        return this.getIdentifierList().map {
            RbReference(it)
        }.toTypedArray()


    }
}

