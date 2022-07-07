package com.github.voml.rainbow_intellij.ide.completion

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.util.ProcessingContext

class RbSymbolCompletion : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        // if left part
        parameters;
        val file = parameters.originalFile as RainbowFile
        val top = parameters.position.parent;
        onValue(file, resultSet)
    }

    private fun onTopLevel(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        resultSet.addKeyword("language")
        resultSet.addKeyword("schema")
    }

    private fun onKey(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {

    }

    private fun onValue(
        file: RainbowFile,
        resultSet: CompletionResultSet
    ) {
        file.getMetaStatements().forEach {
            resultSet.addElement(LookupElementBuilder.createWithIcon(it.value))
        }
        file.getLanguageStatements().forEach {
            resultSet.addElement(LookupElementBuilder.createWithIcon(it.value))
        }
        resultSet.addKeyword("underline")
        resultSet.addKeyword("bold")
        resultSet.addKeyword("italic")
    }

    private fun CompletionResultSet.addKeyword(keyword: String ) {
        val builder = LookupElementBuilder.create(keyword).withIcon(AllIcons.Actions.WordsSelected)
        this.addElement(builder)
    }

}