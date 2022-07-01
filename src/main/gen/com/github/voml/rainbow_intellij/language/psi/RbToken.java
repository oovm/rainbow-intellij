// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.voml.rainbow_intellij.language.psi_node.*;

public interface RbToken {

  IElementType ANNO_STATEMENT = new RbElementType("ANNO_STATEMENT");
  IElementType ARRAY = new RbElementType("ARRAY");
  IElementType BOOLEAN = new RbElementType("BOOLEAN");
  IElementType BRACE_BLOCK = new RbElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new RbElementType("BRACKET_BLOCK");
  IElementType FIELD_STATEMENT = new RbElementType("FIELD_STATEMENT");
  IElementType GLOBAL_STATEMENT = new RbElementType("GLOBAL_STATEMENT");
  IElementType IDENTIFIER = new RbElementType("IDENTIFIER");
  IElementType IDIOM_MARK = new RbElementType("IDIOM_MARK");
  IElementType IDIOM_STATEMENT = new RbElementType("IDIOM_STATEMENT");
  IElementType IDIOM_SYMBOL = new RbElementType("IDIOM_SYMBOL");
  IElementType KEY = new RbElementType("KEY");
  IElementType KV_PAIR = new RbElementType("KV_PAIR");
  IElementType META_STATEMENT = new RbElementType("META_STATEMENT");
  IElementType NULL = new RbElementType("NULL");
  IElementType OBJECT = new RbElementType("OBJECT");
  IElementType SCHEMA_STATEMENT = new RbElementType("SCHEMA_STATEMENT");
  IElementType STRING_INLINE = new RbElementType("STRING_INLINE");
  IElementType STRING_MULTI = new RbElementType("STRING_MULTI");
  IElementType TYPE_HINT = new RbElementType("TYPE_HINT");
  IElementType URL_MAYBE_VALID = new RbElementType("URL_MAYBE_VALID");
  IElementType VALUE = new RbElementType("VALUE");

  IElementType ACCENT = new RbTokenType("^");
  IElementType ANGLE_L = new RbTokenType("<");
  IElementType ANGLE_R = new RbTokenType(">");
  IElementType AT = new RbTokenType("@");
  IElementType BRACE_L = new RbTokenType("{");
  IElementType BRACE_R = new RbTokenType("}");
  IElementType BRACKET_L = new RbTokenType("[");
  IElementType BRACKET_R = new RbTokenType("]");
  IElementType BYTE = new RbTokenType("BYTE");
  IElementType COLON = new RbTokenType(":");
  IElementType COMMA = new RbTokenType(",");
  IElementType COMMENT = new RbTokenType("COMMENT");
  IElementType COMMENT_BLOCK = new RbTokenType("COMMENT_BLOCK");
  IElementType COMMENT_DOCUMENT = new RbTokenType("COMMENT_DOCUMENT");
  IElementType DECIMAL = new RbTokenType("DECIMAL");
  IElementType DOLLAR = new RbTokenType("$");
  IElementType DOT = new RbTokenType(".");
  IElementType EQ = new RbTokenType("=");
  IElementType INTEGER = new RbTokenType("INTEGER");
  IElementType PARENTHESIS_L = new RbTokenType("(");
  IElementType PARENTHESIS_R = new RbTokenType(")");
  IElementType SEMICOLON = new RbTokenType(";");
  IElementType SIGN = new RbTokenType("SIGN");
  IElementType STAR = new RbTokenType("*");
  IElementType STRING = new RbTokenType("STRING");
  IElementType SYMBOL = new RbTokenType("SYMBOL");
  IElementType URL = new RbTokenType("URL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNO_STATEMENT) {
        return new RainAnnoStatementNode(node);
      }
      else if (type == ARRAY) {
        return new RainArrayNode(node);
      }
      else if (type == BOOLEAN) {
        return new RainBooleanNode(node);
      }
      else if (type == BRACE_BLOCK) {
        return new RainBraceBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new RainBracketBlockNode(node);
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
      else if (type == IDIOM_MARK) {
        return new RainIdiomMarkNode(node);
      }
      else if (type == IDIOM_STATEMENT) {
        return new RainIdiomStatementNode(node);
      }
      else if (type == IDIOM_SYMBOL) {
        return new RainIdiomSymbolNode(node);
      }
      else if (type == KEY) {
        return new RainKeyNode(node);
      }
      else if (type == KV_PAIR) {
        return new RainKvPairNode(node);
      }
      else if (type == META_STATEMENT) {
        return new RainMetaStatementNode(node);
      }
      else if (type == NULL) {
        return new RainNullNode(node);
      }
      else if (type == OBJECT) {
        return new RainObjectNode(node);
      }
      else if (type == SCHEMA_STATEMENT) {
        return new RainSchemaStatementNode(node);
      }
      else if (type == STRING_INLINE) {
        return new RainStringInlineNode(node);
      }
      else if (type == STRING_MULTI) {
        return new RainStringMultiNode(node);
      }
      else if (type == TYPE_HINT) {
        return new RainTypeHintNode(node);
      }
      else if (type == URL_MAYBE_VALID) {
        return new RainUrlMaybeValidNode(node);
      }
      else if (type == VALUE) {
        return new RainValueNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
