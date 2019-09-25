package org.jetbrains.plugins.scala.codeInsight.editorActions

import com.intellij.codeInsight.editorActions.{JavaLikeQuoteHandler, MultiCharQuoteHandler}
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.{IElementType, TokenSet}
import org.jetbrains.plugins.scala.lang.lexer.ScalaTokenTypes._
import org.jetbrains.plugins.scala.lang.psi.api.base.ScLiteral
import org.jetbrains.plugins.scala.lang.psi.api.expr.ScReferenceExpression
import org.jetbrains.plugins.scala.settings.ScalaApplicationSettings

class ScalaQuoteHandler extends JavaLikeQuoteHandler with MultiCharQuoteHandler {

  override def isClosingQuote(iterator: HighlighterIterator, offset: Int): Boolean =
    iterator.getTokenType match {
      case `tSTRING` | `tCHAR` | `tINTERPOLATED_STRING_END` =>
        iterator.getStart <= offset && offset == iterator.getEnd - 1
      case _ =>
        false
    }

  override def isOpeningQuote(iterator: HighlighterIterator, offset: Int): Boolean =
    iterator.getTokenType match {
      case `tWRONG_STRING` |
           `tINTERPOLATED_STRING` => offset == iterator.getStart
      case _                      => false
    }

  override def hasNonClosedLiteral(editor: Editor, iterator: HighlighterIterator, offset: Int) = true

  override def isInsideLiteral(iterator: HighlighterIterator): Boolean =
    iterator.getTokenType match {
      case `tSTRING` |
           `tCHAR` |
           `tMULTILINE_STRING` |
           `tINTERPOLATED_STRING` => true
      case _                      => false
    }

  override def getConcatenatableStringTokenTypes: TokenSet = TokenSet.create(tSTRING)

  override def getStringConcatenationOperatorRepresentation = "+"

  override def getStringTokenTypes: TokenSet = TokenSet.create(tSTRING, tINTERPOLATED_STRING)

  override def isAppropriateElementTypeForLiteral(tokenType: IElementType): Boolean =
    tokenType match {
      case `tSEMICOLON` |
           `tCOMMA` |
           `tRPARENTHESIS` |
           `tRSQBRACKET` |
           `tRBRACE` |
           `tSTRING` |
           // to be able to complete empty interpolated string s"" or s"""""" in the very end of the file
           `tIDENTIFIER` | `tINTERPOLATED_STRING_END` |
           `tCHAR` => true
      case _  =>
        COMMENTS_TOKEN_SET.contains(tokenType) ||
          WHITES_SPACES_TOKEN_SET.contains(tokenType)
    }

  override def needParenthesesAroundConcatenation(element: PsiElement): Boolean = {
    val parent = element.getParent
    parent.isInstanceOf[ScLiteral] && parent.getParent.isInstanceOf[ScReferenceExpression]
  }

  // NOTE: despite the naming of the method it only handles closing quote for multiline string literals
  override def getClosingQuote(iterator: HighlighterIterator, offset: Int): CharSequence = {
    if (!ScalaApplicationSettings.getInstance.INSERT_MULTILINE_QUOTES) return null

    val Quotes = "\"\"\""

    def startsWithQuotes: Boolean = offset >= 3 && iterator.getDocument.getText(new TextRange(offset - 3, offset)) == Quotes

    iterator.getTokenType match {
      case `tINTERPOLATED_MULTILINE_STRING` =>
        if (startsWithQuotes) Quotes
        else null
      case _ =>
        // TODO: simplify when parsing of incomplete multiline strings is unified for interpolated and non-interpolated strings
        //  to understand what is happening here just try to open psi stree viewer and see how incomplete `s"""` or `"""` are parsed
        iterator.retreat()
        if (iterator.getTokenType == tWRONG_STRING) {
          iterator.retreat()
          if(iterator.getTokenType == tSTRING && startsWithQuotes) {
            Quotes
          } else null
        } else null
    }
  }
}