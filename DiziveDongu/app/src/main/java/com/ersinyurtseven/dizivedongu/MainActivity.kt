package com.ersinyurtseven.dizivedongu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // set of ile dizi oluştururken tekrara düşmeyiz

        println("------------------array-----------------")
        val exemple = 3
        val setarray =
            setOf<Any>("srfgs", exemple, 3)//set dedimmi aynı verinin tekrarını engellersin
        setarray.forEach {
            println(it)
        }
        println("-------------------------heşsetli-----------")
        var hessetli = HashSet<Int>()
        hessetli.add(3)
        hessetli.add(8)
        hessetli.add(3)
        hessetli.forEach {
            println(it)
        }
        println("-------------------------heşsetli bitiş-----------")
        val array = arrayListOf<Any>(3, 4, 3, 4, 34, 33, 3, "dhger")
        println(array[0])
        array.forEach {
            println(it)
        }
        println("-------------------------map-----------")
        //anahtar kelime -değer  ( yani key value pariring işleşmesi)
        //mapsiz yapmaya kalksak
        val yemek = arrayOf("Elma", "Tavuk", "Sucuk")
        val kalori = arrayOf(330, 233, 234)
        println("${yemek[0]} yemeğinin kalorisi ${kalori[0]}")

        val maplamaca = hashMapOf<String, Int>()
        maplamaca.put("Elma", 654)
        println(maplamaca.get("Elma"))

        val ofsuzmaplamaca = HashMap<String, String>()
        ofsuzmaplamaca.put("Elma", "Armut")

        val yaparkenkoymaca = hashMapOf<String, Int>("Elma" to 8, "Armut" to 9)

        println("-------------------matematiksel işlemler-----------")
        //bunda bilmediğim şu var
        println(10 % 2)//kalanı bulur
        println("--------------When--------------------")
        var notrakami = 2
        var notstring = " "
        when (notrakami) {
            0 -> notstring = "Geçersiz"
            1 -> notstring = "Zayıf"
            2 -> notstring = "Kötü"
            3 -> notstring = "Aferim"
            else -> notstring = "Kopya mı çektin"
        }
        println(notstring)

        println("-----------------for-----------------")

        //benim bildiğim for
        var birdizi = arrayListOf<String>("Bir", "Dizi", "Örneği")
        for (i in birdizi) {
            println(i)//burda dizinin ilemanları yazar
        }
        for (i in birdizi.indices) {
            println(i)//dizideki elemanın indeks numarası yazar
            println(birdizi[i])
        }
        birdizi.forEach() {// dizi ve for o kadar birlikte kullanılıyor ki bu yazım çıkmış. bir tık daha kolay
            println(it)
        }
    }
}