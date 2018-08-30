package com.example.huangcl.greendaoupdatedemo;

import android.content.Context;

import com.example.huangcl.greendaoupdatedemo.DaoTable.Student;

import org.greenrobot.greendao.database.Database;

import dao.DaoMaster;
import dao.StudentDao;

public class DatabaseHelper extends DaoMaster.OpenHelper {

    public DatabaseHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.getInstance().migrate(db, StudentDao.class);
    }
}
