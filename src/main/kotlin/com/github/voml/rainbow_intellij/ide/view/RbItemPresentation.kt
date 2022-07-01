package com.github.voml.rainbow_intellij.ide.view

import com.intellij.navigation.ItemPresentation
import javax.swing.Icon

class RbItemPresentation(private val icon: Icon, private val text: String): ItemPresentation {
    override fun getPresentableText(): String =text
    override fun getIcon(unused: Boolean): Icon =icon
}
