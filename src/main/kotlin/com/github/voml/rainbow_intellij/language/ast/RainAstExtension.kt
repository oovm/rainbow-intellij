package com.github.voml.rainbow_intellij.language.ast

import com.github.voml.rainbow_intellij.language.psi.*
import com.github.voml.rainbow_intellij.language.psi_node.RainFieldStatementNode
import com.github.voml.rainbow_intellij.language.psi_node.RainIdentifierNode
import com.github.voml.rainbow_intellij.language.psi_node.RainLanguageStatementNode
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.util.PsiTreeUtil

class RainAstExtension {
    companion object {
        @JvmStatic
        fun getKeyword(node: RainSchemaStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }

        @JvmStatic
        fun getKeyword(node: RainLanguageStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }

        @JvmStatic
        fun getFields(node: RainLanguageStatement?): MutableList<out RainFieldStatementNode> {
            return when (node) {
                null -> mutableListOf()
                else -> PsiTreeUtil.getChildrenOfTypeAsList(node.braceBlock, RainFieldStatementNode::class.java)
            }
        }

        @JvmStatic
        fun getFields(node: RainMetaStatement?): MutableList<out RainFieldStatementNode> {
            return when (node) {
                null -> mutableListOf()
                else -> PsiTreeUtil.getChildrenOfTypeAsList(node.braceBlock, RainFieldStatementNode::class.java)
            }
        }
    }
}