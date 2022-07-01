package com.github.voml.rainbow_intellij.language.psi

import com.github.voml.rainbow_intellij.RbLanguage
import com.intellij.psi.tree.IElementType

class RbTokenType(debugName: String) : IElementType(debugName, RbLanguage.INSTANCE) {
    override fun toString(): String = "RbTokenType.${super.toString()}"
}

