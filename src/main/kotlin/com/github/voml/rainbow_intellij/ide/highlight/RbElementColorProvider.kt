package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.file.RainbowLanguage
import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.ui.ColorUtil
import java.awt.Color

class RbElementColorProvider : ElementColorProvider {
    override fun getColorFrom(element: PsiElement): Color? {
        return when (element) {
            is RainColorNode -> ColorUtil.fromHex(element.text)
            else -> null
        }
    }

    override fun setColorTo(element: PsiElement, color: Color) {
        when (element) {
            is RainColorNode -> {
                val file = PsiFileFactory.getInstance(element.project).createFileFromText(
                    RainbowLanguage.INSTANCE,
                    "meta{color:#${ColorUtil.toHex(color).uppercase()}}"
                ) as RainbowFile
                PsiTreeUtil.findChildOfType(file, RainColorNode::class.java)?.let {
                    element.replace(it)
                }
            }
            else -> {
                // do nothing
            }
        }
    }
}
