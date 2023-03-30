package com.example.fastcampus

import android.media.Image
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

class MelonDetailActivity : AppCompatActivity() {


    lateinit var playPauseButton: ImageView
    lateinit var mediaPlayer: MediaPlayer
    lateinit var melonitemList: ArrayList<MelonItem>

    var position = 0
        set(value) {
            if (value >= 0) field = 0
            else if (value >= melonitemList.size) field = melonitemList.size
            else field = value
        }

    // 재생중인지 아닌지
    var is_playing: Boolean = true
        set(value) {
            if (value == true) {
                playPauseButton.setImageDrawable(
                    this.resources.getDrawable(R.drawable.pause, this.theme)
                )
            } else {
                playPauseButton.setImageDrawable(
                    this.resources.getDrawable(R.drawable.play, this.theme)
                )
            }
            field = value
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melon_detail)

        // 분해된걸 받아서 캐스팅 해준다.
        melonitemList = intent.getSerializableExtra("melon_item_list") as ArrayList<MelonItem>
        // 몇번째 노래인지를 받아온다.
        position = intent.getIntExtra("position", 0)

        playMelonItem(melonitemList.get(position))
        //상세페이지 오자마자 썸내일 그려짐
        changeThumbnail(melonitemList.get(position))

        playPauseButton = findViewById(R.id.play)
        playPauseButton.setOnClickListener {
            if (is_playing == true) {
                is_playing = false
                mediaPlayer.stop()
            } else {
                is_playing == true
                playMelonItem(melonitemList.get(position))
            }
        }
        findViewById<ImageView>(R.id.back).setOnClickListener {
            mediaPlayer.stop()
            position = position - 1
            playMelonItem(melonitemList.get(position))
            changeThumbnail(melonitemList.get(position))
        }
        
        findViewById<ImageView>(R.id.next).setOnClickListener {
            mediaPlayer.stop()
            position = position + 1
            playMelonItem(melonitemList.get(position))
            changeThumbnail(melonitemList.get(position))
        }
    }

    // 해당번째 곡을 틀어주는역할
    fun playMelonItem(melonItem: MelonItem) {
        mediaPlayer = MediaPlayer.create(
            this,
            Uri.parse(melonItem.song)
        )
        mediaPlayer.start()
    }

    fun changeThumbnail(melonItem: MelonItem) {
        findViewById<ImageView>(R.id.thumbnail).apply {
            val glide = Glide.with(this@MelonDetailActivity)
            glide.load(melonItem.thumbnail).into(this)
        }
    }
}