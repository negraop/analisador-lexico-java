package br.com.negraop.compiler.main;

import br.com.negraop.compiler.exceptions.PanLexicalException;
import br.com.negraop.compiler.exceptions.PanSyntaxException;
import br.com.negraop.compiler.lexico.PanScanner;
import br.com.negraop.compiler.parser.PanParser;

public class Main {
    public static void main(String[] args) {
        try {
			PanScanner sc = new PanScanner("input.pan");
			PanParser  pa = new PanParser(sc);
			
			pa.E();
			
			System.out.println("Compilation Successful!");
		} catch (PanLexicalException ex) {
			System.out.println("Lexical Error "+ex.getMessage());
		}
		catch (PanSyntaxException ex) {
			System.out.println("Syntax Error "+ex.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Generic Error!!");
			System.out.println(ex.getClass().getName());
		}
    }
}
