package database.utils;

// TODO: delete Pair and refactor DBProvider
public class Pair<A, B> {
    protected A first;
    protected B second;

    public Pair(A first, B second) {
        super();
        this.first = first;
        this.second = second;
    }
}
