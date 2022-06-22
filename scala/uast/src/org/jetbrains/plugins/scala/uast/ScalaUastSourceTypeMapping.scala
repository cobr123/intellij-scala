package org.jetbrains.plugins.scala.uast

import com.intellij.psi._
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.plugins.scala.lang.psi.impl._
import org.jetbrains.plugins.scala.lang.psi.impl.base._
import org.jetbrains.plugins.scala.lang.psi.impl.base.literals._
import org.jetbrains.plugins.scala.lang.psi.impl.base.patterns._
import org.jetbrains.plugins.scala.lang.psi.impl.base.types._
import org.jetbrains.plugins.scala.lang.psi.impl.expr._
import org.jetbrains.plugins.scala.lang.psi.impl.statements.params._
import org.jetbrains.plugins.scala.lang.psi.impl.statements._
import org.jetbrains.plugins.scala.lang.psi.impl.toplevel.imports._
import org.jetbrains.plugins.scala.lang.psi.impl.toplevel.templates._
import org.jetbrains.plugins.scala.lang.psi.impl.toplevel.typedef._
import org.jetbrains.plugins.scala.lang.scaladoc.psi.impl._
import org.jetbrains.uast._
import org.jetbrains.uast.expressions.UInjectionHost
import org.jetbrains.uast.util.{ClassSet, ClassSetKt}

/**
 * !!! ATTENTION !!!<br>
 * This file is generated by org.jetbrains.plugins.scala.uast.GeneratePossibleSourceTypesMapping
 */
object ScalaUastSourceTypeMapping {
  def canConvert(element: PsiElement, targets: Array[Class[_ <: UElement]]): Boolean = {
    val clazz = element.getClass
    targets.exists(target => possibleSourceTypes(target).contains(clazz))
  }

  def possibleSourceTypes(uastType: Class[_ <: UElement]): ClassSet[PsiElement] =
    mapping.getOrElse(uastType, ClassSetKt.emptyClassSet())

