package com.example.julian.universedb.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.julian.universedb.BuildConfig;
import com.example.julian.universedb.db.converters.MiniSeriesConverter;
import com.example.julian.universedb.db.converters.NameConverter;
import com.example.julian.universedb.db.converters.PictureConverter;
import com.example.julian.universedb.db.dao.LigaDao;
import com.example.julian.universedb.db.dao.NebulosasDao;
import com.example.julian.universedb.db.dao.UserDao;
import com.example.julian.universedb.db.dao.UsersDao;
import com.example.julian.universedb.db.entities.Liga;
import com.example.julian.universedb.db.entities.Nebulosas;
import com.example.julian.universedb.db.entities.User;
import com.example.julian.universedb.db.entities.Users;
import com.example.julian.universedb.global.Constants;

/**
 * Created by Santiago Battaglino.
 * This class is used to create the database and get an instance of it.
 */
@Database(entities = {
        User.class,
        Liga.class,
        Users.class,
        Nebulosas.class
}, version = 1)
@TypeConverters({MiniSeriesConverter.class, NameConverter.class, PictureConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    /*
     *  Data Access Objects (DAO) to manipulate our db table.
     *  We have to create an abstract method for every DAO class that we create.
     *  inMemoryDatabaseBuilder or databaseBuilder
     */
    public static AppDatabase getDatabaseBuilder(Context context) {
        if (INSTANCE == null) {
            if (BuildConfig.DEBUG) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, Constants.DB_NAME)
                        .allowMainThreadQueries()
                        .build();
            } else {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, Constants.DB_NAME)
                        .build();
            }
        }
        return INSTANCE;
    }

    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            if (BuildConfig.DEBUG) {
                INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                        .allowMainThreadQueries()
                        .build();
            } else {
                INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                        .build();
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract UserDao userModel();

    public abstract LigaDao ligaModel();

    public abstract UsersDao usersModel();

    public abstract NebulosasDao nebulosasModel();

    // If you need to update your database version, and add entities or new columns,
    // you gonna have to implement a Migration operation in order to avoid crashes or users losing data

    /*public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE product "
                    + " ADD COLUMN street TEXT, number TEXT, neighborhood TEXT");
        }
    };*/
}
