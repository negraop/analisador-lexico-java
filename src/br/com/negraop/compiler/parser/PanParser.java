package br.com.negraop.compiler.parser;

import br.com.negraop.compiler.exceptions.PanSyntaxException;
import br.com.negraop.compiler.lexico.PanScanner;
import br.com.negraop.compiler.lexico.Token;
import br.com.negraop.compiler.lexico.TokenType;

public class PanParser {

    private PanScanner scanner;   // o analisador léxico
    private Token      token;     // o token atual

    /* O Parser recebe o analisador léxico como parâmetro no construtor
     * pois a cada procedimento invoca-o sob demanda.
     */
    public PanParser(PanScanner scanner) {
        this.scanner = scanner;
    }

    public void E() {
        T();
        El();
    }

    public void El() {
        token = scanner.nextToken();
        if (token != null) {
            OP();
            T();
            El();
        }
    }

    public void T() {
        token = scanner.nextToken();
        if (token.getType() != TokenType.IDENTIFIER && token.getType() != TokenType.NUMBER) {
            throw new PanSyntaxException("ID or NUMBER Expected! Found " + token.getType().name() + " (" + token.getText() + ") at Line " + token.getLine() + " and Column " + token.getColumn());
        }
    }

    public void OP() {
        if (token.getType() != TokenType.OPERATOR) {
            throw new PanSyntaxException("Operator Expected! Found " + token.getType().name() + " (" + token.getText() + ") at Line " + token.getLine() + " and Column " + token.getColumn());
        }
    }
}
