package com.civiledcode.dbextend;

import cn.nukkit.plugin.PluginBase;

public class DBEMain extends PluginBase {
    public static DBEMain instance;

    public static void log(String string) {
        instance.getLogger().info(string);
    }

    @Override
    public void onEnable() {
        instance = this;
    }
}
