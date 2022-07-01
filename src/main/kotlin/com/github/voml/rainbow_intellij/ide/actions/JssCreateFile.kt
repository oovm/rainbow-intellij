package com.github.voml.rainbow_intellij.ide.actions

import com.github.voml.rainbow_intellij.file.RainbowBundle
import com.github.voml.rainbow_intellij.file.RainbowIcons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class JssCreateFile :
    CreateFileFromTemplateAction(name, description, RainbowIcons.RmbFile) {
    companion object {
        private val name = RainbowBundle.message("action.create_file")
        private val description = RainbowBundle.message("action.create_file.description")
    }


    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder
            .setTitle(name)
            // See [resources/colors/fileTemplate]
            .addKind("Empty file", RainbowIcons.RmbFile, "rmb File")
    }


    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
