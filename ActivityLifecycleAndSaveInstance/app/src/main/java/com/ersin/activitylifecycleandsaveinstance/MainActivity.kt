package com.ersin.activitylifecycleandsaveinstance

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.ersin.activitylifecycleandsaveinstance.databinding.ActivityMainBinding
const val KEY_SAYI="sayi"
class MainActivity : AppCompatActivity() {

    private var sayacDeger=0;
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState != null) {
            sayacDeger = savedInstanceState.getInt(KEY_SAYI,0)
        }

        binding.textViewSayi.text = sayacDeger.toString()
        binding.increase.setOnClickListener {
            val deger = binding.textViewSayi.text.toString().toInt()
            sayacDeger = deger + 1
            binding.textViewSayi.text = sayacDeger.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SAYI,sayacDeger)
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity","onStart çağrıldı")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResume çağrıldı")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPause çağrıldı")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","onStop çağrıldı")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroy çağrıldı")
    }
}