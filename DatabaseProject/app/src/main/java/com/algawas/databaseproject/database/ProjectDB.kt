package com.algawas.databaseproject.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.algawas.databaseproject.model.TaskModel
import com.algawas.databaseproject.model.UserModel

class ProjectDB(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        //SQL Standards, use CAPS for initiating and small letters for values
        val initTable = "CREATE TABLE $TABLE_NAME " +
                "($COLUMN_PHONE INTEGER PRIMARY KEY," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_EMAIL TEXT)"
        db.execSQL(initTable)

        val initTable1 = "CREATE TABLE $TABLE_NAME2 " +
                "($COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_PHONE INTEGER," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_COMPLETED TEXT)"

        db.execSQL(initTable1)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        when (newVersion) {
            2 -> {
                val addColumn =
                    "ALTER TABLE $TABLE_NAME ADD COLUMN $COLUMN_PHONE TEXT DEFAULT '000000000'"
                db.execSQL(addColumn)
            }
            else -> {
            }

        }
    }

    fun getUser(phoneIn: Int): UserModel? {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_PHONE = $phoneIn"
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
        if (getUser(phone) != null) {
            return false
        } else {
            val values = ContentValues()
            values.put(COLUMN_PHONE, phone)
            values.put(COLUMN_NAME, name)
            values.put(COLUMN_EMAIL, email)
            database.insert(TABLE_NAME, null, values)
            return true
        }
    }

    fun getTasks(phone: Int): List<TaskModel> {
        val tasks = arrayListOf<TaskModel>()
        val db = readableDatabase
        val query = "SELECT * from $TABLE_NAME2 WHERE $COLUMN_PHONE = $phone"

        //We could have a null, wrong query or so fourth, so we use a try/catch
        try {
            //cursor is basically a row, so it should pass by all the rows
            val cursor = db.rawQuery(query, null)
            while (cursor.moveToNext()) {
                val phone = cursor.getInt(cursor.getColumnIndex(COLUMN_PHONE))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val completed = cursor.getString(cursor.getColumnIndex(COLUMN_COMPLETED))
                val taskModel = TaskModel(phone, name, completed.toBoolean())
                tasks.add(taskModel)
            }
            return tasks
        } catch (exception: SQLiteException) {//This is basically the generic of SQLiteException
            Log.d("Exception", "getUsers: {${exception.message}")
        }
        return tasks
    }

    fun insertTask(phone: Int, name: String, completed: String) {
        val database = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_PHONE, phone)
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_COMPLETED, completed)
        database.insert(TABLE_NAME2, null, values)
    }


    companion object {
        //Database info
        const val DATABASE_NAME = "user_database"
        const val DATABASE_VERSION = 1

        //Table Info
        const val TABLE_NAME = "user_table"
        const val TABLE_NAME2 = "task_table"
        const val COLUMN_PHONE = "phone"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_ID = "id"
        const val COLUMN_COMPLETED = "completed"

    }

}