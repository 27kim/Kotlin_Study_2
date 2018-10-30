import java.util.Arrays.asList
import kotlin.coroutines.experimental.coroutineContext

fun main(args: Array<String>) {
    var sum = 0

    for (i in 1..10) {
        sum += i
    }
    println("sum ? $sum")

    //1. collection type
    var list = listOf(1, 2, 3, 4, 5)

    for (input in list) {
        println(input)
    }

    //list.forEach(println(it))
    list.forEach{ println(it)}
    list.forEach({ println(it) })
    list.forEach({ a -> println(a) })

    //2. collection type 의 index 사용
    for (idx in list.indices) {
        println("using indices ${list[idx]}")
    }

    //3. collection type 의 withIndex 사용 - key, value
    for ((idx, value) in list.withIndex()) {
        println("using withIndex $idx , $value")
    }

    //4. for 조건문
    for (i in 0..10) {
        println("i in 0..10 : $i")
    }
    for (i in  0 until 10) {
        println("i in 0..10 : $i")
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


    //label 확인하기
    println("without break")
    for(i in 1..3){
        for(j in 1..3){
            //if (j>1) break
            println("i : $i , j : $j")
        }
    }
    println("with break")
    for(i in 1..3){
        for(j in 1..3){
            if (j>1) break
            println("i : $i , j : $j")
        }
    }
    println("with break using label")
    aa@for(i in 1..3){
        for(j in 1..3){
            if (j>1) break@aa
            println("i : $i , j : $j")
        }
    }

    //전개연산자
    //* 사용함
    var lista = arrayOf(5,6,7,8)
    var list2 = asList(1,2, *lista)
    var ta = arrayOf(*lista)
    list2.forEach { println(it) }
}
