package com.github.voml.rainbow_intellij.ast

import com.github.voml.rainbow_intellij.ide.formatter.RbFormatterContext
import com.github.voml.rainbow_intellij.ide.formatter.RbFormattingModelBuilder
import com.github.voml.rainbow_intellij.language.psi.RbToken

import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.Spacing
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType

private fun RainAstBlock.computeIndent(child: ASTNode): Indent? {
    val isCornerChild = node.firstChildNode == child || node.lastChildNode == child
    return when (node.elementType) {
        RbToken.BRACKET_BLOCK -> when {
            isCornerChild -> Indent.getNoneIndent()
            else -> Indent.getNormalIndent()
        }
        RbToken.BRACE_BLOCK -> when {
            isCornerChild -> Indent.getNoneIndent()
            else -> Indent.getNormalIndent()
        }
        else -> Indent.getNoneIndent()
    }
}

fun RainAstBlock.buildChildren(): List<Block> {
    return node.getChildren(null)
        .filter { !it.isWhitespaceOrEmpty() }
        .map { childNode ->
            RbFormattingModelBuilder.createBlock(
                node = childNode,
                alignment = null,
                indent = computeIndent(childNode),
                wrap = null,
                ctx
            )
        }
}

private fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun Block.computeSpacing(child1: Block?, child2: Block, ctx: RbFormatterContext): Spacing? {
    return ctx.spacingBuilder.getSpacing(this, child1, child2)
}
