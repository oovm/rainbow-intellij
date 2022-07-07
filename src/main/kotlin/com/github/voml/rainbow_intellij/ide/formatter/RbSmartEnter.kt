package com.github.voml.rainbow_intellij.ide.formatter

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.intellij.lang.SmartEnterProcessorWithFixers
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class RbSmartEnter : SmartEnterProcessorWithFixers() {
    init {
        addFixers(
            RbCommaFixer()
        )
        addEnterProcessors(
            PlainEnterProcessor()
        )
    }

    override fun doNotStepInto(element: PsiElement): Boolean {
        return true
    }

    override fun processDefaultEnter(project: Project, editor: Editor, file: PsiFile) {
        plainEnter(editor)
    }

    private class PlainEnterProcessor : FixEnterProcessor() {
        override fun doEnter(atCaret: PsiElement, file: PsiFile, editor: Editor, modified: Boolean): Boolean {
            if (file !is RainbowFile) return false
            plainEnter(editor)
            return true
        }
    }
}

