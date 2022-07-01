// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.voml.rainbow_intellij.language.psi_node.*;

public interface RbToken {

  IElementType ARRAY = new RbElementType("ARRAY");
  IElementType ATTRIBUTE_STATEMENT = new RbElementType("ATTRIBUTE_STATEMENT");
  IElementType BRACE_BLOCK = new RbElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new RbElementType("BRACKET_BLOCK");
  IElementType COLOR_LITERAL = new RbElementType("COLOR_LITERAL");
  IElementType FIELD_STATEMENT = new RbElementType("FIELD_STATEMENT");
  IElementType GLOBAL_STATEMENT = new RbElementType("GLOBAL_STATEMENT");
  IElementType IDENTIFIER = new RbElementType("IDENTIFIER");
  IElementType KEY = new RbElementType("KEY");
  IElementType LANGUAGE_INHERIT = new RbElementType("LANGUAGE_INHERIT");
  IElementType LANGUAGE_STATEMENT = new RbElementType("LANGUAGE_STATEMENT");
  IElementType LITERAL = new RbElementType("LITERAL");
  IElementType META_STATEMENT = new RbElementType("META_STATEMENT");
  IElementType NAMESPACE = new RbElementType("NAMESPACE");
  IElementType NUMBER = new RbElementType("NUMBER");
  IElementType OBJECT = new RbElementType("OBJECT");
  IElementType OBJECT_INHERIT = new RbElementType("OBJECT_INHERIT");
  IElementType SCHEMA_STATEMENT = new RbElementType("SCHEMA_STATEMENT");
  IElementType STRING_LITERAL = new RbElementType("STRING_LITERAL");
  IElementType VALUE = new RbElementType("VALUE");

  IElementType ACCENT = new RbTokenType("^");
  IElementType ANGLE_L = new RbTokenType("<");
  IElementType ANGLE_R = new RbTokenType(">");
  IElementType AT = new RbTokenType("@");
  IElementType BRACE_L = new RbTokenType("{");
  IElementType BRACE_R = new RbTokenType("}");
  IElementType BRACKET_L = new RbTokenType("[");
  IElementType BRACKET_R = new RbTokenType("]");
  IElementType COLON = new RbTokenType(":");
  IElementType COLOR = new RbTokenType("Color");
  IElementType COMMA = new RbTokenType(",");
  IElementType COMMENT = new RbTokenType("Comment");
  IElementType COMMENT_BLOCK = new RbTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new RbTokenType("Comment Document");
  IElementType DECIMAL = new RbTokenType("Decimal");
  IElementType DOLLAR = new RbTokenType("$");
  IElementType DOT = new RbTokenType(".");
  IElementType EQ = new RbTokenType("=");
  IElementType INTEGER = new RbTokenType("Integer");
  IElementType PARENTHESIS_L = new RbTokenType("(");
  IElementType PARENTHESIS_R = new RbTokenType(")");
  IElementType SEMICOLON = new RbTokenType(";");
  IElementType SIGN = new RbTokenType("SIGN");
  IElementType STAR = new RbTokenType("*");
  IElementType STRING = new RbTokenType("String");
  IElementType STRING_RAW = new RbTokenType("STRING_RAW");
  IElementType SYMBOL = new RbTokenType("Symbol");
  IElementType URL = new RbTokenType("Url");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY) {
        return new RainArrayNode(node);
      }
      else if (type == ATTRIBUTE_STATEMENT) {
        return new RainAttributeStatementNode(node);
      }
      else if (type == BRACE_BLOCK) {
        return new RainBraceBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new RainBracketBlockNode(node);
      }
      else if (type == COLOR_LITERAL) {
        return new RainColorLiteralNode(node);
      }
      else if (type == FIELD_STATEMENT) {
        return new RainFieldStatementNode(node);
      }
      else if (type == GLOBAL_STATEMENT) {
        return new RainGlobalStatementNode(node);
      }
      else if (type == IDENTIFIER) {
        return new RainIdentifierNode(node);
      }
      else if (type == KEY) {
        return new RainKeyNode(node);
      }
      else if (type == LANGUAGE_INHERIT) {
        return new RainLanguageInheritNode(node);
      }
      else if (type == LANGUAGE_STATEMENT) {
        return new RainLanguageStatementNode(node);
      }
      else if (type == LITERAL) {
        return new RainLiteralNode(node);
      }
      else if (type == META_STATEMENT) {
        return new RainMetaStatementNode(node);
      }
      else if (type == NAMESPACE) {
        return new RainNamespaceNode(node);
      }
      else if (type == NUMBER) {
        return new RainNumberNode(node);
      }
      else if (type == OBJECT) {
        return new RainObjectNode(node);
      }
      else if (type == OBJECT_INHERIT) {
        return new RainObjectInheritNode(node);
      }
      else if (type == SCHEMA_STATEMENT) {
        return new RainSchemaStatementNode(node);
      }
      else if (type == STRING_LITERAL) {
        return new RainStringLiteralNode(node);
      }
      else if (type == VALUE) {
        return new RainValueNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
