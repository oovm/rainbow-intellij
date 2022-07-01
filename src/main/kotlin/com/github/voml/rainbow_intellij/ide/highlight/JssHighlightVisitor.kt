package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class JssHighlightVisitor : RbRecursiveVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitSchemaStatement(o: RainSchemaStatement) {
        highlight(o.schema, RainbowColor.KEYWORD)
        highlight(o.identifier, RainbowColor.SYM_SCHEMA)
    }

    private fun highlight(element: PsiElement, color: RainbowColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable
    ): Boolean {
        infoHolder = holder
        action.run()
        return true
    }

    override fun clone(): HighlightVisitor = JssHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is RainbowFile

    override fun visit(element: PsiElement) = element.accept(this)
}

