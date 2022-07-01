package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.language.ast.DeclareNode
import com.github.voml.rainbow_intellij.language.ast.ViewNode
import com.github.voml.rainbow_intellij.language.psi.RainGlobalStatement
import com.github.voml.rainbow_intellij.language.psi.RainSchemaStatement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class MixinGlobal(node: ASTNode) : ViewNode(node),
    RainGlobalStatement {

}