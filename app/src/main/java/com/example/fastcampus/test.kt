package com.example.fastcampus

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class test : Fragment() {

    var imageUri: Uri? = null
    var contentInput: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_item, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedImageView2 = view.findViewById<ImageView>(R.id.selected_img)
        val glide2 = Glide.with(activity as InstaMainActivity)

        val imagePickerLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                imageUri = it.data!!.data
                glide2.load(imageUri).into(selectedImageView2)

            }
        imagePickerLauncher.launch(
            Intent(Intent.ACTION_PICK).apply {
                this.type = MediaStore.Images.Media.CONTENT_TYPE
            }
        )
        view.findViewById<EditText>(R.id.selected_content).doAfterTextChanged {
            contentInput = it.toString()
        }

        val retrofit = Retrofit
            .Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        view.findViewById<TextView>(R.id.upload).setOnClickListener {
            val file = getRealFile2(imageUri!!)

            val requestFile = RequestBody.create(
                MediaType.parse(
                    (activity as InstaMainActivity).contentResolver.getType(imageUri!!)
                ), file
            )

            val body = MultipartBody.Part.createFormData("image", file!!.name, requestFile)
            val content = RequestBody.create(MultipartBody.FORM, contentInput)

            val header = HashMap<String, String>()

            val sp = (activity as InstaMainActivity).getSharedPreferences("user_info", Context.MODE_PRIVATE)
            val token = sp.getString("token", "")
            header.put("Authorizatoin", "token" + token)


            retrofitService.uploadPost(header, body, content).enqueue(object : Callback<Any>{
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }




    }

    private fun getRealFile2(uri: Uri): File?{
        var uri:Uri? = uri
        var projection = arrayOf(MediaStore.Images.Media.DATA)

        if(uri == null){
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }
        var cursor: Cursor? = (activity as InstaMainActivity).getContentResolver().query(
            uri!!,
            projection,
            null,
            null,
            MediaStore.Images.Media.DATE_MODIFIED + " desc"
        )
        if (cursor == null || cursor.columnCount < 1 ){
            return null
        }

        val column_index: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val path: String = cursor.getString(column_index)
        if(cursor != null){
            cursor.close()
            cursor = null
        }
        return File(path)
    }
}
