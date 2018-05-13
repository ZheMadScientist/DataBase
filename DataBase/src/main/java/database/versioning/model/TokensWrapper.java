package database.versioning.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий оболочку {@link Token} для хранения набора токенов, соответствующих нескольким лексемам
 */
public class TokensWrapper implements Serializable{

    /**
     * {@code tokens} - набор токенов
     * @see Token
     */
    private List<Token> tokens;

    /**
     * {@code partsSize} содержит кол-во токенов, соответствующих одной лексеме
     */
    private List<Integer> partsSize;

    public TokensWrapper (){
        tokens = new ArrayList<>();
        partsSize = new ArrayList<>();
    }

    /**
     * Метод, добавляющий токены для одной лексемы
     * @param tokens
     */
    public void addTokens(List<Token> tokens) {
        this.tokens.addAll(tokens);
        this.partsSize.add(tokens.size());
    }

    /**
     * Индекс для получения следующего набора токенов
     */
    private int curr = 0;

    /**
     * Метод для получения следующего набора токенов
     * @param i - кол-во токенов
     * @return {@code List<Token>}
     */
    public List<Token> getNext(int i){
        List<Token> res = new ArrayList<>();

        for(int k = 0; k < i; ++k) {
            checkPos();
            res.add(tokens.get(curr));
            ++curr;
        }

        return res;
    }

    /**
     * Метод, проверяющий текущий индекс
     */
    private void checkPos(){
        if(curr == tokens.size())
            curr = 0;
    }

    /**
     * @return {@linkplain TokensWrapper#partsSize}
     */
    public List<Integer> getPartsSize() {
        return partsSize;
    }
}
