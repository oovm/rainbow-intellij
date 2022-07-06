package com.github.voml.rainbow_intellij.ide.todo

import com.github.voml.rainbow_intellij.language.psi.RbLexerAdapter
import com.github.voml.rainbow_intellij.language.psi.RB_COMMENT
import com.intellij.lexer.Lexer
import com.intellij.psi.impl.cache.impl.BaseFilterLexer
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer
import com.intellij.psi.impl.cache.impl.todo.LexerBasedTodoIndexer
import com.intellij.psi.search.UsageSearchContext

class VomlTodoIndexer : LexerBasedTodoIndexer() {
    override fun createLexer(consumer: OccurrenceConsumer): Lexer {
        return object : BaseFilterLexer(RbLexerAdapter(), consumer) {
            override fun advance() {
                if (myDelegate.tokenType in RB_COMMENT) {
                    scanWordsInToken(UsageSearchContext.IN_COMMENTS.toInt(), false, false)
                    advanceTodoItemCountsInToken()
                }
                myDelegate.advance()
            }
        }
    }
}
