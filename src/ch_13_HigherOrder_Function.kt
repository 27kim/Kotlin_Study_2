/**
 * 고차 함수란?
 * 매개변수로 함수를 전달 받거나 함수를 반환하는 함수
 * */

fun hoFun(x1: Int, argFun: (Int) -> Int) {
    val result = argFun(10)
    println("x1 : $x1, someFun1 : $result")
}

fun hoFunTest(x1: Int, funArgs: (Int) -> Int): Int {
    return x1 + funArgs(5)
}

fun hoFunTest(funArgs: (Int) -> Int): Int {
    return funArgs(5)
}

fun main(args: Array<String>) {
    var testFun = { x: Int -> x * 10 }
    ln("시작")
    println(hoFunTest(10, testFun))
    ln("교재 테스트")

    /**
     * 고차 함수의 매개변수가 한 개일 경우 괄호 생략 가능
     * */
    hoFunTest({ x -> x * x })
    hoFunTest { x -> x * x }

    /**
     * 함수 타입의 매개변수를 여러 개 선언할 때도 () 생략 가능하지만,
     * () 밖에 작성할 수 있는 함수 타입은 맨 마지막 인수만 가능
     * */


    /**
     * 함수 타입 기본 값 이용
     * */

    fun hoFun2(
            x1: Int,
            argFun1: (Int) -> Int,
            argFun2: (Int) -> Boolean = { x -> x > 10 }
    ) {
        var result = argFun1(10)

    }

    hoFun2(10, { x -> x * 10 }, { x: Int -> x > 5 })
    hoFun2(10, { it * 10 }, { it == 1 })

    /**
     * 고차 함수와 함수 반환
     * */

    fun hoFun5(x: String): (x1: Int, x2: Int) -> Int {
        when (x) {
            "+" -> return { x1, x2 -> x1 + x2 }
            "-" -> return { x1, x2 -> x1 - x2 }
            "*" -> return { x1, x2 -> x1 * x2 }
            else -> return { x1, x2 -> x1 / x2 }
        }
    }

    var aass = hoFun5("*")
    ln("고차 함수와 함수 반환")
    println(aass(5, 5))

    /**
     * 함수 참조와 익명 함수 이용
     * */

    fun hoFun6(argsFun: (x: Int) -> Int) {
        println("${argsFun(10)}")
    }
    ln("함수 참조를 이용한 함수 전달")
    hoFun6 { it + 5 }

    var input = { x: Int -> x + 7 }

    fun input2(x: Int): Int {
        return x + 10
    }

    /////////////람다로 전달하면 안되는건가보네? 이건 잘 모르겠다.
//    hoFun6(::input)
    hoFun6(::input2)

    /**
     * 익명 함수를 이용한 함수 전달
     **/

    /**
     * 코틀린 api 의 유용한 고차 함수
     *
     * 1. run()
     *  - 람다 함수를 실행하고 그 결과값을 얻는 목적
     *  - 객체의 멤버에 접근하기 위해
     * */

    class User() {
        var name = ""
        var age = 0
        fun sayHi() {
            println("hi")
        }

        fun sayInfo() {
            println("i am $name $age old")
        }
    }

    ln("run 테스트 1")
    var user = User()
    user.age = 4
    user.name = "jane"
    user.sayHi()
    user.sayInfo()

    ln("run 테스트 2")

    println(user.run {
        age = 1
        name = "jiho"
        sayHi()
        sayInfo()
        "hahaha"
    })

    /**
     * 2. apply()
     *  - 함수를 적용한 객체를 반환
     *  - user 와 user2 는 이름만 다르지 같은 객체!!!!!
     * */
    ln("apply 테스트")
    val user2 = user.apply {
        name = "park"
        age = 7
        sayHi()
        sayInfo()
    }
    println(" user name : ${user.name} / user2 name : ${user2.name}")
    user.name = "123"
    user2.name = "345"
    println(" user name : ${user.name} / user2 name : ${user2.name}")

    /**
     * 3. let()
     *  - 자신을 호출한 객체를 람다 함수에 매개 변수로 전달하는 함수
    * */
    ln("let 테스트")
    fun letTestFun(user : User){
        println("letTestFun : ${user.name} / ${user.age}")
    }
    user2.let{
        letTestFun(it)
    }


    var num = 10
    num.let(input)
//    user2.run { letTestFun(it) }
//    user2.apply { letTestFun(it) }

    /**
     * 4. with()
     *  - run 과 유사.
     *  - 한 객체의 멤버에 반복 접근할 때 일일이 명시하지 않고 바로 접근하려는 용도
     *  - run 은 자신을 호출한 객체를 이용하지만 with 는 매개변수로 지정한 객체를 이용
     * */
    ln("user 테스트 ")
    with(user){
        println("$name")
        sayInfo()
        name = "with 로 이름 바꿈"
        sayInfo()
    }
}