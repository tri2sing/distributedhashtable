package src.main.java.consistenthashing;

public interface HashFunction<K> {
    public int getHashValue(K key);
}
