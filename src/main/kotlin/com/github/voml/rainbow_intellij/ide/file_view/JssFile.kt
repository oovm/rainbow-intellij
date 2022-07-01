package com.github.voml.rainbow_intellij.ide.file_view

import com.github.voml.rainbow_intellij.RbBundle
import com.github.voml.rainbow_intellij.RbLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class JssFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, RbLanguage.INSTANCE) {
    override fun getFileType(): FileType = JssFileType.INSTANCE

    override fun toString(): String = RbBundle.message("action.create_file")
}