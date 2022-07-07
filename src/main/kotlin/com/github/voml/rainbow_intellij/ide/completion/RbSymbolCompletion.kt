package com.github.voml.rainbow_intellij.ide.completion

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.language.ast.RainAstExtension
import com.github.voml.rainbow_intellij.language.psi_node.RainBraceBlockNode
import com.github.voml.rainbow_intellij.language.psi_node.RainLanguageStatementNode
import com.github.voml.rainbow_intellij.language.psi_node.RainValueNode
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.psi.util.parentOfType
import com.intellij.util.ProcessingContext

class RbSymbolCompletion : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet,
    ) {
        val here = parameters.position;
        when {
            here.parent is RainbowFile -> {
                onTopLevel(resultSet)
            }
            here.parentOfType<RainBraceBlockNode>() != null -> {
                onValue(parameters, resultSet)
            }
            here.parentOfType<RainValueNode>() != null -> {
                onValue(parameters, resultSet)
            }
            else -> {

            }
        }
    }

    private fun onTopLevel(resultSet: CompletionResultSet) {
        resultSet.addKeyword("language")
        resultSet.addKeyword("schema")
    }

    private fun onValue(parameters: CompletionParameters, resultSet: CompletionResultSet) {
        val file = parameters.originalFile as RainbowFile
        file.getMetaStatements().forEach {
            resultSet.addElement(LookupElementBuilder.createWithIcon(it.value))
        }
        file.getLanguageStatements().forEach {
            resultSet.addElement(LookupElementBuilder.createWithIcon(it.value))
        }
        RainAstExtension.getFields(parameters.position.parentOfType<RainLanguageStatementNode>()).forEach {
            resultSet.addElement(LookupElementBuilder.createWithIcon(it))
        }
        resultSet.addKeyword("underline")
        resultSet.addKeyword("bold")
        resultSet.addKeyword("italic")
    }

    private fun CompletionResultSet.addKeyword(keyword: String) {
        val builder = LookupElementBuilder.create(keyword).withIcon(AllIcons.Actions.WordsSelected)
        this.addElement(builder)
    }
}