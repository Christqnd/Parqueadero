/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author pc_hp
 */
public class JTextFieldLimit extends PlainDocument {

    private int limit;
    private String tipo;
    private char[] caracteres;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
        this.tipo = "";
        this.caracteres = new char[0];
    }

    JTextFieldLimit(int limit, String tipo) {
        super();
        this.limit = limit;
        this.tipo = tipo;
        this.caracteres = new char[0];
    }

    JTextFieldLimit(int limit, String tipo, char[] caracteres) {
        super();
        this.limit = limit;
        this.tipo = tipo;
        this.caracteres = caracteres;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        String cadena = String.valueOf(caracteres);
        boolean result = cadena.contains(str.toString());
        boolean result1 = Character.isLetter(str.charAt(0));
        boolean result2 = Character.isDigit(str.charAt(0));
        boolean result3 = caracteres.length == 0;
        boolean result4 = String.valueOf(caracteres).contains(str.toString());
        if ((getLength() + str.length()) <= limit) {
            if (this.tipo.equals("alfabetico") && Character.isLetter(str.charAt(0))  || String.valueOf(caracteres).contains(str.toString())) {
                super.insertString(offset, str, attr);
            } else if (this.tipo.equals("numerico") && Character.isDigit(str.charAt(0))  || String.valueOf(caracteres).contains(str.toString())) {
                super.insertString(offset, str, attr);
            } else if (this.tipo.equals("alfanumerico") && (Character.isLetter(str.charAt(0)) || Character.isDigit(str.charAt(0)) || caracteres.length == 0 || String.valueOf(caracteres).contains(str.toString()))) {
                super.insertString(offset, str, attr);
            } else if (this.tipo.equals("")) {
                super.insertString(offset, str, attr);
            }
        }
    }
}
