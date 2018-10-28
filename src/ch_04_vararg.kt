
//param을 type 을 T 로 설정하여 모든 타입이 들어감
fun <T> varargsFun(vararg array: T){
    for(a in array) println("a in array : $a")
}

//param type 을 String 으로 설정함
fun <T> varargsFun(vararg array: String){
    for(a in array) println("a in array : $a")
}

//param type 을 String 으로 설정했기 때문에 <T> 생략 가능함
fun varargsFun1(vararg array : String){
    for(a in array) println("a in array : $a")
}

fun main(args: Array<String>) {

    varargsFun(10, "test", 1, true, "***")
    varargsFun<String>("","","","","")

}