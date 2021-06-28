package com.codingwithmehdi.android.cloud.ocr_sample

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmehdi.android.cloud.ocr.TextRecognition
import java.io.File


class MainActivity : AppCompatActivity() {

    private var pickImageIntent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            try {
                val data: Intent? = result.data
                val image = findViewById<ImageView>(R.id.image)
                val selectedImageUri: Uri = data?.data!!
                image.setImageURI(selectedImageUri)
                TextRecognition.fromFile(File(selectedImageUri.path!!), object :TextRecognition.Callback {
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
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            pickImageIntent.launch(intent)
        }

    }
    
}