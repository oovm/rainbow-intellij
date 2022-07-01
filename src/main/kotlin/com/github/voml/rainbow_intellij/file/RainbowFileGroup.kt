package com.github.voml.rainbow_intellij.file

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import org.jetbrains.annotations.NotNull

class RainbowFileGroup : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(@NotNull consumer: ProjectViewNestingRulesProvider.Consumer) {
//        consumer.addNestingRule(".jss", ".json")
//        consumer.addNestingRule(".jss", ".json5")
//        consumer.addNestingRule(".jss", ".yaml")
//        consumer.addNestingRule(".jss", ".toml")
    }

}