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
    override fun clone(): HighlightVisitor = RbNodeHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is RainbowFile

    override fun visit(element: PsiElement) = element.accept(this)

    override fun visitSchemaStatement(o: RainSchemaStatement) {
        highlight(o.keyword, RainbowColor.KEYWORD)
        highlight(o.identifier, RainbowColor.SYM_SCHEMA)
        o.inherit?.let {
            highlight(it.identifier, RainbowColor.SYM_SCHEMA)
        }
    }

    override fun visitMetaStatement(o: RainMetaStatement) {
        if (o.identifier.text == "global") {
            highlight(o.identifier, RainbowColor.KEYWORD)
        } else {
            highlight(o.identifier, RainbowColor.SYM_SCHEMA)
        }
    }

    override fun visitFieldStatement(o: RainFieldStatement) {
        val s = o.superParent(2);
        if (s is RainLanguageStatement) {
            highlight(o.key, RainbowColor.SYM_ATTRIBUTE)
        } else if (s is RainMetaStatement && s.identifier.text == "global") {
            highlight(o.key, RainbowColor.SYM_ATTRIBUTE)
        } else {
            highlight(o.key, RainbowColor.SYM_FIELD)
        }
    }

    override fun visitLanguageStatement(o: RainLanguageStatement) {
        highlight(o.keyword, RainbowColor.KEYWORD)
        highlight(o.identifier, RainbowColor.SYM_LANGUAGE)
    }

    override fun visitInherit(o: RainInherit) {
        highlight(o.identifier, RainbowColor.SYM_LANGUAGE)
    }

    override fun visitNamespace(o: RainNamespace) {
        when (o.text) {
            "italic", "bold", "underline" -> {
                highlight(o, RainbowColor.KEYWORD)
                return
            }
            else -> {}
        }
        //TODO: resolve kind
        if (o.identifierList.count() == 1) {
            highlight(o, RainbowColor.SYM_ATTRIBUTE)
        } else {
            highlight(o.identifierList[0], RainbowColor.SYM_SCHEMA)
            highlight(o.identifierList[1], RainbowColor.SYM_FIELD)
        }
    }

    private fun highlight(element: PsiElement, color: RainbowColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    private fun missing(element: PsiElement) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.WRONG_REF)
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
}

