import com.sun.jmx.mbeanserver.SunJmxMBeanServer

/**
모든 클래스는 Any 클래스의 서브 클래스

함수, 클래스는, function, property 는 기본값이 final 임

override 가 되어 있다면 그 친구를 상속할 때는 굳이 open 하지 않아도 됨
 */

//open하지 않으면 상속되지 않는
open class Shape {
    var x: Int = 0
        set(value) {
            if (value < 0) field = 0 else field = value
        }

    var y: Int = 0
        set(value) {
            if (value < 0) field = 0 else field = value
        }

    lateinit var name: String

    //open 하지 않으면 아래서 override 되지 않는다.
    open fun print() {
        println("$name : lacation : $x $y")
    }

    fun test(): Int {
        return 10
    }

}

class Rect : Shape() {
    override fun print() {
        super.print()
    }
}

/**
property override

상위 클래스의 프로퍼티와 이름, 타입이 모두 같아야함
상위에 val 이면 하위는 val, var 가능
상위에 var 이면 하위에 val 불가
상위 nullalble 이면 하위 null 불가
상위 not null 이면 하위 null 허용 불가
 */

open class Super {
    open val name = "kkang"
//     val name = "kkang"
}

open class Sub : Super() {
    //    override val name = "Kim"
    override val name = "Kim"
}

/**
 * 스마트 캐스팅 : 코드에서 명시적으로 캐스팅을 선언하지 않아도 자동으로 캐스팅 되는 것
 */

fun smartCast(data: Any): Int {
    return when {
    //Int 라면 그대로 리턴
        data is Int -> return data
    //데이트 타입에만 사용되지 않는다 --> 클래스라면 펑션 호출을 해도 되네
        data is Shape -> data.test()
        else -> return 0
    }
}

/**
 * as 를 이용한 캐스팅
 */

open class SuperAS {
    fun superFun() {
        println("superFun()")
    }
}

class SubAs1 : SuperAS() {
    fun subFun1() {
        println("subFun1()")
    }
}

class SubAs2 : SuperAS() {
    fun subFun2() {
        println("subFun2()")
    }
}

val asObj3: SuperAS = SubAs1()
val asObj4: SubAs1 = asObj3 as SubAs1

fun main(args: Array<String>) {
    //하위 -> 상위 -> 하위는 가능함
    asObj4.superFun()
    asObj4.subFun1()

    //앞을 빼먹고 상위 -> 하위는 안됨
    val asObj5 = SuperAS()
//    val asObj6 : SubAs1 = asObj5 //이렇게는 안됨

    var pTest = propertyVisiblity()
    println(pTest.data)
//    data = 10
/*

    var sub11 = Sub()
    var super11 = Super()

    if( sub11 is Sub) println("sub11  is Sub()") else {println("sub11  is not Sub()")}
    if( sub11 is Super) println("sub11  is Super()")else {println("sub11  is not Super()")}
    if( sub11 is Any) println("sub11  is Any()")else {println("sub11  is not Any()")}
*/
    println("스마트 캐스트 더블 ? ${smartCast(10.0)}")
//
//
//    var asdf = propertyVisiblity()
//    asdf.

}

/**
 * null 허용 객체의 캐스팅
 */

val obj7 : SuperAS? = null
//런타임 에러 발
//val obj8 : SubAs1 = obj7 as SubAs1
//as 를 as? 로 변경해야하고
//그러면 SubAs1 도 null 허용으로 변경해야함
val obj9 : SubAs1? = obj7 as? SubAs1

/**
 * 접근 제한자 : 클래스 , 인터페이서, 생성자, 함수, 프로퍼티 선언부에 추가 가능함
 * public, internal, protected, private 4가지를 사용함
 *
 * public > internal/protected > private
//1. 최상위 구성요소의 접근 범위
    public : 어느 곳에서나
    private : 같은 파일 내에서
    internal : 같은 모듈 내에서 ( 인텔리j모듈, 메이븐 프로젝트 단, 그레이들 프로젝트 단위)
    protected : X --> 최상위에서 사용불가

 //2. 클래스 멤버의 접근 범위
    public : 어느 곳에서나
    private : 같은 클래스 내에서
    internal : 같은 모듈 내 클래스에서
    protected : private + 서브 클래스 (상속)


 */

//3. 프로퍼티와 접근 제한자
class propertyVisiblity {
//     var data: Int = 10
     var data: Int = 10
        get() = field
        private set(value) {
            field = value
        }
}

class asdfasdf {

}
