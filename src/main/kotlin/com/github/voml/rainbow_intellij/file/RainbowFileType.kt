package com.github.voml.rainbow_intellij.file

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class RainbowFileType private constructor() : LanguageFileType(RainbowLanguage.INSTANCE) {
    override fun getName(): String = RainbowBundle.message("filetype.name")
    override fun getDescription(): String = RainbowBundle.message("filetype.description")
    override fun getDefaultExtension(): String = "rmb"
    override fun getIcon(): Icon = RainbowIcons.RmbFile

    companion object {
        @JvmStatic
        val INSTANCE = RainbowFileType()
    }
}