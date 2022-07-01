package com.github.voml.rainbow_intellij.language.psi

import com.github.voml.rainbow_intellij.RbLanguage
import com.intellij.psi.tree.IElementType

class RbElementType(debugName: String) : IElementType(debugName, RbLanguage.INSTANCE)
