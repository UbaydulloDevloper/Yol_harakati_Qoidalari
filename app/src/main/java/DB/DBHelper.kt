package DB

import Models.WayClass
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION),
    InterfaceDB {
    companion object {
        const val DB_NAME = "yol_belgi_DB"
        const val DB_VERSION = 1

        const val TABLE_DB = "yol_table"
        const val ID = "id"
        const val YOL_PATH = "yol_path"
        const val IMAGE = "yol_image"
        const val YOL_NAME = "yol_name"
        const val YOL_ABOUT = "yol_about"
        const val YOL_TUR = "yol_tur"
        const val YOL_LIKE = "yol_like"


    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table $TABLE_DB($ID integer primary key autoincrement not null, $YOL_PATH text not null, $IMAGE blob not null, $YOL_NAME text not null, $YOL_ABOUT text not null, $YOL_TUR text not null, $YOL_LIKE integer not null)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun addImage(wayClass: WayClass) {
        val database = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(YOL_NAME, wayClass.imageName) // yo'l belgining nomi
        contentValue.put(YOL_ABOUT, wayClass.imageAbout)// yo'l belgiga tarif
        contentValue.put(YOL_PATH, wayClass.imagePath) //yo'l belgining rasmini turgan joyi
        contentValue.put(YOL_TUR, wayClass.imageTur) // yo'l belgining turi
        contentValue.put(IMAGE, wayClass.image) // yo'l belgining rasmi
        contentValue.put(YOL_LIKE, 0) // yo'l belgining like
        database.insert(TABLE_DB, null, contentValue)
        database.close()
    }

    override fun editImage(wayClass: WayClass): Int {
        val database = this.writableDatabase
        val contentValue = ContentValues()

        contentValue.put(YOL_NAME, wayClass.imageName) // yo'l belgining nomi
        contentValue.put(YOL_ABOUT, wayClass.imageAbout)// yo'l belgiga tarif
        contentValue.put(YOL_PATH, wayClass.imagePath) //yo'l belgining rasmini turgan joyi
        contentValue.put(YOL_TUR, wayClass.imageTur) // yo'l belgining turi
        contentValue.put(IMAGE, wayClass.image) // yo'l belgining rasmi
        contentValue.put(YOL_LIKE, wayClass.imageLike) // yo'l belgining like

        return database.update(TABLE_DB, contentValue, "$ID = ?", arrayOf(wayClass.id.toString()))

    }

    override fun deleteImage(wayClass: WayClass) {
        val database = this.writableDatabase
        database.delete(TABLE_DB, "$ID = ?", arrayOf(wayClass.id.toString()))
        database.close()
    }

    override fun getAllImage(): List<WayClass> {
        val list = ArrayList<WayClass>()
        val database = this.readableDatabase
        val cursor = database.rawQuery("select * from $TABLE_DB", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val namePath = cursor.getString(1)
                val image = cursor.getBlob(2)
                val imageName = cursor.getString(3)
                val imageAbout = cursor.getString(4)
                val imageTur = cursor.getString(5)
                val imageLike = cursor.getInt(6)
                list.add(WayClass(id, imageName, namePath, imageAbout, image, imageTur, imageLike))
            } while (cursor.moveToNext())
        }
        return list

    }
}