package com.github.voml.rainbow_intellij.ide.completion

import com.github.voml.rainbow_intellij.file.RainbowFile
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.util.ProcessingContext

class RbSymbolCompletion : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        resultSet: CompletionResultSet
    ) {
        // if left part
        val file = parameters.originalFile as RainbowFile
        file.getMetaStatements().forEach {
            resultSet.addElement(LookupElementBuilder.createWithIcon(it.value))
        }
        file.getLanguageStatements().forEach {
            resultSet.addElement(LookupElementBuilder.createWithIcon(it.value))
        }
    }
}