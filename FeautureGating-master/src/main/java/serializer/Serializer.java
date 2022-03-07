package serializer;

import account.Address;
import account.User;
import utils.EnumList;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Serializer {
    public static Map<String, Object> object2Map(Object o)
    {
        Map<String, Object> ret = new HashMap<String, Object>();
        Class co = o.getClass();
        Method[] cMethods = co.getMethods();
        for(Method m : cMethods){
            try {
                String getterMethodName = m.getName();
                if(!getterMethodName.contains("get"))
                    continue;
                String attributeName = getterMethodName.replace("get", "");
                Object valObject = m.invoke(o);
                ret.put(attributeName, valObject);
            } catch (Exception e) {
                continue;
            }
        }
        return ret;
    }
}
