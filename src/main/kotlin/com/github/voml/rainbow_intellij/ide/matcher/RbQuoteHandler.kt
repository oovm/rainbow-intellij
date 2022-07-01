package com.github.voml.rainbow_intellij.ide.matcher


import com.github.voml.rainbow_intellij.language.psi.RbToken
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class RbQuoteHandler : SimpleTokenSetQuoteHandler(RbToken.STRING_INLINE)
