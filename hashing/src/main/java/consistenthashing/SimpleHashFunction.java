package consistenthashing;

public class SimpleHashFunction implements HashFunction<String> {
    public int getHashValue(String key) {
        return key.hashCode();
    }
}
