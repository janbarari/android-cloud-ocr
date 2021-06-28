package com.codingwithmehdi.android.cloud.ocr_sample

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.codingwithmehdi.android.cloud.ocr.TextRecognition
import java.io.File

class MainActivity : AppCompatActivity() {

    private var pickImageIntent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                try {
                    val uri: Uri = result.data?.data!!
                    val file = File(getRealPathFromURI(uri))

                    val image = findViewById<ImageView>(R.id.image)
                    image.setImageURI(uri)
                    TextRecognition.fromFile(file, object : TextRecognition.Callback {
                        override fun success(response: String) {
                            val contentLabel = findViewById<TextView>(R.id.content_label)
                            contentLabel.text = response
                        }

                        override fun failure(e: Throwable) {
                            val contentLabel = findViewById<TextView>(R.id.content_label)
                            contentLabel.text = e.toString()
                        }

                    })
                } catch (e: Exception) {
                    val contentLabel = findViewById<TextView>(R.id.content_label)
                    contentLabel.text = e.toString()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pickImageButton = findViewById<Button>(R.id.pick_image_button)

        pickImageButton.setOnClickListener {
            if(isStoragePermissionGranted()) {
                Intent().apply {
                    type = "image/*"
                    action = Intent.ACTION_GET_CONTENT
                }.also {
                    pickImageIntent.launch(it)
                }
            } else {
                requestStoragePermission()
            }
        }
    }

    private fun isStoragePermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestStoragePermission() {
        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
    }

    private fun getRealPathFromURI(contentUri: Uri?): String {
        var cursor = contentResolver.query(contentUri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document = cursor.getString(0)
        document = document.substring(document.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,
            MediaStore.Images.Media._ID + " = ? ",
            arrayOf(document),
            null
        )
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }
}