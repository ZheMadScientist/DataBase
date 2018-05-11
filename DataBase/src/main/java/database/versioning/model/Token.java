package database.versioning.model;

import java.io.Serializable;

public class Token implements Serializable {

    public char operation;

    // included index
    private int from;

    // included index
    private int to;

    private int length_to_delete = 0;

    private char[] token;

    private int pos = 0;

    private int index = 0;

    public void append(char ch) {
        if (token == null) {
            token = new char[2];
            token[0] = ch;
        } else {
            ++to;
            ++pos;
            if (pos != token.length - 1) {
                token[pos] = ch;
            } else {
                char[] tmp = token;
                token = new char[token.length * 2];

                System.arraycopy(tmp, 0, token, 0, tmp.length);

                token[pos] = ch;
            }
        }
    }

    public Token() {
    }

    public Token(int length_to_delete) {
        this.length_to_delete = length_to_delete;
    }

    public Token(int from, char operation) {
        this.from = from;
        this.to = from;
        this.operation = operation;
    }

    public Token(char operation, int from, int to, String content) {
        this.operation = operation;
        this.from = from;
        this.to = to;
        this.token = content.toCharArray();
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getToken() {
        return new String(token);
    }

    public char next() {
        checkIndex();
        return token[index++];
    }

    public int length() {
        return token.length;
    }

    public int lengthToDelete(){
        return length_to_delete;
    }

    private void checkIndex() {
        if (index == token.length)
            index = 0;
    }

}
