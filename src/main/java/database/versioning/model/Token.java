package database.versioning.model;

import java.io.Serializable;

/**
 * Класс для хранения "разности" строк
 */
public class Token implements Serializable {

    /**
     * Содержит операцию токена по отношению к обновленной строке
     */
    public char operation;

    // included index
    /**
     * индекс строки начала
     * применеия токена
     */
    private int from;

    // included index
    /**
     * индекс строки конца
     * применеия токена
     */
    private int to;

    /**
     * длина для удаления с конца строки
     */
    private int length_to_delete = 0;

    /**
     * массив разности строк
     */
    private char[] token;

    /**
     * текущий индекс в {@link Token#token}
     * при заполнении массива
     */
    private int pos = 0;

    /**
     * текущий индекс в {@link Token#token}
     * для получения следующего символа
     */
    private int index = 0;

    /**
     * Метод, дополняющий {@link Token#token}
     * @param ch - следующий символ
     */
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

    public Token() { }

    public Token(int length_to_delete) {
        this.operation = '-';
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

    /**
     * {@linkplain Token#from} геттер
     * @return {@link Token#from}
     */
    public int getFrom() {
        return from;
    }

    /**
     * {@linkplain Token#to} геттер
     * @return {@link Token#to}
     */
    public int getTo() {
        return to;
    }

    /**
     * {@linkplain Token#token} геттер
     * @return {@link Token#token} преобразованный в строку
     */
    public String getToken() {
        return new String(token);
    }

    /**
     * Проверяет индекс и
     * возвращает следующий символ в {@linkplain Token#token}
     * @return char
     */
    public char next() {
        checkIndex();
        return token[index++];
    }

    /**
     * Возвращает длину токена
     * @return {@linkplain Token#token}.length
     */
    public int length() {
        return token.length;
    }

    /**
     * Возвращает длину удаления
     * @return {@linkplain Token#length_to_delete}
     */
    public int lengthToDelete(){
        return length_to_delete;
    }

    /**
     * Проверяет, не вышел ли индекс за пределы массива
     */
    private void checkIndex() {
        if (index == token.length)
            index = 0;
    }

}
