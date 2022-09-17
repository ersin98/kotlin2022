package com.ersinyurtseven.sharedpraferenceskullanimi

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //var sharedPreferences:SharedPreferences? = null       YERİNE

    lateinit var sharedPreferences: SharedPreferences//sonra içine veri atıcam demek oluyor
    var alinanKullaniciAdi:String?=null
    var yazilanKullaniciAdi:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//isim kısımları bu şekilde olmak zorunda değil ama önerilen kullnaım şekli
        sharedPreferences= this.getSharedPreferences("com.ersinyurtseven.sharedpraferenceskullanimi",
            MODE_PRIVATE)

        alinanKullaniciAdi= sharedPreferences.getString("K.Adi","fdyjdyhj")//!! işareti ile kesin gelecek diyebiliriz ama boş gelire uygulama çöker

        if (alinanKullaniciAdi!=null)
            textView.text="Kaydedilen kullanıcı adı ${alinanKullaniciAdi}"
    }

    fun kaydet(view: View){
        yazilanKullaniciAdi= edittext.text.toString()
        if (yazilanKullaniciAdi=="")
            Toast.makeText(this, "Kullanıcı ADI gİRİN", Toast.LENGTH_LONG).show()
        else
            sharedPreferences.edit().putString("K.Adi",yazilanKullaniciAdi).apply()
            textView.text="Kaydedilen kullanıcı adı ${yazilanKullaniciAdi}"
    }
    fun sil(view: View){
        if (alinanKullaniciAdi != null)
        {
            textView.text="Kaydedilen kullanıcı adı"
            sharedPreferences.edit().remove("K.Adi")
        }
    }
}