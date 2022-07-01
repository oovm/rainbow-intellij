package com.github.voml.rainbow_intellij.ide.view

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
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
//        is FluentFile -> getChildOfType(
//            FluentMessageNode::class.java,
//            FluentTermNode::class.java,
//        )
//        is FluentMessageNode, is FluentTermNode -> getChildOfType(
//            FluentAttributeNode::class.java,
//        )
//        is FluentAttributeNode -> arrayOf()
        else -> getChildOfType(
            NavigatablePsiElement::class.java,
        )
    }

    private fun getChildOfType(vararg classes: Class<out NavigatablePsiElement>): Array<RbViewElement> {
        return PsiTreeUtil.getChildrenOfAnyType(node, *classes)
            .map { RbViewElement(it) }
            .toTypedArray()
    }

}