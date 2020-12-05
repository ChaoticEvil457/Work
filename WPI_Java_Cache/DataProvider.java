import java.util.HashMap;

public class DataProvider {
    HashMap map = new HashMap<Object, Object>();

    public DataProvider(){//constructor sets up for tests
        map.put("smurf", "smurfImg");
        map.put("garfield","garfieldImg");
        map.put("snoopy","snoopyImg");
        map.put("marge","margeImg");
    }

    public Object getVal(Object key) {// returns value associated with the key
        return map.get(key);
    }
}
