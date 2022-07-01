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

public class RainAttributeValueNode extends ASTWrapperPsiElement implements RainAttributeValue {

  public RainAttributeValueNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RainVisitor visitor) {
    visitor.visitAttributeValue(this);
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
  public RainBoolean getBoolean() {
    return findChildByClass(RainBoolean.class);
  }

  @Override
  @Nullable
  public RainNull getNull() {
    return findChildByClass(RainNull.class);
  }

  @Override
  @Nullable
  public RainObject getObject() {
    return findChildByClass(RainObject.class);
  }

  @Override
  @Nullable
  public RainStringInline getStringInline() {
    return findChildByClass(RainStringInline.class);
  }

  @Override
  @Nullable
  public RainStringMulti getStringMulti() {
    return findChildByClass(RainStringMulti.class);
  }

  @Override
  @Nullable
  public RainUrlMaybeValid getUrlMaybeValid() {
    return findChildByClass(RainUrlMaybeValid.class);
  }

  @Override
  @Nullable
  public PsiElement getByte() {
    return findChildByType(BYTE);
  }

  @Override
  @Nullable
  public PsiElement getDecimal() {
    return findChildByType(DECIMAL);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getSign() {
    return findChildByType(SIGN);
  }

}
