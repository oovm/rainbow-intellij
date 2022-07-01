// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.voml.rainbow_intellij.language.psi.RbToken.*;
import static com.github.voml.rainbow_intellij.language.psi.RbParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RbParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Rb(b, l + 1);
  }

  /* ********************************************************** */
  // statement*
  static boolean Rb(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Rb")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Rb", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<bracket_block value ignore>>
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bracket_block(b, l + 1, RbParser::value, RbParser::ignore);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  /* ********************************************************** */
  // key eq (object_inherit|value+)
  public static boolean attribute_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_statement")) return false;
    if (!nextTokenIs(b, "<attribute statement>", STRING_RAW, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_STATEMENT, "<attribute statement>");
    r = key(b, l + 1);
    r = r && eq(b, l + 1);
    r = r && attribute_statement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // object_inherit|value+
  private static boolean attribute_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = object_inherit(b, l + 1);
    if (!r) r = attribute_statement_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // value+
  private static boolean attribute_statement_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_statement_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_statement_2_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "true" | "false"
  public static boolean boolean_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean $>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BRACE_L (<<item>>|<<sp>>)* BRACE_R
  public static boolean brace_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && brace_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, BRACE_BLOCK, r);
    return r;
  }

  // (<<item>>|<<sp>>)*
  private static boolean brace_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!brace_block_1_0(b, l + 1, _item, _sp)) break;
      if (!empty_element_parsed_guard_(b, "brace_block_1", c)) break;
    }
    return true;
  }

  // <<item>>|<<sp>>
  private static boolean brace_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "brace_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    if (!r) r = _sp.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRACKET_L [<<item>> (<<sp>> <<item>>)* [<<sp>>]] BRACKET_R
  public static boolean bracket_block(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block")) return false;
    if (!nextTokenIs(b, BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_L);
    r = r && bracket_block_1(b, l + 1, _item, _sp);
    r = r && consumeToken(b, BRACKET_R);
    exit_section_(b, m, BRACKET_BLOCK, r);
    return r;
  }

  // [<<item>> (<<sp>> <<item>>)* [<<sp>>]]
  private static boolean bracket_block_1(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1")) return false;
    bracket_block_1_0(b, l + 1, _item, _sp);
    return true;
  }

  // <<item>> (<<sp>> <<item>>)* [<<sp>>]
  private static boolean bracket_block_1_0(PsiBuilder b, int l, Parser _item, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _item.parse(b, l);
    r = r && bracket_block_1_0_1(b, l + 1, _sp, _item);
    r = r && bracket_block_1_0_2(b, l + 1, _sp);
    exit_section_(b, m, null, r);
    return r;
  }

  // (<<sp>> <<item>>)*
  private static boolean bracket_block_1_0_1(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bracket_block_1_0_1_0(b, l + 1, _sp, _item)) break;
      if (!empty_element_parsed_guard_(b, "bracket_block_1_0_1", c)) break;
    }
    return true;
  }

  // <<sp>> <<item>>
  private static boolean bracket_block_1_0_1_0(PsiBuilder b, int l, Parser _sp, Parser _item) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _sp.parse(b, l);
    r = r && _item.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  // [<<sp>>]
  private static boolean bracket_block_1_0_2(PsiBuilder b, int l, Parser _sp) {
    if (!recursion_guard_(b, l, "bracket_block_1_0_2")) return false;
    _sp.parse(b, l);
    return true;
  }

  /* ********************************************************** */
  // COLOR_LITERAL
  public static boolean color(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "color")) return false;
    if (!nextTokenIs(b, COLOR_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLOR_LITERAL);
    exit_section_(b, m, COLOR, r);
    return r;
  }

  /* ********************************************************** */
  // null | boolean | number | string | color | url_maybe_valid
  static boolean data(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data")) return false;
    boolean r;
    r = null_$(b, l + 1);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = number(b, l + 1);
    if (!r) r = string(b, l + 1);
    if (!r) r = color(b, l + 1);
    if (!r) r = url_maybe_valid(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // EQ | COLON
  static boolean eq(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eq")) return false;
    if (!nextTokenIs(b, "", COLON, EQ)) return false;
    boolean r;
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, COLON);
    return r;
  }

  /* ********************************************************** */
  // key eq value
  public static boolean field_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_statement")) return false;
    if (!nextTokenIs(b, "<field statement>", STRING_RAW, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_STATEMENT, "<field statement>");
    r = key(b, l + 1);
    r = r && eq(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "global" <<brace_block attribute_statement ignore>>
  public static boolean global_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "global_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_STATEMENT, "<global statement>");
    r = consumeToken(b, "global");
    r = r && brace_block(b, l + 1, RbParser::attribute_statement, RbParser::ignore);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // SEMICOLON | COMMA
  static boolean ignore(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignore")) return false;
    if (!nextTokenIs(b, "", COMMA, SEMICOLON)) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  /* ********************************************************** */
  // string_inline | identifier
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, "<key>", STRING_RAW, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY, "<key>");
    r = string_inline(b, l + 1);
    if (!r) r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean language_inherit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "language_inherit")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, LANGUAGE_INHERIT, r);
    return r;
  }

  /* ********************************************************** */
  // "language" identifier [COLON language_inherit] <<brace_block attribute_statement ignore>>
  public static boolean language_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "language_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LANGUAGE_STATEMENT, "<language statement>");
    r = consumeToken(b, "language");
    r = r && identifier(b, l + 1);
    r = r && language_statement_2(b, l + 1);
    r = r && brace_block(b, l + 1, RbParser::attribute_statement, RbParser::ignore);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [COLON language_inherit]
  private static boolean language_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "language_statement_2")) return false;
    language_statement_2_0(b, l + 1);
    return true;
  }

  // COLON language_inherit
  private static boolean language_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "language_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && language_inherit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "meta" <<brace_block attribute_statement ignore>>
  public static boolean meta_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "meta_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, META_STATEMENT, "<meta statement>");
    r = consumeToken(b, "meta");
    r = r && brace_block(b, l + 1, RbParser::attribute_statement, RbParser::ignore);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier (DOT identifier)*
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && namespace_1(b, l + 1);
    exit_section_(b, m, NAMESPACE, r);
    return r;
  }

  // (DOT identifier)*
  private static boolean namespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace_1", c)) break;
    }
    return true;
  }

  // DOT identifier
  private static boolean namespace_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "null"
  public static boolean null_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "null_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NULL, "<null $>");
    r = consumeToken(b, "null");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [SIGN] (INTEGER | DECIMAL) | [SIGN] BYTE
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = number_0(b, l + 1);
    if (!r) r = number_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [SIGN] (INTEGER | DECIMAL)
  private static boolean number_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_0_0(b, l + 1);
    r = r && number_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SIGN]
  private static boolean number_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0_0")) return false;
    consumeToken(b, SIGN);
    return true;
  }

  // INTEGER | DECIMAL
  private static boolean number_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_0_1")) return false;
    boolean r;
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    return r;
  }

  // [SIGN] BYTE
  private static boolean number_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_1_0(b, l + 1);
    r = r && consumeToken(b, BYTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [SIGN]
  private static boolean number_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_1_0")) return false;
    consumeToken(b, SIGN);
    return true;
  }

  /* ********************************************************** */
  // <<brace_block field_statement ignore>>
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = brace_block(b, l + 1, RbParser::field_statement, RbParser::ignore);
    exit_section_(b, m, OBJECT, r);
    return r;
  }

  /* ********************************************************** */
  // namespace? object
  public static boolean object_inherit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_inherit")) return false;
    if (!nextTokenIs(b, "<object inherit>", BRACE_L, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_INHERIT, "<object inherit>");
    r = object_inherit_0(b, l + 1);
    r = r && object(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // namespace?
  private static boolean object_inherit_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_inherit_0")) return false;
    namespace(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PARENTHESIS_L <<param>> PARENTHESIS_R
  static boolean parenthesis(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "parenthesis")) return false;
    if (!nextTokenIs(b, PARENTHESIS_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESIS_L);
    r = r && _param.parse(b, l);
    r = r && consumeToken(b, PARENTHESIS_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "schema" identifier <<brace_block attribute_statement ignore>>
  public static boolean schema_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEMA_STATEMENT, "<schema statement>");
    r = consumeToken(b, "schema");
    r = r && identifier(b, l + 1);
    r = r && brace_block(b, l + 1, RbParser::attribute_statement, RbParser::ignore);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // schema_statement
  //   | meta_statement
  //   | global_statement
  //   | language_statement
  //   | COMMENT_DOCUMENT
  //   | ignore
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = schema_statement(b, l + 1);
    if (!r) r = meta_statement(b, l + 1);
    if (!r) r = global_statement(b, l + 1);
    if (!r) r = language_statement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT_DOCUMENT);
    if (!r) r = ignore(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // string_inline|string_multi
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, STRING_RAW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_inline(b, l + 1);
    if (!r) r = string_multi(b, l + 1);
    exit_section_(b, m, STRING, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_RAW
  public static boolean string_inline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_inline")) return false;
    if (!nextTokenIs(b, STRING_RAW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_RAW);
    exit_section_(b, m, STRING_INLINE, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_RAW
  public static boolean string_multi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_multi")) return false;
    if (!nextTokenIs(b, STRING_RAW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_RAW);
    exit_section_(b, m, STRING_MULTI, r);
    return r;
  }

  /* ********************************************************** */
  // URL
  public static boolean url_maybe_valid(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_maybe_valid")) return false;
    if (!nextTokenIs(b, URL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, URL);
    exit_section_(b, m, URL_MAYBE_VALID, r);
    return r;
  }

  /* ********************************************************** */
  // array | data | namespace
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = array(b, l + 1);
    if (!r) r = data(b, l + 1);
    if (!r) r = namespace(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
