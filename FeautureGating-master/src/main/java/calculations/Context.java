package calculations;

import serializer.Serializer;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Object> variablesMap = new HashMap<String, Object>();

    public void assign(String var, Object value) {
        variablesMap.put(var, value);
    }

    public Object getValue(String var) {
        if(variablesMap.containsKey(var))
            return variablesMap.get(var);
        return null;
    }

    public Context() { }

    public Context(Object o){
        initialize(o);
    }

    private void initialize(Object o) {
        Map<String, Object> map = Serializer.object2Map(o);
        for(String key : map.keySet()){
            assign(key, map.get(key));
        }
    }
}
