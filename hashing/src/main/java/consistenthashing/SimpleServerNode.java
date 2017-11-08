package src.main.java.consistenthashing;

public class SimpleServerNode implements ServerNode {

    private String serverName;

    public String getKey() {
        return serverName;
    }

    public void setKey(String key) {
        serverName = key;
    }
}
