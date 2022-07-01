package com.github.voml.rainbow_intellij.ide.file_view

import com.github.voml.rainbow_intellij.RbBundle
import com.github.voml.rainbow_intellij.RbLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class JssFileType private constructor() : LanguageFileType(RbLanguage.INSTANCE) {
    override fun getName(): String = RbBundle.message("filetype.name")

    override fun getDescription(): String = RbBundle.message("filetype.description")

    override fun getDefaultExtension(): String = "rmb"

    override fun getIcon(): Icon = JssIcons.FILE

    companion object {
        @JvmStatic
        val INSTANCE = JssFileType()
    }
}