// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.voml.rainbow_intellij.language.psi_node.RainFieldStatementNode;

public interface RainMetaStatement extends PsiElement {

  @NotNull
  RainBraceBlock getBraceBlock();

  @NotNull
  RainIdentifier getIdentifier();

  @NotNull
  List<? extends RainFieldStatementNode> getFields();

}
