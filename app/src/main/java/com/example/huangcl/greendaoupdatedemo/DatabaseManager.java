package com.example.huangcl.greendaoupdatedemo;

import dao.DaoMaster;
import dao.DaoSession;

public class DatabaseManager {

    private static DatabaseManager databaseManager;
    private static DatabaseHelper databaseHelper;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static DatabaseManager getInstance() {
        if(databaseManager==null) {
            synchronized (DatabaseManager.class) {
                if(databaseManager==null) {
                    databaseManager=new DatabaseManager();
                }
            }
        }
        return databaseManager;
    }

    public static DatabaseHelper getDatabaseHelper() {
        if(databaseHelper==null) {
            synchronized (DatabaseHelper.class) {
                if(databaseHelper==null) {
                    databaseHelper=new DatabaseHelper(MApplication.getContext(),"Student.db");
                }
            }
        }
        return databaseHelper;
    }

    public static DaoMaster getDaoMaster() {
        if(daoMaster==null) {
            synchronized (DaoMaster.class) {
                if(daoMaster==null) {
                    daoMaster=new DaoMaster(getDatabaseHelper().getWritableDatabase());
                }
            }
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        if(daoSession==null) {
            synchronized (DaoSession.class) {
                if(daoSession==null) {
                    daoSession=getDaoMaster().newSession();
                }
            }
        }
        return daoSession;
    }
}
