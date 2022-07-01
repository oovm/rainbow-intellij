package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class RbNodeHighlighter : RbRecursiveVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitSchemaStatement(o: RainSchemaStatement) {
        highlight(o.keyword, RainbowColor.KEYWORD)
        highlight(o.identifier, RainbowColor.SYM_SCHEMA)
    }

    override fun visitMetaStatement(o: RainMetaStatement) {
        highlight(o.keyword, RainbowColor.KEYWORD)
    }

    override fun visitGlobalStatement(o: RainGlobalStatement) {
        highlight(o.keyword, RainbowColor.KEYWORD)
    }

    override fun visitAttributeStatement(o: RainAttributeStatement) {
        when (o.key.text) {
            "default" -> {
                highlight(o.key, RainbowColor.KEYWORD)
            }
            else -> {
                highlight(o.key, RainbowColor.SYM_ATTRIBUTE)
            }
        }
    }

    override fun visitFieldStatement(o: RainFieldStatement) {
        highlight(o.key, RainbowColor.SYM_FIELD)
    }

    override fun visitLanguageStatement(o: RainLanguageStatement) {
        highlight(o.keyword, RainbowColor.KEYWORD)
        highlight(o.identifier, RainbowColor.SYM_LANGUAGE)
    }

    override fun visitLanguageInherit(o: RainLanguageInherit) {
        highlight(o.identifier, RainbowColor.SYM_LANGUAGE)
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
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()
        return true
    }

    override fun clone(): HighlightVisitor = RbNodeHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is RainbowFile

    override fun visit(element: PsiElement) = element.accept(this)
}

