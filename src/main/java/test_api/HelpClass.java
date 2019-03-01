package test_api;

import org.json.JSONObject;

class HelpClass {
    static String  createJSON(String key1, String key2, String value1, String value2) {
        return new JSONObject()
                .put(key1, value1)
                .put(key2, value2)
                .toString();
    }
}
