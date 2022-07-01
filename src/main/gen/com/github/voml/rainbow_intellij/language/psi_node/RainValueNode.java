// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.voml.rainbow_intellij.language.psi.RbToken.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.voml.rainbow_intellij.language.psi.*;
import com.github.voml.rainbow_intellij.language.ast.RainAstExtension;

public class RainValueNode extends ASTWrapperPsiElement implements RainValue {

  public RainValueNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RainVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RainVisitor) accept((RainVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RainArray getArray() {
    return findChildByClass(RainArray.class);
  }

  @Override
  @Nullable
  public RainColorLiteral getColorLiteral() {
    return findChildByClass(RainColorLiteral.class);
  }

  @Override
  @Nullable
  public RainLiteral getLiteral() {
    return findChildByClass(RainLiteral.class);
  }

  @Override
  @Nullable
  public RainNamespace getNamespace() {
    return findChildByClass(RainNamespace.class);
  }

  @Override
  @Nullable
  public RainNumber getNumber() {
    return findChildByClass(RainNumber.class);
  }

  @Override
  @Nullable
  public RainStringLiteral getStringLiteral() {
    return findChildByClass(RainStringLiteral.class);
  }

}
