package consistenthashing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SimpleHashFunctionTest {
    @Test
    public void getHashValue() throws Exception {
        HashFunction<String> hf = new SimpleHashFunction();
        String key = "testkey";
        assertThat(hf.getHashValue(key)).isEqualTo(key.hashCode());
    }

}
