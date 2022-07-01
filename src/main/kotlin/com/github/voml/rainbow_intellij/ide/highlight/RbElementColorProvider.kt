package com.github.voml.rainbow_intellij.ide.highlight

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.file.RainbowLanguage
import com.github.voml.rainbow_intellij.language.psi.RainColorLiteral
import com.github.voml.rainbow_intellij.language.psi.RbToken
import com.github.voml.rainbow_intellij.language.psi.RbTokenType
import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.ui.ColorUtil
import java.awt.Color

class RbElementColorProvider : ElementColorProvider {
    override fun getColorFrom(element: PsiElement): Color? {
        return if (element.elementType == RbToken.COLOR) {
            ColorUtil.fromHex(element.text)
        }
        else {
            null
        }
    }


    override fun setColorTo(element: PsiElement, color: Color) {
        when (element) {
            is RainColorLiteral -> {
                val file = PsiFileFactory.getInstance(element.project).createFileFromText(
                    RainbowLanguage.INSTANCE,
                    "meta{color:#${ColorUtil.toHex(color).uppercase()}}"
                ) as RainbowFile
                PsiTreeUtil.findChildOfType(file, RainColorLiteral::class.java)?.let {
                    element.replace(it)
                }
            }
            else -> {
                // do nothing
            }
        }
    }
}
