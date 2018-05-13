package database.versioning.tools;

import database.versioning.model.Token;
import database.versioning.model.TokensWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, предоставляющий методы для версионирования
 */
public class VersioningUtils {

    /**
     * Метод, возвращающий {@link TokensWrapper}, хранящий "разницу" двух JSON
     * @param firstJSON - JSON обновленного объекта
     * @param secondJSON - JSON текущего (устаревшего) объекта
     * @return {@linkplain TokensWrapper}
     */
    public static TokensWrapper getTokensWrapper(String firstJSON, String secondJSON) {
        TokensWrapper tokensWrapper = new TokensWrapper();

        String[] firstParts = firstJSON.split(";");
        String[] secondParts = secondJSON.split(";");

        boolean isFirstLonger = firstParts.length > secondParts.length;
        int lastIndex = isFirstLonger ? secondParts.length : firstParts.length;

        for(int i = 0; i < lastIndex; ++i){
            tokensWrapper.addTokens(getDiffs(firstParts[i], secondParts[i]));
        }

        if(isFirstLonger){
            for(int i = lastIndex; i < firstParts.length; ++i)
                tokensWrapper.addTokens(getDiffs(firstParts[i], ""));

        } else {
            for(int i = lastIndex; i < secondParts.length; ++i)
                tokensWrapper.addTokens(getDiffs("", secondParts[i]));

        }

        return tokensWrapper;
    }

    /**
     * Метод, восстанавливающий предыдущее состояние объекта
     * по его JSON и {@linkplain TokensWrapper} предыдущей версии
     * @see TokensWrapper
     * @param latestJSON JSON новейшего объекта
     * @param wrapper соответствующий предыдущей версии {@linkplain TokensWrapper}
     * @return строка в формате JSON восстановленного состояния объекта
     */
    public static String recoverFromWrapper(String[] latestJSON, TokensWrapper wrapper){
        String res = "";

        List<Integer> partsSize = wrapper.getPartsSize();

        if(latestJSON.length != partsSize.size())
            return res;

        for(int i = 0; i < partsSize.size(); ++i){
            res = res.concat(recover(wrapper.getNext(partsSize.get(i)), latestJSON[i]));
            res = res.concat(recover(wrapper.getNext(partsSize.get(i)), latestJSON[i]));
        }

        return res;
    }

    /**
     * Метод, находящий "разницу" строк (относительно первой строки) и токенизирующий ее
     * @see Token
     * @param first первая строка
     * @param second вторая строка
     * @return {@code List<Token>} токены
     */
    static List<Token> getDiffs(String first, String second){
        List<Token> tokens = new ArrayList<>();

        char[] firstT = first.toCharArray();
        char[] secondT = second.toCharArray();

        boolean isFirstLonger = first.length() > second.length();
        int lastIndex = isFirstLonger ? second.length() : first.length();

        char operation = ' ';
        Token tmp = new Token();
        for(int i = 0; i < lastIndex; ++i){
            if(firstT[i] == secondT[i]){
                operation = ' ';

            } else {
                if(operation != 'r'){
                    operation = 'r';
                    tmp = new Token(i, operation);
                    tokens.add(tmp);
                }
                tmp.append(secondT[i]);
            }
        }

        if(isFirstLonger){
            tokens.add(new Token(first.substring(lastIndex).length()));
        } else {
            tokens.add(new Token('+', lastIndex, first.length() - 1, first.substring(lastIndex)));
        }

        return tokens;
    }

    /**
     * Метод, восстанавливающий состояние строки по строке её последней версии и токенам строки предыдущей версии
     * @param tokens токены строки предыдущей версии
     * @param s последняя версия строки
     * @return восстановленная строка
     */
    static String recover(List<Token> tokens, String s){
        char[] tmp = s.toCharArray();

        for(Token token : tokens){
            if(token.operation == 'r'){
                for(int i = token.getFrom(); i <= token.getTo(); ++i)
                    tmp[i] = token.next();

            } else if (token.operation == '+') {
                char[] buff = tmp;
                tmp = new char[tmp.length + token.length()];
                System.arraycopy(buff, 0, tmp, 0, buff.length);

                for(int i = buff.length; i < tmp.length; ++i)
                    tmp[i] = token.next();

            } else if(token.operation == '-') {
                char[] buff = tmp;
                tmp = new char[tmp.length - token.lengthToDelete()];
                System.arraycopy(buff, 0, tmp, 0, tmp.length);

            }
        }

        return new String(tmp);
    }

}
