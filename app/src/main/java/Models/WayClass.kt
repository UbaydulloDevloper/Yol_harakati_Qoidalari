package Models

class WayClass {
    var id: Int? = null
    var imageName: String? = null
    var imagePath: String? = null
    var imageAbout: String? = null
    var image: ByteArray? = null
    var imageTur: String? = null
    var imageLike: Int? = null


    constructor(
        imageName: String?,
        imagePath: String?,
        imageAbout: String?,
        image: ByteArray?,
        imageTur: String?
    ) {
        this.imageName = imageName
        this.imagePath = imagePath
        this.imageAbout = imageAbout
        this.image = image
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
        image: ByteArray?,
        imageTur: String?,
        imageLike: Int?
    ) {
        this.imageName = imageName
        this.imagePath = imagePath
        this.imageAbout = imageAbout
        this.image = image
        this.imageTur = imageTur
        this.imageLike = imageLike
    }


    constructor(
        id: Int?,
        imageName: String?,
        imagePath: String?,
        imageAbout: String?,
        image: ByteArray?,
        imageTur: String?,
        imageLike: Int?
    ) {
        this.id = id
        this.imageName = imageName
        this.imagePath = imagePath
        this.imageAbout = imageAbout
        this.image = image
        this.imageTur = imageTur
        this.imageLike = imageLike
    }

    constructor()
}