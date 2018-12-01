import ln

fun main(args: Array<String>) {
    data class User(val name: String, val age: Int)

    var list = arrayListOf("1", "2", "3", "4", "5")
    var list2 = listOf(User("jane", 4), User("jiho", 1))


    /**
     * 1. forEach, forEachIndexed*
     * */

    ln("forEach")
    list.filter { it >= "3" }
            .forEach { println(it) }
    ln("forEachIndexed")
    list.forEachIndexed { index, value -> println("index : $index value : $value") }

    /**
     * all, any
     * all : 조건을 모두 만족하는지?
     * any : 하나라도 조건을 만족하는지
     * */
    ln("all")
    println("list.all { it >= \"1\" } ?  ${list.all { it >= "1" }}")

    ln("all 2 ")
    println("list2.all { it.age >= 1 } ?  ${list2.all { it.age >= 1 }}")

    ln("any")
    println("list2.any { it.name.contains(\"x\") } ?  ${list2.any { it.name.contains("x") }}")


    /**
     * count : 조건을 만족하는 개수 반환
     * find : 조건을 만족하는 가장 첫 번째 데이터를 반환
     * */
    ln("count")
    println("list2.count { it.name == \"jane\" } ${list2.count { it.name == "jane" }}")
    println("list2.count { it.age >= 1  } ${list2.count { it.age >= 1 }}")

    ln("find")
    println("list2.find { it.name == \"jane\" } ${list2.find { it.name == "jane" }}")
    println("list2.find { it.age == 1  } ${list2.find { it.age == 1 }}")

    /**
     * reduce()
     * reduceRight()
     * fold()
     * fordRight()
     * */

//    var result = listOf(1,2).fold(10,{sum : Int, input : Int -> sum = sum + input})
    ln("fold")
    var result = listOf(1, 2).fold(10, { sum, input ->
        println("sum : $sum , input : $input")
        sum + input
    })
    println("result : $result")

    ln("foldRight - sum , input 반대")
    var result2 = listOf(1, 2).foldRight(10, { input, sum ->
        println("sum : $sum , input : $input")
        sum + input
    })
    println("result : $result2")

    ln("reduce()")
    println(listOf(1, 2, 3).reduce { sum, input ->
        println("sum : $sum , input : $input")
        sum + input
    })
    ln("reduceRight() - sum, input 반대")
    println(listOf(1, 2, 3).reduceRight { input, sum ->
        println("sum : $sum , input : $input")
        sum + input
    })

    /**
     * max() : 최대값
     * maxBy() : 조건에 맞는 최대값
     * min() : 최소값
     * minBy() : 조건에 맞는 최소값
     * */

    ln("max()")
    println("listOf(1,2,3).max() ?  ${listOf(1, 2, 3).max()}")

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ln("maxBy() - 조건에 맞는 첫 번째 ? 2가 리턴 되는데?")
    /**
     * 조건 값이 true / false 이기 때문에 조건을 맞는 첫 번째 값을 리턴하고 있었네 @.@
     */
    println("listOf(1,2,3).maxBy{} ?  ${listOf(1, 2, 3).maxBy { it > 1 }}")
    println("listOf(1,11,5).maxBy{} ?  ${listOf(1, 5, 11).maxBy { it > 1 }}")
    println("listOf(1,11,5).maxBy{} ?  ${listOf(1, 11, 5).maxBy { it > 20 }}")

    listOf(1, 11, 5).map{
        it > 20
    }.forEach{println(it)}
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ln("min()")
    println("listOf(1,2,3).min() ?  ${listOf(1, 2, 3).min()}")

    ln("minBy()")
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    println("listOf(1,2,3).minBy{} ?  ${listOf(1, 2, 3).minBy { it > 2 }}")
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    var map2 = mapOf<String, Int>("one" to 10 , "two" to 5)
    map2.filter { it.value >10 }

    /**
     * none : 조건에 해당하지 않으면 true
     * sumBy : 조건으로 변경 후 더함
     * filter : 조건에 맞는 데이터만 추출
     * filterNot : 조건에 맞지 않는 데이터만 추출
     * */
    ln("none()")
    println("listOf(1,11,5).none{} ?  ${listOf(1, 11, 5).none { it % 10 == 0 }}")

    ln("sumBy()")
    println("listOf(1,11,5).sumBy{} ?  ${listOf(1, 11, 5).sumBy { it * 10 }}")

    ln("filter()")
    println("listOf(1,11,5).filter{} ?  ${listOf(1, 11, 5).filter { it > 10 }}")

    ln("filterNot()")
    println("listOf(1,11,5).filterNot{} ?  ${listOf(1, 11, 5).filterNot { it > 10 }}")
}
