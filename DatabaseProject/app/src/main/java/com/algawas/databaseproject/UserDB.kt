package com.algawas.databaseproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class UserDB(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        //SQL Standards, use CAPS for initiating and small letters for values
        val initTable = "CREATE TABLE $TABLE_NAME " +
                        "($COLUMN_PHONE INTEGER PRIMARY KEY," +
                        "$COLUMN_NAME TEXT," +
                        "$COLUMN_EMAIL TEXT)"
        db.execSQL(initTable)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        when (newVersion) {
            2 -> {
                val addColumn =
                    "ALTER TABLE $TABLE_NAME ADD COLUMN $COLUMN_PHONE TEXT DEFAULT '000000000'"
                db.execSQL(addColumn)
            }else -> {
        }

        }
    }

    fun getUser(phone: Int): UserModel? {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_PHONE = $phone"
        val cursor = db.rawQuery(query, null)
        var userInfo: UserModel? = null //we use a data class to get the db

        if (cursor.moveToFirst()) {
            val phone = cursor.getInt(cursor.getColumnIndex(COLUMN_PHONE))
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
            val email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL))
            userInfo = UserModel(phone, name, email)
        }
        return userInfo
    }

    fun insertUser(phone: Int, name: String, email: String): Boolean {
        val database = writableDatabase
        if(getUser(phone) != null) {
            return false
        }else{
            val values = ContentValues()
            values.put(COLUMN_PHONE, phone)
            values.put(COLUMN_NAME, name)
            values.put(COLUMN_EMAIL, email)
            database.insert(TABLE_NAME, null, values)
            return true
        }
    }/*

    fun userExist(phone: Int): Boolean {
        Log.d("TAG", "userExist: $phone")
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME = $phone"
        val cursor = db.rawQuery(query, null)
        Log.d("TAG", "moveToFirst: ${cursor.moveToFirst()}")

        return cursor.moveToFirst()
    }*/


    companion object {
        //Database info
        const val DATABASE_NAME = "project_database"
        const val DATABASE_VERSION = 1

        //Table Info
        const val TABLE_NAME = "user_table"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"

    }

}