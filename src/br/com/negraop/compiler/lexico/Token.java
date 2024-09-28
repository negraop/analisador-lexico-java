package br.com.negraop.compiler.lexico;

public class Token {
    private TokenType type;
    private String    text;
    private int       line;
    private int       column;

    public Token(TokenType type, String text) {
        super();
        this.type = type;
        this.text = text;
    }

    public Token() {
        super();
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Token [type=" + type + ", text=" + text + "]";
    }
}
