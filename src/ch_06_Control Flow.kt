import kotlin.coroutines.experimental.coroutineContext

fun main(args: Array<String>) {
    val a = 15
    //if 문은 표현식.
    //표현식으로 사용할 때는 반드시 else가 들어가야 함
    var result = if (a > 10) "bigger than 10" else "less than 10"
    println(result)


    //중괄호 안에 여러 줄을 작성할 수 있지만 return 은 항상 마지막 줄
    var result2 = if (a > 10) {
        println("a ? $a")
        "마지막 줄 bigger than 10"
    } else {
        println("a ? $a")
        "마지막 줄 less than 10"
    }
    println(result2)

    //표현식이란, 변수, 상수, 연산자, 함수로 구성되어 무언가 값을 만드는 문장
    //1. 대입 연산자 = 의 오른쪽에 위치
    //2. 함수의 param으로 사용 가능하다.

    val count = 10
    val a1 = if (count > 5) "true" else "false"
    some(a1)
    some(if (count > 5) "true" else "false")

    //when 표현식

    //1. 정수로 분기
    val a2 = 1

    //아래처럼 when사용 가능
    println("${when (a2) {
        1 -> "1"
        2 -> "2"
        else -> "none of them"
    }
    }"
    )
    //2. 정수 이외의 값으로 분기
    val a3 = "test"

    when (a3) {
        "test" -> println("test ? $a3")
        "test1" -> println("test1 ? $a3")
        "test2" -> println("test2 ? $a3")
    }

    //3. 여러 값으로 분기
    val a4 = 10

    when (a4) {
        10, 30 -> println("test a4? $a4")
        100, 300 -> println("test a4? $a4")
        10, 2342 -> println("test a4? $a4")
        30 + 30 -> println("test a4? $a4")

    }

    //4. 범위 값으로 분기
    val a5 = 10

    when (a5) {
        in 10..30 -> println("test a5? $a5")
        in 100.. 300 -> println("test a5? $a5")
    }

    //5. 여려 타입으로 분기
    var a6 : Any = "test value"

    when(a6){
        is Boolean -> "bool"
        in 10..30 -> ""
        is String -> "String"
    }

    //6. if else 대체용으로 사용
    var a7 = 10
    when{
        a7 in 1..10 -> ""
        a7 in 11..20 -> ""
    }
    //표현식으로 사용할 때는 else 가 필요함
    println("${when{
        a7 in 1..10 -> ""
        a7 in 11..20 -> ""
        else -> "else"
    }}")
}

fun some(input: String) {
    println("some funtion 의 input ? $input")
}
