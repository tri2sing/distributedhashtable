package consistenthashing;

public interface HashFunction<K> {
    public int getHashValue(K key);
}
