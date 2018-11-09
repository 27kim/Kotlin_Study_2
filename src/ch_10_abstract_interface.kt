package ten_one_two

/**
 * 클래스에 포함된 함수 중에 추상 함수가 있으면 추상 클래스
 *
 * 1. 추상 함수? 함수 선언 부분만 있는 함수
 *
 * 클래스 내부에 선언된 함수에만 사용할 수 있다.
 *
 * 최상위 레벨에는 사용할 수 없다
 *
 * */
abstract class AbstractTest1{
    fun myFun1(){

    }

    abstract fun myFun2()
}


/**
 * 2. 추상 프로퍼티
 * 선언부만 있는 프로퍼티
 * */

abstract  class AbstractTest2{
    val data1 : String = "kkang"
    abstract val data2: String
    //val data3: String 그냥 이렇게는 안됨
}

/**
 * 추상 클래스는 객체를 생성할 수 없다.
 * 추상 클래스의 추상 함수와 프로퍼티를 모두 재정의 해야 함
 * 그렇지 않다면 하위 클래스도 abstract 키워드를 이용해 추상형으로 선언해야 함.
 * */

abstract class Super{
    val data1 : Int = 10
    abstract val data2 : Int

    fun myFun1(){

    }

    abstract fun myFun2()
}

class Sub : Super(){
    override val data2: Int = 10
    override fun myFun2() {

    }
}


/**
 * 10.2 인터페이스
 * 인터페이스 : 추상 함수를 선언하는 것이 주목적
 * is a / has a
 * 인터페이스는 객체 정의가 아니라, 객체가 행동을 가진다는 것을 명시할 목적
 * */

interface MyInterface {
    var data1 : String
    fun myFun1(){

    }
    //기본 abstract 적용되기 때문에 abstract 붙이지 않아도
    fun myFun2()
}

class Myclass : MyInterface {//인터페이스에는 생성자가 없다.
    override var data1: String = "hello"

    override fun myFun2() {

    }

}
/**
 * //다른 인터페이스를 상속받는 인터페이스
 * */

interface MyInterface1 {

    fun myFun1(){

    }

}
interface MyInterface2 {

    fun myFun2(){

    }

}

interface MyInterface3 : MyInterface1, MyInterface2 {
    fun myFun3(){

    }
}

class MyClass1 : MyInterface3{
    override fun myFun1() {
        super.myFun1()
    }

    override fun myFun2() {
        super.myFun2()
    }

    override fun myFun3() {
        super.myFun3()
    }
}

/**
 * 클래스에서 여러 인터페이스 구현
 * */

interface MyInterface4{
    fun MyFun4()
}
interface MyInterface5{
    fun MyFun5()
}

class MyClass4 : MyInterface4, MyInterface5{
    override fun MyFun4() {
    }

    override fun MyFun5() {
    }

}

/**
 * 클래스에서 상속과 인터페이스 혼용
 * */

open class Super00{

}

class Sub2 : Super00(), MyInterface4, MyInterface5{
    override fun MyFun4() {
    }

    override fun MyFun5() {
    }
}
/**
 * 객체 타입으로서의 인터페이스
 * */

interface MyInterface10{
    fun myInterfaceFun()
}

open class Super1{
    fun mySuperFun(){
        println("mySuperFun")
    }
}

class Sub1 : Super1(), MyInterface10{
    override fun myInterfaceFun() {
        println("myInterfaceFun")
    }
}

fun main(args: Array<String>) {
//    val obj1 = Super()
    val obj2 = Sub()

    //인터페이스
//    val obj3 = MyInterface()//이건 안됨
    val obj4 = Myclass()

    obj4.myFun1()
    obj4.myFun2()

    val obj11 : Sub1 = Sub1()
    val obj12 : Super1 = Sub1()
    val obj13 : MyInterface10 = Sub1()

    obj11.mySuperFun()
    obj11.mySuperFun()

    obj12.mySuperFun()

    obj13.myInterfaceFun()

}

/**
 * 인터페이스와 프로퍼티
 * 인터페이스를 구현하는 클래스에서 추상 함수를 재정의 하는 목적이지만,
 * 함수 이외에 프로퍼티도 추가할 수 있다.
 *
 * 1. 추상형으로 선언하거나 get, set 함수 사용해야함
 * val 은 get 을 꼭 선언해야함
 * var 는 get, set을 꼭 선언해야함
 * get,set 시에 field 를 사용할 수 없다
 * --> field 를 사용할 수 없다는 것은 프라퍼의 값을 유지하거나 변경하는 용도로는 사용할 수 없다는 의미
 * */
interface MyInterface8{
    val prop1 : Int

//    val prop2 : String = "" //바로 값 대입 안됨
}
/**
 * 오버라이드 함수 식별
 * 1. 같은 이름의 추상 함수가 여러 개일 때
 *  - 그냥 오버라이드 하면 됨
 * 2. 같은 이름의 추상 함수와 구현된 함수가 있을 때
 *  - 인터페이스에 구현되어있는 함수가 있다면 super. 으로 호출한다.
 * 3. 같은 이름으로 구현된 함수가 여러 개일 때
 *  - 함수명 충돌 에러 발생
 * */

interface Interfae4{
    fun funA() {
        println("Interfae4")
    }
}
interface Interfae5 {
    fun funA() {
        println("Interfae5")
    }
}

// 3번의 예제
class Sub4 : Interfae4, Interfae5{

//override 안해도 될 것 같지만 해야한다? 함수명 충돌은 아닌디..?
    override fun funA() {
        super<Interfae4>.funA()
        super<Interfae5>.funA()
    }
    //override fun funA(){}

}