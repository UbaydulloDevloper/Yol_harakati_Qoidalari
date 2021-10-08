package DB

import Models.WayClass

interface InterfaceDB {
    fun addImage(wayClass: WayClass)
    fun editImage(wayClass: WayClass): Int
    fun deleteImage(wayClass: WayClass)
    fun getAllImage(): List<WayClass>
}