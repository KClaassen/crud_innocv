package com.example.android.crudinnocv.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.crudinnocv.models.User

@Dao
interface InnocvDao {
    // Loads all users
    @Query("SELECT  * FROM user ORDER BY id ASC")
    fun getUsers() : LiveData<List<User>>

    //Store values in cache
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(countries: List<User>)
}

@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class InnocvDatabase: RoomDatabase() {
    abstract val innocvDao: InnocvDao

    //companion object allows clients to access the methods for creating or getting the database without instantiating the class
    companion object{

        //@Volatile annotation means value of variable is always up to date and same to all execution threads
        //Value of a volatile variable will never be cached and all writes and reads will be done to and from the main memory
        //It means changes made by one thread to INSTANCE are visible to all other threads immediately.

        @Volatile
        private var INSTANCE: InnocvDatabase? = null

        fun getDatabase(context: Context): InnocvDatabase {
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        InnocvDatabase::class.java,
                        "starling_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE =instance
                }

                return instance
            }
        }
    }
}