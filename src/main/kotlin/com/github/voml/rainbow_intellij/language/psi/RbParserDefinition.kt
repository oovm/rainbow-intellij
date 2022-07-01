package com.github.voml.rainbow_intellij.language.psi

import com.github.voml.rainbow_intellij.file.RainbowLanguage
import com.github.voml.rainbow_intellij.file.RainbowFile
import com.github.voml.rainbow_intellij.language.parser.RbParser
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


class RbParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer = RbLexerAdapter()

    override fun createParser(project: Project): PsiParser = RbParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode): PsiElement = RbToken.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = RainbowFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    companion object {
        val COMMENTS = TokenSet.create(RbToken.COMMENT, RbToken.COMMENT_BLOCK, RbToken.COMMENT_DOCUMENT)
        val STRING_LITERALS = TokenSet.create(RbToken.STRING)
        val FILE = IFileElementType(RainbowLanguage.INSTANCE)
    }
}
