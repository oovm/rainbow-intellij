package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.language.psi_node.RainColorNode
import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import java.awt.Color

class RbElementColorProvider : ElementColorProvider {
    override fun getColorFrom(element: PsiElement): Color? {
        if (element is RainColorNode) {
            return element.color
        } else {
            return null
        }
    }

    override fun setColorTo(element: PsiElement, color: Color) {
        TODO("Not yet implemented")
    }
}

