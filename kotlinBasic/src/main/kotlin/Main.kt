import kotlin.random.Random
val console= Console()
fun main(args: Array<String>) {

                                        console.title("For")
    val items = listOf<String>("Apple", "Banana")
    items.forEach { }
    items.forEachIndexed { index,s->
        for (item in items) {
        }

        for (index in items.indices) {
            print(index)
            println(items[index])
        }
    }
    for (i in 1 .. 8 step 2){
        println("i => $i")
    }






                                        console.title("Debug")
    println("Hello World!")//soldaki kırmızı noktaları açarak Debug edebiliriz
    println("Hello World! 2")//bu kodun debug modunda çelıştırılırsa adım adım gidip nerede hata olduğunu yakalamamıza yarar.
    //sonraki adıma aşağıdaki penceren geçebiliriz.

                                         console.title("var and val")
    var counter:Int  = 10//:Int yazmasak da atadağın değerden dolayı int olduğunu anlar
    var counter2=10
    val sun= 100
    counter=3
    //val = sornadan değişmez       var= sornadan değişir

                                    console.title("Random, if else")
    val counter3= Random.nextInt(100)//Ranom.next ile 0 dan yazılan sayıya kadaralandan random sayı verir

    val result = if (counter>50)//bir değişkene de atabiliriz.
        println("50 den büyük ve değeri => $counter")//tek satır yazacaksak süslü parantez olmasa da olur
    else
        println("50 den küçük ve değeri => $counter")


                                    console.title("Random, when else")
    val value = Random.nextInt(100)

    //javadaki switch case = when

    when{
        value>50 -> println("Elliden büyük ve değeri $value")
        value>20 -> println("20 den büyük ve değeri $value")
        else -> println("20 ye eşit veya küçük ve değeri $value")
    }

    //veya doğrudan neye eşit olduğunu bulacaksak

    when(value){
        0-> println("Sıfır da neymiş insan bari 1 yapar")
        100-> println("Vur dedik öldürdün")
        else -> println("Tadında kararında bir seçim")
    }

                                     console.title("nullable ")
    var  message: String?="Hi" //soru işareti verdiğimizde null olabilir yani boş olabilir demek
    message=null
    println(message)
    //veya baştan boş verebiliriz
    var  message2:String?=null
    if (message2!=null)
        println(message2)

    //kesinlikle içi dolu demek için !! kullanılır
    var nulll: Int? =null
    if (nulll !=null)
        nulll!!.plus(2)//eğer boşken burayı çalıştırtırsak hata verir


    //boş olma ihtimali olan bir değeri boş olamaz değere atma
    var nullableValue:String?=null
    val notNullableValue:String=nullableValue ?:"Veri gelmezse diye defauld bir değer"
    println(notNullableValue)

                                        console.title("function, Extension function, infix")
    //Extension fonksiyonlar = değerin sonuna . ile yazılabilen fonksiyonlar yazılabilir
    val first =5
    println(first.sum(10)) //infix siz
    println(first sum 10)
    println(first sum ( 10))
    printMessage()
    printMessage(getMessage(5))
    printMessages("mesaj","mesaj2")//istediğimiz kadar yazabiliriz
    var name = "-Ersin1-"
    println(name.substring(1,name.length-1))


                                console.title("Array and .contentToString()")
    var fruits = arrayOf("Muz", "Elma","Çilek","Portakal")
    println(fruits.size)
    println(fruits[1])
    println(fruits.get(2))
    println(fruits.contentToString())
    fruits[0] = "Ayva"
    println(fruits.contentToString())

                                console.title("list")
    val numbers: List<Int> = listOf<Int>(0, 3, 4, 5, 7)
    numbers.contentToString()
    numbers.last()
    numbers.first()
    println( numbers.indexOf(3))//index numarasını verir

                                            console.title("map")

        val colors = mapOf("black" to "#000000", "white" to "#FFFFFF")
    println(colors["black"])
        val map= mapOf(1 to 6666,2 to "yazı","üç" to 5)//veri türleri farklı da olabilir
    map.forEach { key, value ->
        println("key ==> $key ,  value ==>$value")
    }
                                            console.title("hashmap")//sonradan değiştirilebilir
    val colorsH = hashMapOf<String,String>("black" to "#000000")
    colorsH.set("white","#FFFFFF")

                                            console.title("class")
    var person = Person("Ali Veli")
    person.bos()

}

fun printMessage(message:String ="boş geldi"){//defaul değer verebiliriz
    println("=> $message <=")
}
fun getMessage(birsayi:Int,):String{//geri değer de döndürebilir
    return "Gönderilen sayı ${birsayi-1} olmalıydı"
}
fun getMessage(birsayi:Int,dahaFazlaParametreAlabilir:String):String{//override da yapabiliriz
    return "Gönderilen sayı ${birsayi-1} olmalıydı"
}
fun printMessages(vararg messages:String) {//bir dizi de gönderebiliriz

                                console.title("forEach and forEachIndexed  in function")
    messages.forEach {message->//otomatik olarak it vardır ancak bu şekilde isimlendirebiliriz
        println("=> $message <=")//
    }
    messages.forEachIndexed{index,message->//index de yazdırabiliriz
        println("${index+1}. $message")//
    }
}
fun List<Int>.contentToString() {
    this.forEach {
        println("eleman => $it")
    }
}

infix fun Int.sum(other: Int) = this + other//başındaki innfix başka bir yazım şeklinin kilidini açar

class Console{
    fun title(title:String){
        println("///////////////////////////////////////////////////${title.uppercase()}///////////////////////////////////////////")
    }
    fun explanation(explanation:String){
        println(explanation)
    }
}

class Person(val name: String){
    init {//Constructor ile gelen değişkeni kullanabilir
        val _name =name
        println("naber $name")
        //her sınıf new lendiğinde bura çalışır
    }
    fun printtttt(){
        println("naber $name")
    }
    fun bos(){

    }

}

//
abstract class Personn{
    fun live(){
        println("Person living")
    }
    abstract fun displayName()
}
class MathTeacher(name: String): Personn() {//inheritance yazım kalıbı
    override fun displayName() {
    }
}

