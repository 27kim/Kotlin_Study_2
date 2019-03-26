/**
코틀린에서는 클래스의 변수를 property라고 부릅니다.

변수처럼 보이지만 함수가 내장된 변수이기 때문 - getter, setter
 **/

class User {
    var name: String = "하하하"
        get() = field + " - get 할 때 추가"
        //set 할 때에는 = 이 안들어가고 바로 중괄호 {}
//        set(param) { field + param} //만 하면 값이 set 되지 않음
        set(param) {
            field = field + param
        }
    var age: Int = 10
        set(value) {
            if (value > 0) field = value else field = 0
        }

    var testStr = ""
    get() = field.toUpperCase()
//    set(value) {
//        field = value + field
//    }


}

fun main(args: Array<String>) {
    println("testStr=================")
    var user1_1 = User()
    user1_1.testStr = "jane"
    println(user1_1.testStr)
    user1_1.testStr = "jiho"
    println(user1_1.testStr)

    println("property=================")
    var obj = User()
    println("${obj.name}")

    obj.name = "-set 으로 추가"
    println("${obj.name}")

    obj.age = -10
    println(obj.age)


    println("ByLazyTest=================")
    var lazyTest = ByLazyTest()
    println("ByLazyTest 이름 사용 전")
    println(lazyTest.name)
    println("ByLazyTest 이름 사용 후")
//
//    println("ByLazyTest 나이 사용 전")
//    println(lazyTest.age)
//    println("ByLazyTest 나이 사용 후")
}

/**
프로퍼티 초기화
 **/

class User2{
    var data : String //property는 선언과 동시에 초기화를 해야하지만 init 통해 초기화를미룰 수 있다.

    init{
        data = "kim"
    }
}

/**
lateinit : 일단 선언하고 이후에 초기화 한다
 var 만 가능
 주생성자에 사용 불가
 null 허용 불가
 기초타입 사용 불가
 **/
lateinit var data1 : String //안된다더니 되네?

class LateInitTest{
//    lateinit val data2 : String //val 안됨
//    lateinit var data3 : String? //null 안됨
//    lateinit var data4 : Int //primitive type 안됨

}

/**
by lazy : 일단 선언하고 초기화도 만들어 놨지만 실제 초기화 되는 시점을 호출되는 시점으로 미룬다
호출 시점에 초기화 진행
일종의 실행 영역 -> {} 로 만들어야 함
 val만 가능
 클래스 몸체 이외에 최상위 레벨에서도 가능
 기초타입 사용 가능
 **/

val someData : String by lazy{
    println("someData lazy")
    "hello"
}

class ByLazyTest{
//    val name : String by lazy = "name" //요렇게는 사용 못함

    val name : String by lazy{
        println("ByLazyTest property 안 : lazy name")
        "kim"
    }

    val age : Int by lazy{
        println("lazy age")
        4
    }

    init{
        println("ByLazyTest 여기는 초기화 블럭")
    }

    constructor(){
        println("ByLazyTest 여기는 생성자")
    }
}

/**
 * 생성자에 var val 로 선언한 변수에 get(), set() 가능?
 * */

class ValVarTest_1(var input : String){
//    input.set
    var input_1 = input
        get() = field.toUpperCase()
        set(value) {field = "set 에서 추가함" + value}

}

class ValVarTest_2(input : String){
    //    input.set
    var input = input
        get() = field.toUpperCase()
        set(value) {field = "set 에서 추가함" + value}

}