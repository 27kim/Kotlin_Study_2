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
    ln("함수 참조를 이용한 함수 전달 1")
    hoFun6 { it + 5 }

    var input = { x: Int -> x + 10 }

    fun input2(x: Int): Int {
        return x + 10
    }

    /////////////람다로 전달하면 안되는건가보네? 이건 잘 모르겠다.
//    hoFun6(::input)
    ln("함수 참조를 이용한 함수 전달 2 - 람다를 바로 전달하는 것은 안됨")
    hoFun6(::input2)

    /**
     * 익명 함수를 이용한 함수 전달
     * 익명 함수란 ? 일반 함수와 동일한데 이름만 없다 @.@
     * 그냥 함수를 선언한 상태에서 함수 이름만 지우면 익명함수가 된다고 생각하면 되겠음.
     * 익명 함수를 이용하면 return 을 사용할 수 있고 --> 리턴 타입 지정이 가능하다
     * 익명함수도 람다 함수처럼 함수명이 없으므로 고차 함수의 매개변수나 반환 값으로 이용되며,
     * 주로 반환을 명시적으로 선언하려고 할 때 이용 됨
     **/
    ln("""
        /**
     * 익명 함수를 이용한 함수 전달
     * 익명 함수란 ? 일반 함수와 동일한데 이름만 없다 @.@
     * 그냥 함수를 선언한 상태에서 함수 이름만 지우면 익명함수가 된다고 생각하면 되겠음.
     * 익명 함수를 이용하면 return 을 사용할 수 있고 --> 리턴 타입 지정이 가능하다
     * 익명함수도 람다 함수처럼 함수명이 없으므로 고차 함수의 매개변수나 반환 값으로 이용되며,
     * 주로 반환을 명시적으로 선언하려고 할 때 이용 됨
     **/

    """.prependIndent("******"))
    fun anonymousFun(): Int {
        return 10
    }

    fun(): Int {
        return 10
    }

    /**
     * 코틀린 api 의 유용한 고차 함수
     *
     * 1. run()
     *  - 람다 함수를 실행하고 그 결과값을 얻는 목적
     *  - 객체의 멤버에 접근하기 위해
     * */

    ln("""    /**
     * 코틀린 api 의 유용한 고차 함수
     *
     * 1. run()
     *  - 람다 함수를 실행하고 그 결과값을 얻는 목적
     *  - 객체의 멤버에 접근하기 위해
     * */""".prependIndent("******"))
    class User() {
        constructor(name : String, age : Int) : this(){
            this.name = name
            this.age = age
        }
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

    user.run { println("2번 째 테스트 $age / $name ") }


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
     *  - 함수를 적용한 객체를 반환 (run 과 리턴값이 다르다)
     *  - 객체의 멤버에 접근하기 위해 사용한다.
     *  - user 와 user2 는 이름만 다르지 같은 객체!!!!!
     * */
    ln("""    /**
     * 2. apply()
     *  - 함수를 적용한 객체를 반환
     *  - user 와 user2 는 이름만 다르지 같은 객체!!!!!
     * */""".prependIndent("******"))
    ln("apply 테스트")
    val user2 = user.apply {
        name = "park"
        age = 7
        sayHi()
        sayInfo()
    }
    println("**user와 user2 는 동일한 객체라고 함 @.@" +
            " user name : ${user.name} / user2 name : ${user2.name}")
    user.name = "123"
    user2.name = "345"
    println(" user name : ${user.name} / user2 name : ${user2.name}")

    /**
     * 3. let()
     *  - 자신을 호출한 객체를 람다 함수에 매개 변수로 전달하는 함수
     * */
    ln("""    /**
     * 3. let()
     *  - 자신을 호출한 객체를 람다 함수에 매개 변수로 전달하는 함수
     * */""".prependIndent("******"))
    ln("let 테스트")
    fun letTestFun(user: User) {
        println("letTestFun : ${user.name} / ${user.age}")
    }
    user2.let {
        letTestFun(it)
    }
    ln("let 테스트 2 - 와 이거 엄청 헷갈리네")
    ln("이제 알았다. run , apply, with 는 객체의 멤버에 접근하기 위해 / let 은 객체 자체를 넘기기 위해 ")
    User("let 이름", 4).let{
        println(it.name)
        println(it.age)

//        var test = it
//        letTestFun(it)
    }
    User("let 이름", 4).run{
        println(name)
        println(age)

//        var test = it
//        letTestFun(it)
    }
    User("let 이름", 4).apply{
//        println(it) // 이건 안되는구나
        println(name)
        println(age)

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
    with(user) {
        println("$name")
        sayInfo()
        name = "with 로 이름 바꿈"
        sayInfo()
    }

    /**
     * 인라인 함수
     * 고차 함수에 람다 함수를 전달하면
     * 람다를 이용하는 코드가 많아져 런타임 때 성능 문제가 발생할 수 있.
     *
     * 고차함수를 매개변수로 받는 함수 선언 시 inline 을 추가한다면,
     * 고차함수를 호출한 곳에 정적으로 포함 되기 런타임 대 함수 호출이 그만큼 줄고 성능에 도움이 됨
     *
     * 만약에 고차 함수가
     *   여러개의 함수를 매개 변수로 받고,
     *   그 중 인라인 시키지 않고 싶은게 있다면,
     *   그건 noinline 으로 지정을 할 수 있다
     * */
    ln("""
          * 인라인 함수
     * 고차 함수에 람다 함수를 전달하면
     * 람다를 이용하는 코드가 많아져 런타임 때 성능 문제가 발생할 수 있.
     *
     * 고차함수를 매개변수로 받는 함수 선언 시 inline 을 추가한다면,
     * 고차함수를 호출한 곳에 정적으로 포함 되기 런타임 대 함수 호출이 그만큼 줄고 성능에 도움이 됨

          * 만약에 고차 함수가
     *   여러개의 함수를 매개 변수로 받고,
     *   그 중 인라인 시키지 않고 싶은게 있다면,
     *   그건 noinline 으로 지정을 할 수 있다
    """.prependIndent("******"))

    fun inlineTest(args : (Int) -> Int) : Int{

        return args(10)
    }

    var inlineVar = inlineTest(input)

    /**
     * 논로컬 반환이란?
     *
     * 람다 함수 내에서 람다 함수를 포함하는 함수를 벗허나게 하는 기법
     *  코틀린에서는 이림이 정의된 일반함수, 익명함수에서만 쓸 수 있다.
     *
     *  람다에서 return 하려면 inline 으로 만들어야 한다
     *
     *  하지만 inline 으로 만들었다고 해도 인라인 함수를 다른 객체에 대입한다면 return 을 할 수 없게 된다
     *
     *  컴파일 오류가 발생하기 때문에 return 을 아예 하지 못하게
     *  crossinline 을 붙여주면 되는데
     *  crossinline 은 함수가 inline 으로 선언되었다고 하더라도
     *  대입되는 람다함수에 return 이 사용되지 않게 하기 위한 예약어
     */

    ln("""    /**
     * 논로컬 반환이란?
     *
     * 람다 함수 내에서 람다 함수를 포함하는 함수를 벗허나게 하는 기법
     *  코틀린에서는 이림이 정의된 일반함수, 익명함수에서만 쓸 수 있다.
     *
     *  람다에서 return 하려면 inline 으로 만들어야 한다
     *
     *  하지만 inline 으로 만들었다고 해도 인라인 함수를 다른 객체에 대입한다면 return 을 할 수 없게 된다
     *
     *  컴파일 오류가 발생하기 때문에 return 을 아예 하지 못하게
     *  crossinline 을 붙여주면 되는데
     *  crossinline 은 함수가 inline 으로 선언되었다고 하더라도
     *  대입되는 람다함수에 return 이 사용되지 않게 하기 위한 예약어
     */""".prependIndent("******"))

    /**
     *  클로저란?
     *  함수가 호출될 때 발생하는 데이터를 함수 호출 후에도 그대로 유지해 이용하는 기법
     *  함수 내에 선언된 데이터를 함수 종료 후에도 사용할 수 있게 바인딩 해주는 기법을 통칭
     *  지역변수가 함수 종료 후에도 유지되는 것은 내부적으로 이 변수까지 포함해 람다 함수를 반환하기 때문
     */
    ln("클로저 1 ")
    fun closureTest(x : Int) : (Int) -> Int {
        println("x : ? $x")
        return {it * 10}
    }

    val closureFun1 = closureTest(2)
    val closureFun2 = closureTest(3)

    println(closureFun1(10))
    println(closureFun2(10))

    ln("클로저")
    fun closureTest2(x : Int) : (Int) -> Int {
        println("x : ? $x")
        return {it * x}
    }

    val closureFun3 = closureTest2(2)
    val closureFun4 = closureTest2(3)

    println(closureFun3(10))
    println(closureFun4(10))
}

inline fun inlineTest2(args : (Int) -> Int, noinline args2 : (Int) -> Int) : Int{

    return args(10)
}