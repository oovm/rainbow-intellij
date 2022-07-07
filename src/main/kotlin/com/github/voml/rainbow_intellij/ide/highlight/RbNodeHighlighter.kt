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
        o.inherit?.let {
            highlight(it.identifier, RainbowColor.SYM_SCHEMA)
        }
    }

    override fun visitMetaStatement(o: RainMetaStatement) {
        highlight(o.identifier, RainbowColor.KEYWORD)
        when (o.identifier.text) {
            "global" -> {
                o.braceBlock.children.forEach {
                    if (it is RainFieldStatement) {
                        highlight(it.key, RainbowColor.SYM_ATTRIBUTE)
                    }
                }
            }
            else -> {
                o.braceBlock.children.forEach {
                    if (it is RainFieldStatement) {
                        highlight(it.key, RainbowColor.SYM_FIELD)
                    }
                }
            }
        }

    }

    override fun visitLanguageStatement(o: RainLanguageStatement) {
        highlight(o.keyword, RainbowColor.KEYWORD)
        highlight(o.identifier, RainbowColor.SYM_LANGUAGE)
        o.braceBlock.children.forEach {
            if (it is RainFieldStatement) {
                highlight(it.key, RainbowColor.SYM_ATTRIBUTE)
            }
        }
    }

    override fun visitInherit(o: RainInherit) {
        highlight(o.identifier, RainbowColor.SYM_LANGUAGE)
    }

    override fun visitNamespace(o: RainNamespace) {
        super.visitNamespace(o)
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

