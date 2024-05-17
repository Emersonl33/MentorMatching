package com.example.mentormatching.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mentormatching.model.Pessoa

@Database(entities = [Pessoa::class],
    version = 1)
abstract class PessoaDB: RoomDatabase() {
    abstract fun PessoaDao(): PessoaDao

    companion object {

        private lateinit var instance: PessoaDB
        fun getDatabase(context: Context): PessoaDB {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        PessoaDB::class.java,
                        "pessoa_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}