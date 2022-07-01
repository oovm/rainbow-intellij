// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.voml.rainbow_intellij.ide.view.grouper

import com.github.voml.rainbow_intellij.file.RainbowBundle
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.smartTree.*
import com.intellij.util.PlatformIcons

object PropertiesGrouper : Grouper {
    override fun getName(): String = "view.PropertiesGrouper"
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        RainbowBundle.message(this.name),
        "GGGGG",
        PlatformIcons.ABSTRACT_CLASS_ICON
    )

    override fun group(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<TreeElement>,
    ): MutableCollection<Group> {
        return arrayListOf()
    }
}