// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RainValue extends PsiElement {

  @Nullable
  RainColorLiteral getColorLiteral();

  @Nullable
  RainLiteral getLiteral();

  @Nullable
  RainNamespace getNamespace();

  @Nullable
  RainNumber getNumber();

  @Nullable
  RainStringLiteral getStringLiteral();

}
