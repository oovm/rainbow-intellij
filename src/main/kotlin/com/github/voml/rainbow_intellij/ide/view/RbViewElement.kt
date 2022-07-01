package com.github.voml.rainbow_intellij.ide.view

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.language.psi_node.RainAttributeStatementNode
import com.github.voml.rainbow_intellij.language.psi_node.RainGlobalStatementNode
import com.github.voml.rainbow_intellij.language.psi_node.RainMetaStatementNode
import com.github.voml.rainbow_intellij.language.psi_node.RainSchemaStatementNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class RbViewElement(private val node: NavigatablePsiElement, var view: RbItemPresentation? = null) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any = node

    override fun navigate(requestFocus: Boolean) = node.navigate(requestFocus)

    override fun canNavigate(): Boolean = node.canNavigate()

    override fun canNavigateToSource(): Boolean = node.canNavigateToSource()

    override fun getAlphaSortKey(): String = node.name ?: ""

    override fun getPresentation(): ItemPresentation {
        return when {
            view != null -> view!!
            node.presentation != null -> node.presentation!!
            else -> PresentationData()
        }
    }


    // TODO: return object
    fun getVisibility(): Boolean = true

    override fun getChildren(): Array<out TreeElement> = when (node) {
        is RainbowFile -> getChildOfType(
            node,
            NavigatablePsiElement::class.java,
        )
        is RainSchemaStatementNode -> getChildOfType(
            node.braceBlock,
            RainAttributeStatementNode::class.java,
        )
        is RainMetaStatementNode -> getChildOfType(
            node.braceBlock,
            RainAttributeStatementNode::class.java,
        )
        is RainGlobalStatementNode -> getChildOfType(
            node.braceBlock,
            RainAttributeStatementNode::class.java,
        )
        else -> arrayOf()
    }

    private fun getChildOfType(
        root: PsiElement,
        vararg classes: Class<out NavigatablePsiElement>,
    ): Array<RbViewElement> {
        return PsiTreeUtil.getChildrenOfAnyType(root, *classes)
            .map { RbViewElement(it) }
            .toTypedArray()
    }

}