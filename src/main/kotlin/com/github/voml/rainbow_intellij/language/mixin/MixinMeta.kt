package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.language.ast.ViewNode
import com.github.voml.rainbow_intellij.language.psi.RainMetaStatement
import com.intellij.lang.ASTNode

abstract class MixinMeta(node: ASTNode) : ViewNode(node),
    RainMetaStatement {

}