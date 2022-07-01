package com.github.voml.rainbow_intellij.ide.view.filter


import com.github.voml.rainbow_intellij.file.RainbowBundle
import com.github.voml.rainbow_intellij.ide.view.RbViewElement
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement


object PublicElementsFilter : Filter {
    override fun getName() = "view.PublicElementsFilter"

    override fun isReverted() = true
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        RainbowBundle.message(name),
        null,
        AllIcons.Nodes.Public
    )
    override fun isVisible(treeNode: TreeElement): Boolean {
        return (treeNode as? RbViewElement)?.getVisibility() ?: true
    }
}