  private val mapping: Map[Class[_ <: UElement], ClassSet[PsiElement]] = Map(
    classOf[UAnchorOwner] -> ClassSetKt.classSetOf(
      classOf[ScAnnotationImpl],
      classOf[ScClassImpl],
      classOf[ScClassParameterImpl],
      classOf[ScEnumCaseImpl],
      classOf[ScEnumImpl],
      classOf[ScFunctionDeclarationImpl],
      classOf[ScFunctionDefinitionImpl[_]],
      classOf[ScGivenAliasImpl],
      classOf[ScGivenDefinitionImpl],
      classOf[ScMacroDefinitionImpl],
      classOf[ScObjectImpl],
      classOf[ScParameterImpl],
      classOf[ScPrimaryConstructorImpl],
      classOf[ScReferencePatternImpl],
      classOf[ScTraitImpl],
    ),
    classOf[UAnnotated] -> ClassSetKt.classSetOf(
      classOf[ScAnnotTypeElementImpl],
      classOf[ScAssignmentImpl],
      classOf[ScBlockExprImpl],
      classOf[ScBlockImpl],
      classOf[ScBooleanLiteralImpl],
      classOf[ScCaseClauseImpl],
      classOf[ScCaseClausesImpl],
      classOf[ScCharLiteralImpl],
      classOf[ScClassImpl],
      classOf[ScClassParameterImpl],
      classOf[ScConstrBlockExprImpl],
      classOf[ScConstructorInvocationImpl],
      classOf[ScDoImpl],
      classOf[ScDocResolvableCodeReferenceImpl],
      classOf[ScDocTagValueImpl],
      classOf[ScDocThrowTagValueImpl],
      classOf[ScDoubleLiteralImpl],
      classOf[ScEnumCaseImpl],
      classOf[ScEnumImpl],
      classOf[ScExtendsBlockImpl],
      classOf[ScFloatLiteralImpl],
      classOf[ScForImpl],
      classOf[ScFunctionDeclarationImpl],
      classOf[ScFunctionDefinitionImpl[_]],
      classOf[ScFunctionExprImpl],
      classOf[ScGenericCallImpl],
      classOf[ScGivenAliasImpl],
      classOf[ScGivenDefinitionImpl],
      classOf[ScIfImpl],
      classOf[ScInfixExprImpl],
      classOf[ScIntegerLiteralImpl],
      classOf[ScInterpolatedExpressionPrefix],
      classOf[ScInterpolatedPatternPrefix],
      classOf[ScInterpolatedStringLiteralImpl],
      classOf[ScLongLiteralImpl],
      classOf[ScMacroDefinitionImpl],
      classOf[ScMatchImpl],
      classOf[ScMethodCallImpl],
      classOf[ScNewTemplateDefinitionImpl],
      classOf[ScNullLiteralImpl],
      classOf[ScObjectImpl],
      classOf[ScParameterImpl],
      classOf[ScParameterizedTypeElementImpl],
      classOf[ScParenthesisedExprImpl],
      classOf[ScPatternDefinitionImpl],
      classOf[ScPostfixExprImpl],
      classOf[ScPrefixExprImpl],
      classOf[ScPrimaryConstructorImpl],
      classOf[ScQuotedBlockImpl],
      classOf[ScReferenceExpressionImpl],
      classOf[ScReferencePatternImpl],
      classOf[ScReturnImpl],
      classOf[ScSimpleTypeElementImpl],
      classOf[ScSplicedBlockImpl],
      classOf[ScStableCodeReferenceImpl],
      classOf[ScStringLiteralImpl],
      classOf[ScSuperReferenceImpl],
      classOf[ScSymbolLiteralImpl],
      classOf[ScThisReferenceImpl],
      classOf[ScThrowImpl],
      classOf[ScTraitImpl],
      classOf[ScTryImpl],
      classOf[ScTupleImpl],
      classOf[ScTypeProjectionImpl],
      classOf[ScTypedExpressionImpl],
      classOf[ScUnderscoreSectionImpl],
      classOf[ScValueDeclarationImpl],
      classOf[ScVariableDeclarationImpl],
      classOf[ScVariableDefinitionImpl],
      classOf[ScWhileImpl],
      classOf[ScalaFileImpl],
    ),
    classOf[UAnnotation] -> ClassSetKt.classSetOf(
      classOf[ScAnnotationImpl],
    ),
    classOf[UAnnotationEx] -> ClassSetKt.classSetOf(
      classOf[ScAnnotationImpl],
    ),
    classOf[UAnonymousClass] -> ClassSetKt.classSetOf(
      classOf[ScExtendsBlockImpl],
    ),
    classOf[UBinaryExpression] -> ClassSetKt.classSetOf(
      classOf[ScAssignmentImpl],
      classOf[ScInfixExprImpl],
    ),
    classOf[UBinaryExpressionWithType] -> ClassSetKt.classSetOf(
      classOf[ScTypedExpressionImpl],
    ),
    classOf[UBlockExpression] -> ClassSetKt.classSetOf(
      classOf[ScBlockExprImpl],
      classOf[ScBlockImpl],
      classOf[ScConstrBlockExprImpl],
      classOf[ScQuotedBlockImpl],
      classOf[ScSplicedBlockImpl],
    ),
    classOf[UCallExpression] -> ClassSetKt.classSetOf(
      classOf[ScConstructorInvocationImpl],
      classOf[ScGenericCallImpl],
      classOf[ScInterpolatedExpressionPrefix],
      classOf[ScMethodCallImpl],
      classOf[ScNewTemplateDefinitionImpl],
      classOf[ScReferenceExpressionImpl],
    ),
    classOf[UCallableReferenceExpression] -> ClassSetKt.classSetOf(
      classOf[ScReferenceExpressionImpl],
      classOf[ScUnderscoreSectionImpl],
    ),
    classOf[UCatchClause] -> ClassSetKt.classSetOf(
      classOf[ScCaseClauseImpl],
    ),
    classOf[UClass] -> ClassSetKt.classSetOf(
      classOf[ScClassImpl],
      classOf[ScEnumCaseImpl],
      classOf[ScEnumImpl],
      classOf[ScExtendsBlockImpl],
      classOf[ScGivenDefinitionImpl],
      classOf[ScObjectImpl],
      classOf[ScTraitImpl],
    ),
    classOf[UDeclaration] -> ClassSetKt.classSetOf(
      classOf[ScClassImpl],
      classOf[ScClassParameterImpl],
      classOf[ScEnumCaseImpl],
      classOf[ScEnumImpl],
      classOf[ScExtendsBlockImpl],
      classOf[ScFunctionDeclarationImpl],
      classOf[ScFunctionDefinitionImpl[_]],
      classOf[ScGivenAliasImpl],
      classOf[ScGivenDefinitionImpl],
      classOf[ScMacroDefinitionImpl],
      classOf[ScObjectImpl],
      classOf[ScParameterImpl],
      classOf[ScPrimaryConstructorImpl],
      classOf[ScReferencePatternImpl],
      classOf[ScTraitImpl],
    ),
    classOf[UDeclarationsExpression] -> ClassSetKt.classSetOf(
      classOf[ScFunctionDefinitionImpl[_]],
      classOf[ScGivenAliasImpl],
      classOf[ScPatternDefinitionImpl],
      classOf[ScValueDeclarationImpl],
      classOf[ScVariableDeclarationImpl],
      classOf[ScVariableDefinitionImpl],
    ),
    classOf[UDoWhileExpression] -> ClassSetKt.classSetOf(
      classOf[ScDoImpl],
    ),
    classOf[UElement] -> ClassSetKt.classSetOf(
      classOf[LeafPsiElement],
      classOf[ScAnnotTypeElementImpl],
      classOf[ScAnnotationImpl],
      classOf[ScAssignmentImpl],
      classOf[ScBlockExprImpl],
      classOf[ScBlockImpl],
      classOf[ScBooleanLiteralImpl],
      classOf[ScCaseClauseImpl],
      classOf[ScCaseClausesImpl],
      classOf[ScCharLiteralImpl],
      classOf[ScClassImpl],
      classOf[ScClassParameterImpl],
      classOf[ScConstrBlockExprImpl],
      classOf[ScConstructorInvocationImpl],
      classOf[ScDoImpl],
      classOf[ScDocResolvableCodeReferenceImpl],
      classOf[ScDocTagValueImpl],
      classOf[ScDocThrowTagValueImpl],
      classOf[ScDoubleLiteralImpl],
      classOf[ScEnumCaseImpl],
      classOf[ScEnumImpl],
      classOf[ScExtendsBlockImpl],
      classOf[ScFloatLiteralImpl],
      classOf[ScForImpl],
      classOf[ScFunctionDeclarationImpl],
      classOf[ScFunctionDefinitionImpl[_]],
      classOf[ScFunctionExprImpl],
      classOf[ScGenericCallImpl],
      classOf[ScGivenAliasImpl],
      classOf[ScGivenDefinitionImpl],
      classOf[ScIfImpl],
      classOf[ScImportStmtImpl],
      classOf[ScInfixExprImpl],
      classOf[ScIntegerLiteralImpl],
      classOf[ScInterpolatedExpressionPrefix],
      classOf[ScInterpolatedPatternPrefix],
      classOf[ScInterpolatedStringLiteralImpl],
      classOf[ScLongLiteralImpl],
      classOf[ScMacroDefinitionImpl],
      classOf[ScMatchImpl],
      classOf[ScMethodCallImpl],
      classOf[ScNewTemplateDefinitionImpl],
      classOf[ScNullLiteralImpl],
      classOf[ScObjectImpl],
      classOf[ScParameterImpl],
      classOf[ScParameterizedTypeElementImpl],
      classOf[ScParenthesisedExprImpl],
      classOf[ScPatternDefinitionImpl],
      classOf[ScPostfixExprImpl],
      classOf[ScPrefixExprImpl],
      classOf[ScPrimaryConstructorImpl],
      classOf[ScQuotedBlockImpl],
      classOf[ScReferenceExpressionImpl],
      classOf[ScReferencePatternImpl],
      classOf[ScReturnImpl],
      classOf[ScSimpleTypeElementImpl],
      classOf[ScSplicedBlockImpl],
      classOf[ScStableCodeReferenceImpl],
      classOf[ScStringLiteralImpl],
      classOf[ScSuperReferenceImpl],
      classOf[ScSymbolLiteralImpl],
      classOf[ScThisReferenceImpl],
      classOf[ScThrowImpl],
      classOf[ScTraitImpl],
      classOf[ScTryImpl],
      classOf[ScTupleImpl],
      classOf[ScTypeProjectionImpl],
      classOf[ScTypedExpressionImpl],
      classOf[ScUnderscoreSectionImpl],
      classOf[ScValueDeclarationImpl],
      classOf[ScVariableDeclarationImpl],
      classOf[ScVariableDefinitionImpl],
      classOf[ScWhileImpl],
      classOf[ScalaFileImpl],
    ),
    classOf[UExpression] -> ClassSetKt.classSetOf(
      classOf[ScAnnotTypeElementImpl],
      classOf[ScAssignmentImpl],
      classOf[ScBlockExprImpl],
      classOf[ScBlockImpl],
      classOf[ScBooleanLiteralImpl],
      classOf[ScCaseClauseImpl],
      classOf[ScCaseClausesImpl],
      classOf[ScCharLiteralImpl],
      classOf[ScConstrBlockExprImpl],
      classOf[ScConstructorInvocationImpl],
      classOf[ScDoImpl],
      classOf[ScDocResolvableCodeReferenceImpl],
      classOf[ScDocTagValueImpl],
      classOf[ScDocThrowTagValueImpl],
      classOf[ScDoubleLiteralImpl],
      classOf[ScFloatLiteralImpl],
      classOf[ScForImpl],
      classOf[ScFunctionDefinitionImpl[_]],
      classOf[ScFunctionExprImpl],
      classOf[ScGenericCallImpl],
      classOf[ScGivenAliasImpl],
      classOf[ScIfImpl],
      classOf[ScInfixExprImpl],
      classOf[ScIntegerLiteralImpl],
      classOf[ScInterpolatedExpressionPrefix],
      classOf[ScInterpolatedPatternPrefix],
      classOf[ScInterpolatedStringLiteralImpl],
      classOf[ScLongLiteralImpl],
      classOf[ScMatchImpl],
      classOf[ScMethodCallImpl],
      classOf[ScNewTemplateDefinitionImpl],
      classOf[ScNullLiteralImpl],
      classOf[ScParameterizedTypeElementImpl],
      classOf[ScParenthesisedExprImpl],
      classOf[ScPatternDefinitionImpl],
      classOf[ScPostfixExprImpl],
      classOf[ScPrefixExprImpl],
      classOf[ScQuotedBlockImpl],
      classOf[ScReferenceExpressionImpl],
      classOf[ScReturnImpl],
      classOf[ScSimpleTypeElementImpl],
      classOf[ScSplicedBlockImpl],
      classOf[ScStableCodeReferenceImpl],
      classOf[ScStringLiteralImpl],
      classOf[ScSuperReferenceImpl],
      classOf[ScSymbolLiteralImpl],
      classOf[ScThisReferenceImpl],
      classOf[ScThrowImpl],
      classOf[ScTryImpl],
      classOf[ScTupleImpl],
      classOf[ScTypeProjectionImpl],
      classOf[ScTypedExpressionImpl],
      classOf[ScUnderscoreSectionImpl],
      classOf[ScValueDeclarationImpl],
      classOf[ScVariableDeclarationImpl],
      classOf[ScVariableDefinitionImpl],
      classOf[ScWhileImpl],
    ),
    classOf[UExpressionList] -> ClassSetKt.classSetOf(
      classOf[ScBlockImpl],
      classOf[ScCaseClausesImpl],
    ),
    classOf[UField] -> ClassSetKt.classSetOf(
      classOf[ScClassParameterImpl],
      classOf[ScReferencePatternImpl],
    ),
    classOf[UFile] -> ClassSetKt.classSetOf(
      classOf[ScalaFileImpl],
    ),
    classOf[UIdentifier] -> ClassSetKt.classSetOf(
      classOf[LeafPsiElement],
    ),
    classOf[UIfExpression] -> ClassSetKt.classSetOf(
      classOf[ScIfImpl],
    ),
    classOf[UImportStatement] -> ClassSetKt.classSetOf(
      classOf[ScImportStmtImpl],
    ),
    classOf[UInjectionHost] -> ClassSetKt.classSetOf(
      classOf[ScInterpolatedStringLiteralImpl],
      classOf[ScStringLiteralImpl],
    ),
    classOf[UInstanceExpression] -> ClassSetKt.classSetOf(
      classOf[ScSuperReferenceImpl],
      classOf[ScThisReferenceImpl],
    ),
    classOf[UJumpExpression] -> ClassSetKt.classSetOf(
      classOf[ScReturnImpl],
    ),
    classOf[ULabeled] -> ClassSetKt.classSetOf(
      classOf[ScSuperReferenceImpl],
      classOf[ScThisReferenceImpl],
    ),
    classOf[ULambdaExpression] -> ClassSetKt.classSetOf(
      classOf[ScAssignmentImpl],
      classOf[ScBlockExprImpl],
      classOf[ScFunctionExprImpl],
      classOf[ScGenericCallImpl],
      classOf[ScInfixExprImpl],
      classOf[ScMatchImpl],
      classOf[ScMethodCallImpl],
      classOf[ScNewTemplateDefinitionImpl],
      classOf[ScPrefixExprImpl],
      classOf[ScReferenceExpressionImpl],
      classOf[ScThrowImpl],
      classOf[ScTupleImpl],
      classOf[ScTypedExpressionImpl],
      classOf[ScUnderscoreSectionImpl],
    ),
    classOf[ULiteralExpression] -> ClassSetKt.classSetOf(
      classOf[ScBooleanLiteralImpl],
      classOf[ScCharLiteralImpl],
      classOf[ScDoubleLiteralImpl],
      classOf[ScFloatLiteralImpl],
      classOf[ScIntegerLiteralImpl],
      classOf[ScInterpolatedStringLiteralImpl],
      classOf[ScLongLiteralImpl],
      classOf[ScNullLiteralImpl],
      classOf[ScStringLiteralImpl],
      classOf[ScSymbolLiteralImpl],
    ),
    classOf[ULocalVariable] -> ClassSetKt.classSetOf(
      classOf[ScReferencePatternImpl],
    ),
    classOf[ULoopExpression] -> ClassSetKt.classSetOf(
      classOf[ScDoImpl],
      classOf[ScWhileImpl],
    ),
    classOf[UMethod] -> ClassSetKt.classSetOf(
      classOf[ScFunctionDeclarationImpl],
      classOf[ScFunctionDefinitionImpl[_]],
      classOf[ScGivenAliasImpl],
      classOf[ScMacroDefinitionImpl],
      classOf[ScPrimaryConstructorImpl],
    ),
    classOf[UNamedExpression] -> ClassSetKt.classSetOf(
      classOf[ScAssignmentImpl],
    ),
    classOf[UObjectLiteralExpression] -> ClassSetKt.classSetOf(
      classOf[ScNewTemplateDefinitionImpl],
    ),
    classOf[UParameter] -> ClassSetKt.classSetOf(
      classOf[ScClassParameterImpl],
      classOf[ScParameterImpl],
    ),
    classOf[UParenthesizedExpression] -> ClassSetKt.classSetOf(
      classOf[ScParenthesisedExprImpl],
    ),
    classOf[UPolyadicExpression] -> ClassSetKt.classSetOf(
      classOf[ScAssignmentImpl],
      classOf[ScInfixExprImpl],
    ),
    classOf[UPostfixExpression] -> ClassSetKt.classSetOf(
      classOf[ScPostfixExprImpl],
    ),
    classOf[UPrefixExpression] -> ClassSetKt.classSetOf(
      classOf[ScPrefixExprImpl],
    ),
    classOf[UQualifiedReferenceExpression] -> ClassSetKt.classSetOf(
      classOf[ScDocResolvableCodeReferenceImpl],
      classOf[ScDocThrowTagValueImpl],
      classOf[ScGenericCallImpl],
      classOf[ScMethodCallImpl],
      classOf[ScReferenceExpressionImpl],
      classOf[ScStableCodeReferenceImpl],
    ),
    classOf[UReferenceExpression] -> ClassSetKt.classSetOf(
      classOf[ScAnnotTypeElementImpl],
      classOf[ScDocResolvableCodeReferenceImpl],
      classOf[ScDocTagValueImpl],
      classOf[ScDocThrowTagValueImpl],
      classOf[ScGenericCallImpl],
      classOf[ScInterpolatedExpressionPrefix],
      classOf[ScInterpolatedPatternPrefix],
      classOf[ScMethodCallImpl],
      classOf[ScParameterizedTypeElementImpl],
      classOf[ScReferenceExpressionImpl],
      classOf[ScSimpleTypeElementImpl],
      classOf[ScStableCodeReferenceImpl],
      classOf[ScTypeProjectionImpl],
      classOf[ScUnderscoreSectionImpl],
    ),
    classOf[UReturnExpression] -> ClassSetKt.classSetOf(
      classOf[ScReturnImpl],
    ),
    classOf[USimpleNameReferenceExpression] -> ClassSetKt.classSetOf(
      classOf[ScDocResolvableCodeReferenceImpl],
      classOf[ScDocTagValueImpl],
      classOf[ScDocThrowTagValueImpl],
      classOf[ScInterpolatedExpressionPrefix],
      classOf[ScInterpolatedPatternPrefix],
      classOf[ScReferenceExpressionImpl],
      classOf[ScStableCodeReferenceImpl],
      classOf[ScTypeProjectionImpl],
    ),
    classOf[USuperExpression] -> ClassSetKt.classSetOf(
      classOf[ScSuperReferenceImpl],
    ),
    classOf[USwitchClauseExpression] -> ClassSetKt.classSetOf(
      classOf[ScCaseClauseImpl],
    ),
    classOf[USwitchClauseExpressionWithBody] -> ClassSetKt.classSetOf(
      classOf[ScCaseClauseImpl],
    ),
    classOf[USwitchExpression] -> ClassSetKt.classSetOf(
      classOf[ScMatchImpl],
    ),
    classOf[UThisExpression] -> ClassSetKt.classSetOf(
      classOf[ScThisReferenceImpl],
    ),
    classOf[UThrowExpression] -> ClassSetKt.classSetOf(
      classOf[ScThrowImpl],
    ),
    classOf[UTryExpression] -> ClassSetKt.classSetOf(
      classOf[ScTryImpl],
    ),
    classOf[UTypeReferenceExpression] -> ClassSetKt.classSetOf(
      classOf[ScAnnotTypeElementImpl],
      classOf[ScParameterizedTypeElementImpl],
      classOf[ScSimpleTypeElementImpl],
    ),
    classOf[UUnaryExpression] -> ClassSetKt.classSetOf(
      classOf[ScPostfixExprImpl],
      classOf[ScPrefixExprImpl],
    ),
    classOf[UVariable] -> ClassSetKt.classSetOf(
      classOf[ScClassParameterImpl],
      classOf[ScParameterImpl],
      classOf[ScReferencePatternImpl],
    ),
    classOf[UWhileExpression] -> ClassSetKt.classSetOf(
      classOf[ScWhileImpl],
    ),
    classOf[UastEmptyExpression] -> ClassSetKt.classSetOf(
      classOf[ScForImpl],
    ),

  )
}
