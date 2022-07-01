package com.github.voml.rainbow_intellij.language.psi

import com.github.voml.rainbow_intellij.file.RainbowLanguage
import com.intellij.psi.tree.IElementType

class RbElementType(debugName: String) : IElementType(debugName, RainbowLanguage.INSTANCE)
