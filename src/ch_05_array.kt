fun main(args: Array<String>) {
    //1. array 를 만드는 가장 간단한 방법 : arrayOf or arrayOf<T> 사용
    divider()
    var array = arrayOf("test", 0, true)
            .forEach { println(it) }
    //2. xxxArrayOf를 사용
        //booleanArrayOf
        //byteArrayOf 등

    //3. Array 클래스를 직접 이용
    divider()
    var array3 = Array(3, {it*10}).forEach { println(it) }

    //4. 배열을 정의할 때 크기만 지정하고 데이터는 대입하지 않는 빈 상태로 정의
    var array4 = arrayOfNulls<Any>(5)

    var array5 = Array<String>(5, {""})

}

fun divider(){
    println("====================================")
}