package com.github.voml.rainbow_intellij.language.mixin

import com.github.voml.rainbow_intellij.ide.view.RbItemPresentation
import com.github.voml.rainbow_intellij.language.ast.ViewNode
import com.github.voml.rainbow_intellij.language.psi.RainGlobalStatement
import com.github.voml.rainbow_intellij.language.psi.RainMetaStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation

abstract class MixinGlobal(node: ASTNode) : ViewNode(node),
    RainGlobalStatement {
    override fun getPresentation(): ItemPresentation {
        return RbItemPresentation(AllIcons.Nodes.ClassInitializer, "@MetaInfo")
    }
}