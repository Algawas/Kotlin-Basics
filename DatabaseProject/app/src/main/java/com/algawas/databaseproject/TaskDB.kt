package com.algawas.databaseproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class TaskDB(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        //SQL Standards, use CAPS for initiating and small letters for values

        val initTable = "CREATE TABLE $TABLE_NAME " +
                "($COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_PHONE INTEGER" +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_COMPLETED TEXT)"
        db.execSQL(initTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        when (newVersion) {
            2 -> {
                val addColumn =
                    "ALTER TABLE $TABLE_NAME ADD COLUMN $COLUMN_PHONE TEXT DEFAULT '000000000'"
                db.execSQL(addColumn)
            }
            /*This is used when debugging the software, makesure it's removed
            val dropTable = "DROP TABLE IF EXISTS $TABLE_NAME

            db.execSQL(dropTable)
            onCreate(db)
             */
        }
    }


    fun insertTask(phone: Int, name: String, completed: String) {
        val database = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_PHONE, phone)
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_COMPLETED, completed)
        database.insert(TABLE_NAME, null, values)
    }


    fun getTask(phone: String): TaskModel? {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_PHONE = $phone"
        val cursor = db.rawQuery(query, null)
        var taskInfo: TaskModel? = null //we use a data class to get the db

        if (cursor.moveToFirst()) {
            val phone = cursor.getInt(cursor.getColumnIndex(COLUMN_PHONE))
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
            val completed = cursor.getString(cursor.getColumnIndex(COLUMN_COMPLETED))
            taskInfo = TaskModel(phone, name, completed.toBoolean())
        }
        return taskInfo
    }

    fun getTasks(phone: Int): List<TaskModel> {
        val tasks = arrayListOf<TaskModel>()
        val db = readableDatabase
        val query = "SELECT * from $TABLE_NAME WHERE $COLUMN_PHONE = $phone"

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

    companion object {
        //Database info
        const val DATABASE_NAME = "project_database"
        const val DATABASE_VERSION = 1

        //Table Info
        const val TABLE_NAME = "task_table"
        const val COLUMN_ID = 0
        const val COLUMN_PHONE = "phone"
        const val COLUMN_NAME = "name"
        const val COLUMN_COMPLETED = "completed"
    }
}