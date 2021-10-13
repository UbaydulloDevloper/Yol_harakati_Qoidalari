package Models

import java.io.Serializable


class WayClass : Serializable {
    var id: Int? = null
    var imageName: String? = null
    var imagePath: String? = null
    var imageAbout: String? = null
    var imageTur: Int? = null
    var imageLike: Int? = null


    constructor(
        imageName: String?,
        imagePath: String?,
        imageAbout: String?,

        imageTur: Int?
    ) {
        this.imageName = imageName
        this.imagePath = imagePath
        this.imageAbout = imageAbout

        this.imageTur = imageTur
    }


    constructor(imageName: String?, imagePath: String?, imageAbout: String?) {
        this.imageName = imageName
        this.imagePath = imagePath
        this.imageAbout = imageAbout
    }

    constructor(
        imageName: String?,
        imagePath: String?,
        imageAbout: String?,

        imageTur: Int?,
        imageLike: Int?
    ) {
        this.imageName = imageName
        this.imagePath = imagePath
        this.imageAbout = imageAbout

        this.imageTur = imageTur
        this.imageLike = imageLike
    }


    constructor(
        id: Int?,
        imageName: String?,
        imagePath: String?,
        imageAbout: String?,

        imageTur: Int?,
        imageLike: Int?
    ) {
        this.id = id
        this.imageName = imageName
        this.imagePath = imagePath
        this.imageAbout = imageAbout

        this.imageTur = imageTur
        this.imageLike = imageLike
    }

    constructor()
}