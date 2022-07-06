package com.github.oovm.rainbowintellij.services

import com.intellij.openapi.project.Project
import com.github.oovm.rainbowintellij.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
