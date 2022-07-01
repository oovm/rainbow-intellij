package com.github.voml.rainbow_intellij.language.ast

import com.github.voml.rainbow_intellij.language.psi.RainGlobalStatement
import com.github.voml.rainbow_intellij.language.psi.RainIdentifier
import com.github.voml.rainbow_intellij.language.psi.RainMetaStatement
import com.github.voml.rainbow_intellij.language.psi.RainSchemaStatement
import com.github.voml.rainbow_intellij.language.psi_node.RainIdentifierNode

class RainAstExtension {
    companion object {
        @JvmStatic
        fun getSchema(node: RainSchemaStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }

        @JvmStatic
        fun getMeta(node: RainMetaStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }

        @JvmStatic
        fun getGlobal(node: RainGlobalStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }
    }
}