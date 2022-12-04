package com.example.example_for_uplod_image

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*

var btSelect :Button? =null

class MainActivity : AppCompatActivity() {
    var mStorage : StorageReference ? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mStorage = FirebaseStorage.getInstance().reference
         btSelect= findViewById(R.id.selectimage)
        btSelect?.setOnClickListener {

          val intentImage = Intent(Intent.ACTION_PICK)
            intentImage.type ="image/*"
           startActivityForResult(intentImage,3 )





        }




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==3 && resultCode== RESULT_OK){
            val uriImage = data?.data
           val fliePath=  mStorage?.child(Calendar.getInstance().time.toString())
            if (fliePath != null) {
                fliePath?.putFile(uriImage!!)?.addOnSuccessListener {
               Toast.makeText(applicationContext,"Upload Image",Toast.LENGTH_LONG) .show()

                }
            }

        }
    }

}