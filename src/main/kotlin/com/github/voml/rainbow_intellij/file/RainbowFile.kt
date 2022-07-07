package com.github.voml.rainbow_intellij.file

import com.github.voml.rainbow_intellij.language.psi_node.RainLanguageStatementNode
import com.github.voml.rainbow_intellij.language.psi_node.RainMetaStatementNode
import com.github.voml.rainbow_intellij.language.psi_node.RainSchemaStatementNode
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.util.PsiTreeUtil

class RainbowFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, RainbowLanguage.INSTANCE) {
    override fun getFileType(): FileType = RainbowFileType.INSTANCE

    override fun toString(): String = RainbowBundle.message("action.create_file")


    fun getSchemaStatement(): RainSchemaStatementNode? {
        return PsiTreeUtil
            .getChildrenOfAnyType(this, RainSchemaStatementNode::class.java)
            .firstOrNull()
    }

    fun getGlobalStatements(): RainMetaStatementNode? {
        return PsiTreeUtil
            .getChildrenOfAnyType(this, RainMetaStatementNode::class.java)
            .firstOrNull {
                it.identifier.text == "global"
            }
    }

    fun getLanguageStatements(): MutableMap<String, RainLanguageStatementNode> {
        val map = mutableMapOf<String, RainLanguageStatementNode>()
        PsiTreeUtil
            .getChildrenOfAnyType(this, RainLanguageStatementNode::class.java)
            .forEach {
                map[it.identifier.text] = it
            }
        return map
    }

    fun getMetaStatements(): MutableMap<String, RainMetaStatementNode> {
        val map = mutableMapOf<String, RainMetaStatementNode>()
        PsiTreeUtil
            .getChildrenOfAnyType(this, RainMetaStatementNode::class.java)
            .forEach {
                map[it.identifier.text] = it
            }
        return map
    }
}