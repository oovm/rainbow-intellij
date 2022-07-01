package com.github.voml.rainbow_intellij.file

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class RainbowFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, RainbowLanguage.INSTANCE) {
    override fun getFileType(): FileType = RainbowFileType.INSTANCE

    override fun toString(): String = RainbowBundle.message("action.create_file")
}