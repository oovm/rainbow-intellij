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

public class RainSchemaStatementNode extends ASTWrapperPsiElement implements RainSchemaStatement {

  public RainSchemaStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RainVisitor visitor) {
    visitor.visitSchemaStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RainVisitor) accept((RainVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RainBraceBlock getBraceBlock() {
    return findNotNullChildByClass(RainBraceBlock.class);
  }

  @Override
  @Nullable
  public RainTypeHint getTypeHint() {
    return findChildByClass(RainTypeHint.class);
  }

  @Override
  @NotNull
  public PsiElement getSymbol() {
    return findNotNullChildByType(SYMBOL);
  }

}
