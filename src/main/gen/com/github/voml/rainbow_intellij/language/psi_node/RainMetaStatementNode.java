// This is a generated file. Not intended for manual editing.
package com.github.voml.rainbow_intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.voml.rainbow_intellij.language.psi.RbToken.*;
import com.github.voml.rainbow_intellij.language.mixin.MixinMeta;
import com.github.voml.rainbow_intellij.language.psi.*;
import com.github.voml.rainbow_intellij.language.ast.RainAstExtension;

public class RainMetaStatementNode extends MixinMeta implements RainMetaStatement {

  public RainMetaStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RainVisitor visitor) {
    visitor.visitMetaStatement(this);
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
  @NotNull
  public RainIdentifier getIdentifier() {
    return findNotNullChildByClass(RainIdentifier.class);
  }

  @Override
  @NotNull
  public List<? extends RainFieldStatementNode> getFields() {
    return RainAstExtension.getFields(this);
  }

}
