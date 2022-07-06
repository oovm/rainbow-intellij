package com.github.voml.rainbow_intellij.ide.reference

import com.github.voml.rainbow_intellij.language.psi.RainLanguageStatement
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.psi.xml.XmlEntityRef

class RbReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(RainLanguageStatement::class.java),
            RbReferenceProvider()
        )
    }
}