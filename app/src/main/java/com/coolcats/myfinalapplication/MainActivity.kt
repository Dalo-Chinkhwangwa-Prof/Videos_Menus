package com.coolcats.myfinalapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import com.coolcats.myfinalapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.menuImageview.setOnClickListener {
            val menu = PopupMenu(this, it)
            val popUpInflater = menu.menuInflater
            popUpInflater.inflate(
                R.menu.main_menu,
                menu.menu
            )
            menu.setOnMenuItemClickListener { menuIt ->

                when(menuIt.itemId){
                    R.id.names -> {

                    }
                    R.id.vid_1 -> {
                        playVideo("https://soniczone.net/Downloads/Video/Underground/E01.mp4")
                    }
                    R.id.vid_2 -> {
                        playVideo("https://soniczone.net/Downloads/Video/Underground/E02.mp4")
                    }
                    R.id.vid_3 -> {
                        playVideo("https://soniczone.net/Downloads/Video/Underground/E03.mp4")
                    }
                    R.id.settings -> {
                        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    }
                }

                true
            }
            menu.show()
        }

    }

    private fun playVideo(videoPath: String) {
        binding.videoView.stopPlayback()
        binding.videoView.setVideoURI(Uri.parse(videoPath))
        binding.videoView.setOnPreparedListener { mp ->
            mp.start()
            Log.d("TAG_X", "Should be starting......")
        }
    }
}