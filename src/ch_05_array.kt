import Util.gogo

fun main(args: Array<String>) {
    /**
        5.2 컬렉션 타입
        5.2.1 배열
     */
    //1. array 를 만드는 가장 간단한 방법 : arrayOf or arrayOf<T> 사용
    var array = arrayOf("test", 0, true)
            .forEach { println(it) }
    //2. xxxArrayOf를 사용
        //booleanArrayOf
        //byteArrayOf 등

    //3. Array 클래스를 직접 이용
    gogo("array3")
    var array3 = Array(3, {it*10}).forEach { println(it) }
    var array3_1 = Array(3) {it}.forEach { println(it) }

    fun arrayInput(input : Int) : String {
        return input.toString()
    }

    gogo("array3_2")
    var array3_2 = Array(3) {arrayInput(it)}.forEach { println(it) }


    //4. 배열을 정의할 때 크기만 지정하고 데이터는 대입하지 않는 빈 상태로 정의
    var array4 = arrayOfNulls<Any>(5)

    var array5 = Array<String>(5, {""})

    /**
     * 5.2.2. List, Set, Map
      • Collection 타입의 클래스들은 mutable 클래스와 immutable 클래스로 구분
      • kotlin.collection.List 인터페이스로 표현되는 객체는 immutable 이며 size(), get() 함수만 제공
      • kotlin.collection.MutableList 인터페이스로 표현되는 객체는 mutable 이며 size(), get() 함수 이외에
         add(), set() 함수 제공
     *
     * */


    val immutableList: List<String> = listOf("hello", "world")
//    immutableList.add() //안됨
    gogo("immutableList", immutableList)

    val mutableList: MutableList<String> = mutableListOf("hello", "world")
    mutableList.add("kkang")
    mutableList.set(1, "korea")
    gogo("mutableList",mutableList)

    val immutableMap1= mapOf<String, String>(Pair("A", "001"), Pair("B", "002"))
    gogo("immutableMap1",immutableMap1)

    val mutableMap2= mutableMapOf<String, String>(Pair("A", "001"), Pair("B", "002"))
    mutableMap2.put("C","003")
    gogo("mutableMap2",mutableMap2)

    /**
     * 5.2.3 Iterator
     * */
    val list1= listOf<String>("hello","list")
    val iterator1=list1.iterator()
    while (iterator1.hasNext()){
        println(iterator1.next()) }
}