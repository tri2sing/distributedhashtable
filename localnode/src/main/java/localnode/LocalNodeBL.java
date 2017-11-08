package localnode;

import java.util.HashMap;

public class LocalNodeBL {
    private static HashMap<Integer, String> entries = new HashMap<>();

    public static int getCount() {
        return entries.size();
    }

    public static String put(Integer key, String value) {
       return entries.put(key, value);
    }

    public static String get(Integer key) {
        return entries.get(key);
    }

}
