package com.github.voml.rainbow_intellij.language.ast

import com.github.voml.rainbow_intellij.language.psi.RainIdentifier
import com.github.voml.rainbow_intellij.language.psi.RainSchemaStatement
import com.github.voml.rainbow_intellij.language.psi_node.RainIdentifierNode

class RainAstExtension {
    companion object {
        @JvmStatic
        fun getSchema(node: RainSchemaStatement): RainIdentifier {
            return RainIdentifierNode(node.firstChild.node)
        }
    }
}