package com.wsw.springmybatisdemo.config;

public class DatabaseContextHolder {

    private  final  static  ThreadLocal<DatabaseType> contextHolder  =new ThreadLocal<>();
    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }
}
