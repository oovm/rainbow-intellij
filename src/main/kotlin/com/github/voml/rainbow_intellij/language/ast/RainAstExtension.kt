package com.github.voml.rainbow_intellij.language.ast

import com.github.voml.rainbow_intellij.language.psi.RainGlobalStatement
import com.github.voml.rainbow_intellij.language.psi.RainIdentifier
import com.github.voml.rainbow_intellij.language.psi.RainLanguageStatement
import com.github.voml.rainbow_intellij.language.psi.RainMetaStatement
import com.github.voml.rainbow_intellij.language.psi.RainSchemaStatement
import com.github.voml.rainbow_intellij.language.psi_node.RainIdentifierNode

class RainAstExtension {
    companion object {
        @JvmStatic
        fun getKeyword(node: RainSchemaStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }

        @JvmStatic
        fun getKeyword(node: RainMetaStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }

        @JvmStatic
        fun getKeyword(node: RainGlobalStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }
        @JvmStatic
        fun getKeyword(node: RainLanguageStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }

    }
}