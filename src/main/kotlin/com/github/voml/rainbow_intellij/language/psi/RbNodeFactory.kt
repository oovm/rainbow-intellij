package com.github.voml.rainbow_intellij.language.psi

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.file.RainbowLanguage
import com.github.voml.rainbow_intellij.language.psi_node.RainIdentifierNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.ui.ColorUtil
import java.awt.Color

class RbNodeFactory(private var project: Project) {

    fun createFile(text: String): RainbowFile {
        return PsiFileFactory.getInstance(project).createFileFromText(RainbowLanguage.INSTANCE, text) as RainbowFile
    }

    fun createColor(color: Color): PsiElement {
        val file = createFile("meta{color:#${ColorUtil.toHex(color).uppercase()}}")
        return PsiTreeUtil.findChildOfType(file, RainColorLiteral::class.java)!!.firstChild
    }

    fun createMetaID(id: String): RainIdentifierNode {
        val file = createFile("$id{}")
        return PsiTreeUtil.findChildOfType(file, RainIdentifierNode::class.java)!!
    }

    fun createLanguageID(id: String): RainIdentifierNode {
        val file = createFile("language $id{}")
        return PsiTreeUtil.findChildOfType(file, RainIdentifierNode::class.java)!!
    }
}