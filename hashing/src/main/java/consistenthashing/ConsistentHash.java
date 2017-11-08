package src.main.java.consistenthashing;

import java.util.Collection;
import java.util.List;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<S extends ServerNode> {
    private final HashFunction hashFunction;
    private final int numVirtualNodes;
    private final NavigableMap<Integer, S> hashRing;

    public ConsistentHash(HashFunction hashFunction, int numVirtualNodes, Collection<S> servers) {
        this.hashFunction = hashFunction;
        this.numVirtualNodes = numVirtualNodes;
        hashRing = new TreeMap<Integer, S>();
        for (S server : servers) addServer(server);
    }

    public void addServer(S server) {
        for (int i = 0; i < numVirtualNodes; i++) {
            hashRing.put(hashFunction.getHashValue(server.getKey() + i), server);
        }
    }

    public void removeServer(S server) {
        for (int i = 0; i < numVirtualNodes; i++) {
            hashRing.remove(hashFunction.getHashValue(server.getKey() + i));
        }
    }

    public int getServerCount() {
        return hashRing.size();
    }

    public int getNumVirtualNodes(){
        return numVirtualNodes;
    }

    public S getServer(String key) {
        if (hashRing == null) return null;
        int hashValue = hashFunction.getHashValue(key);
        if (!hashRing.containsKey(hashValue)) {
            SortedMap<Integer, S> tailRing = hashRing.tailMap(hashValue);
            hashValue = tailRing.isEmpty() ? hashRing.firstKey() : tailRing.firstKey();
        }
        return hashRing.get(hashValue);
    }

    public List<S> getServer(String key, int numReplicas) {
        if (hashRing == null) return null;
        int hashValue = hashFunction.getHashValue(key);
        return null;

    }
}
