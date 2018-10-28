fun main(args: Array<String>) {
    val myVal1 : Any = 10
    val myVal2 : Any? = myVal1

    val myVal3 : Any? = 10
    //as 가 없으면 컴파일 안됨
   val myVal4 : Any = myVal3 as Any
}

fun getStringLength(obj : Any) : Int? {
    val stData : String = obj as String //as 없으면 컴파일 안됨

    if(obj is String){
        return obj.length
    }
    return null
}