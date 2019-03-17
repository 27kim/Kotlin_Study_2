import java.util.Arrays.asList
import kotlin.coroutines.experimental.coroutineContext

fun main(args: Array<String>) {
    /**
     * 6.2 반복문
     * 6.2.1 for 반복문 in, indices
     * */
    var sum = 0

    for (i in 1..10) {
        sum += i
    }
    println("sum ? $sum")

    /**
     * for 조건문
     * */
    //4. for 조건문
    for (i in 0..10) {
        println("i in 0..10 : $i")
    }
    for (i in 0 until 10) {
        println("i in  0 until 10 : $i")
    }
    for (i in 0..10 step 2) {
        println("i in 0..10 step 2 : $i")
    }
    //이건 안찍힘
    for (i in 10..1 step 2) {
        println("i in 10..1 step 2 step 2 : $i")
    }
    for (i in 10 downTo 0) {
        println("i in 10 downTo 0 : $i")
    }

    //1. collection type
    var list = listOf(1, 2, 3, 4, 5)

    for (input in list) {
        println(input)
    }

    //list.forEach(println(it))
    list.forEach { println(it) }
    list.forEach({ println(it) })
    list.forEach({ a -> println(a) })

    /**
     * collection index만 사용
     * */
    for (idx in list.indices) {
        println("using indices ${list[idx]}")
    }

    /**
     * collection type 의 index와 데이터 함께
     * */
    for ((idx, value) in list.withIndex()) {
        println("using withIndex $idx , $value")
    }


    //label 확인하기
    println("without break")
    for (i in 1..3) {
        for (j in 1..3) {
            //if (j>1) break
            println("i : $i , j : $j")
        }
    }
    println("with break")
    for (i in 1..3) {
        for (j in 1..3) {
            if (j > 1) break
            println("i : $i , j : $j")
        }
    }
    println("with break using label")
    aa@ for (i in 1..3) {
        for (j in 1..3) {
            if (j > 1) break@aa
            println("i : $i , j : $j")
        }
    }

    /**
     * 전개연산자 (spread operator)
     *  배열의 값을 나열할 때 사용 함
     * */
    var listA = arrayOf(5, 6, 7, 8)
    var list2 = asList(1, 2, *listA)
    var ta = arrayOf(*listA)
    list2.forEach { println(it) }
    //직접 정의한 함수에도 사용 가능
    fun some(vararg a: String) {
        val iterator = a.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }

    val array3 = arrayOf<String>("hello", "world")
    some(*array3)


    /**
     * 삼항 연산자를 제공하지 않는다
     * */
}
