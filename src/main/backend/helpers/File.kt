package main.backend.helpers

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

fun setImageFileByName(name: String): MultipartBody.Part {
    val image = File("src/main/resources/files/", name)
    val requestFile = RequestBody.create(MediaType.parse("image/*"), image)
    return MultipartBody.Part.createFormData("file", image.name, requestFile)
}