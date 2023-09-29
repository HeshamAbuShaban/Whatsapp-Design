package dev.training.whatsapp_design.app_system.prefs;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppSharedPreferences {
    private enum SharedKeys {
        STR_KEY, F_KEY, INT_KEY,
    }

    @Inject
    public SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    private static volatile AppSharedPreferences Instance;

    private AppSharedPreferences() {
        editor = sharedPreferences.edit();
    }

    public static synchronized AppSharedPreferences getInstance() {
        if (Instance == null) {
            Instance = new AppSharedPreferences();
        }
        return Instance;
    }

    public void putString(String str) {
        editor.putString(SharedKeys.STR_KEY.name(), str);
        editor.apply();
    }

    public void putInt(int integer) {
        editor.putInt(SharedKeys.INT_KEY.name(), integer);
        editor.apply();
    }

    public void putFloat(float floatValue) {
        editor.putFloat(SharedKeys.F_KEY.name(), floatValue);
        editor.apply();
    }

    public void removeValueOfKey(String key) {
        editor.remove(key).apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "undefined");
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }

    public float getFloat(String key) {
        return sharedPreferences.getFloat(key, 0.0f);
    }

}
