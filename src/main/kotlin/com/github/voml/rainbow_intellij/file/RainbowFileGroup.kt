package com.github.voml.rainbow_intellij.file

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import org.jetbrains.annotations.NotNull

class RainbowFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(@NotNull consumer: ProjectViewNestingRulesProvider.Consumer) {
        consumer.addNestingRule(".rml", ".html")
        consumer.addNestingRule(".rml", ".tex")
//        consumer.addNestingRule(".jss", ".yaml")
//        consumer.addNestingRule(".jss", ".toml")
    }
}
