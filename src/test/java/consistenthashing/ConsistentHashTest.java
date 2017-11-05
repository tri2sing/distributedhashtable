package consistenthashing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ConsistentHashTest {
    private int numServerNodes = 5;
    private SimpleServerNode[] nodes;
    private HashFunction<String> hashFunction = new SimpleHashFunction();
    ConsistentHash<SimpleServerNode> consistentHash;

    @Before
    public void setUp() throws Exception {
        nodes = new SimpleServerNode[numServerNodes];
        for (int i = 0; i < numServerNodes; i++) {
            nodes[i] = new SimpleServerNode();
            nodes[i].setKey("server" + i);
        }
        consistentHash = new ConsistentHash<SimpleServerNode>(hashFunction, 3, Arrays.asList(nodes));
    }

    @Test
    public void test1() {
        assertThat(consistentHash.getServerCount()).isEqualTo(numServerNodes * consistentHash.getNumVirtualNodes());
    }

    @Test
    public void test2() {
        for(int i = 0; i < numServerNodes; i++) {
            for(int j = 0; j < consistentHash.getNumVirtualNodes(); j++) {
                assertThat(consistentHash.getServer(nodes[i].getKey() + j)).isEqualTo(nodes[i]);
            }
        }
    }


}
