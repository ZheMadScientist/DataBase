package database.versioning.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TokensWrapper implements Serializable{

    private List<Token> tokens;

    /**
     * partsSize contains number of tokens per one lexeme of serialized obj
     */
    private List<Integer> partsSize;

    public TokensWrapper (){
        tokens = new ArrayList<>();
        partsSize = new ArrayList<>();
    }

    public void addTokens(List<Token> tokens) {
        this.tokens.addAll(tokens);
        this.partsSize.add(tokens.size());
    }

    int curr = 0;

    public List<Token> getNext(int i){
        List<Token> res = new ArrayList<>();

        for(int k = 0; k < i; ++k) {
            checkPos();
            res.add(tokens.get(curr));
            ++curr;
        }

        return res;
    }

    private void checkPos(){
        if(curr == tokens.size())
            curr = 0;
    }

    public List<Integer> getPartsSize() {
        return partsSize;
    }
}
