// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.voml.rainbow_intellij.language.psi.RbToken.*;
import com.github.voml.rainbow_intellij.language.mixin.MixinField;
import com.github.voml.rainbow_intellij.language.psi.*;
import com.github.voml.rainbow_intellij.language.ast.RainAstExtension;

public class RainFieldStatementNode extends MixinField implements RainFieldStatement {

  public RainFieldStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RainVisitor visitor) {
    visitor.visitFieldStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RainVisitor) accept((RainVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RainKey getKey() {
    return findNotNullChildByClass(RainKey.class);
  }

  @Override
  @NotNull
  public RainValue getValue() {
    return findNotNullChildByClass(RainValue.class);
  }

}