package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.ViewNode
import com.github.voml.rainbow_intellij.language.psi.RainMetaStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation

abstract class MixinMeta(node: ASTNode) : ViewNode(node),
    RainMetaStatement {
    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.Nodes.ClassInitializer, "@MetaInfo")
    }
}