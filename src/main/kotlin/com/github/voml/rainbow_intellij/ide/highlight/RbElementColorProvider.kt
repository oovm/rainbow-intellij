package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.language.psi.RbNodeFactory
import com.github.voml.rainbow_intellij.language.psi.RbToken
import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.ui.ColorUtil
import java.awt.Color

class RbElementColorProvider : ElementColorProvider {
    override fun getColorFrom(element: PsiElement): Color? = when (element.elementType) {
        RbToken.COLOR -> try {
            ColorUtil.fromHex(element.text)
        } catch (e: Exception) {
            null
        }
        else -> null
    }


    override fun setColorTo(element: PsiElement, color: Color) {
        // element = RbToken.COLOR
        val node = RbNodeFactory(element.project).createColor(color)
        element.replace(node)
    }
}
