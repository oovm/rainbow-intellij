/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package com.github.voml.rainbow_intellij.ide.doc

import com.intellij.lang.documentation.CodeDocumentationProvider
import com.intellij.openapi.util.Pair
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement


class RbDocumentationProvider : CodeDocumentationProvider {
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        return element?.let { DocumentationRender(it, originalElement).onDetail() }
    }

    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String {
        return DocumentationRender(element, originalElement).onHover()
    }

    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        return element?.let { generateHoverDoc(it, originalElement) }
    }

    override fun findExistingDocComment(contextElement: PsiComment?): PsiComment? {
        TODO("Not yet implemented")
    }

    override fun parseContext(startPoint: PsiElement): Pair<PsiElement, PsiComment>? {
        TODO("Not yet implemented")
    }

    override fun generateDocumentationContentStub(contextComment: PsiComment?): String? {
        TODO("Not yet implemented")
    }
}
