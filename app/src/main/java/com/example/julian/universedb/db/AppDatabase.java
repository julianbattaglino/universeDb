package com.example.julian.universedb.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.julian.universedb.BuildConfig;
import com.example.julian.universedb.db.converters.NameConverter;
import com.example.julian.universedb.db.converters.PictureConverter;
import com.example.julian.universedb.db.dao.NebulosasDao;
import com.example.julian.universedb.db.dao.PlanetariasDao;
import com.example.julian.universedb.db.dao.PlanetasDao;
import com.example.julian.universedb.db.dao.SatelitesDao;
import com.example.julian.universedb.db.dao.UserDao;
import com.example.julian.universedb.db.entities.Nebulosas;
import com.example.julian.universedb.db.entities.Planetarias;
import com.example.julian.universedb.db.entities.Planetas;
import com.example.julian.universedb.db.entities.Satelites;
import com.example.julian.universedb.db.entities.User;
import com.example.julian.universedb.global.Constants;

/**
 * Created by Santiago Battaglino.
 * This class is used to create the database and get an instance of it.
 */
@Database(entities = {
        User.class,
        Nebulosas.class,
        Planetarias.class,
        Planetas.class,
        Satelites.class

}, version = 1)
@TypeConverters({NameConverter.class, PictureConverter.class})
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

    public abstract NebulosasDao nebulosasModel();

    public abstract PlanetariasDao planetariasModel();

    public abstract PlanetasDao planetasModel();

    public abstract SatelitesDao satelitesModel();

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
