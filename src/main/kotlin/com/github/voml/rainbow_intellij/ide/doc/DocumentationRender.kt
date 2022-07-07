package com.github.voml.rainbow_intellij.ide.doc

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.file.RainbowLanguage
import com.github.voml.rainbow_intellij.ide.highlight.RainbowColor
import com.github.voml.rainbow_intellij.ide.highlight.RainbowColor.*
import com.github.voml.rainbow_intellij.language.psi_node.RainLanguageStatementNode
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.ui.ColorUtil

class DocumentationRender(var element: PsiElement, private var original: PsiElement?) {
    private val doc = StringBuilder()
    fun onHover(): String {
        when (element) {
            is RainLanguageStatementNode -> {
                buildShort(element as RainLanguageStatementNode)
            }
            else -> doc.append("onHover: $element")
        }
        return doc.toString()
    }

    fun onDetail(): String {
        when (element.elementType) {
            else -> {}
        }
        when (element) {
            is RainLanguageStatementNode -> {
                buildDetail(element as RainLanguageStatementNode)
            }
            else -> {
                doc.append("onDetail: ${element}")
            }
        }
        return doc.toString()
    }

    private fun buildShort(element: RainLanguageStatementNode) {
        append(KEYWORD, "language ")
        appendSchemaName(true)
        append(SYM_LANGUAGE, element.name)
        appendNewline()
    }

    private fun buildDetail(element: RainLanguageStatementNode) {
        buildShort(element)
        // defines
        append(KEYWORD, "defines")
        appendNewline()
        element.fields.forEach {
            append("&nbsp;&nbsp;&nbsp;&nbsp;")
            append(SYM_ATTRIBUTE, it.name)
            appendNewline()
        }
        // inherits
        append(KEYWORD, "inherits")
        appendNewline()
    }

    /// get the path relative to the project root
    /// FIXME: get real declare module
    private fun appendNamespace() {
        val file = element.containingFile;
        // fake module path
        val path = file.virtualFile.path.substringAfter("src/").replace("/", "::").replace(".vk", "")
        append(path)
    }

    private fun append(text: String) {
        doc.append("<span>${text}</span>")
    }

    private fun append(key: RainbowColor, text: String) {
        // HtmlSyntaxInfoUtil.getStyledSpan(key.textAttributesKey, text, 1.0f)
        val attr = EditorColorsManager.getInstance().globalScheme.getAttributes(key.textAttributesKey)
        val color = ColorUtil.toHtmlColor(attr.foregroundColor)
        doc.append("<span style='color:${color}'>${text}</span>")
    }

    private fun appendHighlight(code: String) {
        HtmlSyntaxInfoUtil.appendHighlightedByLexerAndEncodedAsHtmlCodeSnippet(
            doc,
            element.project,
            RainbowLanguage.INSTANCE,
            code.trimIndent(),
            1.0f,
        )
    }

    private fun appendAdd() {
        doc.append("<span>+</span>")
    }

    private fun appendNewline() {
        doc.append("<br/>")
    }

    private fun appendSchemaName(withDot: Boolean = false) {
        val file = element.containingFile as RainbowFile
        file.getSchemaStatement()?.let {
            append(SYM_SCHEMA, it.identifier.text)
            if (withDot) {
                append(".")
            }
        }
    }

    private fun appendLanguage() {
//        append(ValkyrieHighlightColor.KEYWORD, "keyword ")
//        append(ValkyrieHighlightColor.SYM_MACRO, "extends")
        doc.append("<hr/>")
        appendHighlight(
            """
        extends Point {
            def eq(self, other: Self) -> bool { }
        }
        """
        )

    }
}