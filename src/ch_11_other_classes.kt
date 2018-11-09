package eleven

/**
 * 데이터 클래스란?
 * 1. 주생성자를 선언해야하며 매개 변소는 최소 한 개 이상
 * 2. 모든 주 생성자의 매개변수는 var / val
 * 3. 데이터 클래스는 abstract, open, sealed, inner 등의 예약어를 추가할 수 없다
 *
 * 데이터 클래스의 함수
 * equals() / hashcode()
 * toString()
 * conponentN()
 * copy()
 *
 * equals() : 데이터의 값을 비교
 * 1. 같은 데이터 클래스의 객체일 때만 데이터를 비교함
 * 2. 주 생성자의 매개변수가 아닐 경우 비교 대상 아님
 *
 * toString()
 * 데이터 클래스의 데이터를 문자열로 반환
 *
 *
 * componentN()
 * component1(), component2()등 데이터 클래스의 프로퍼티에 대해 자동으로 만들어짐
 * */
data class User (val name : String, val age : Int)

fun main(args: Array<String>) {
    var user = User("Jane", 4)

    println(user.component1())
    println(user.component2())

    println("분해선언ㄷㄷㄷ=======================")
    val (name, age ) = user
    println(name)
    println(age)
    println("=======================")

    /**
     * copy()
     * */
    println("copy()")
    var user2 = user.copy("jiho")
    var user3 = user.copy()
    println(user2)
    println(user3)

    /**
     * inner class
     * */

    var testClass = Outer.Nested()
    //이건 안됨
    //inner 가 추가된 nested 클래스는 외부에서 객체로 생성할 수 없다.
    var testClass2 = Outer.Nested2()
    //이건 됨
    var testClass3 = Outer().Nested2()
    //이거도
    var testClass4 = Outer().returnNested()

    /**
     * object 클래스
     * */
    val obj11 = Outer2()
    //private 이 없으면 myInner 까지는 접근 가능하지만  Any 타입이라 내부 프로퍼티가 없다.
    //private 이 있으면 외부에서 object 클래스를 부를 수가 없당
    obj11.myInner.innerFun()

    /**
     * object 클래스의 타입 명시
     * 타입이 선언되면 더 이상 any 타입이 아니기 때문에 외부에서 사용할 수 있
     * */
    val obj12 = Outer2()
    obj12.myInner.interfaceFun()

    /**
     * objectClass
     * */
    //이미 선언과 동시에 생성되기 때문에 아래는 안된다.
//    var testOC = objectClass()
    objectClass.objectClassFun() //이것을 가능함

    /**
     * companion object
     * */

    OuterCompanion.Nested.no
    OuterCompanion.Nested.myFun()

    OuterCompanion.no
    OuterCompanion.myFun()

}

/**
 * Nested class
 * */

class Outer{
    private var no : Int = 10
    fun outerFun(){
        println("outerFun()")
    }

    class Nested{
        val name : String = "kkang"
        fun myFun(){
            println("nested.. myFun")
            /**
             * nested 클래스에서 외부 클래스의 멤버에 접근 할 수 없다.
             * */
//            no = 20
//            outerFun()
        }
    }

    inner class Nested2{
        val name : String= "kkang"
        fun myFun(){
            println("nested.. myFun")
            /**
             * nested 클래스에서 외부 클래스의 멤버에 접근 할 수 없다.
             * */
            no = 20 //private 이지만 에러가 없다.
            outerFun()
        }
    }

    fun returnNested() : Nested2{
        return Nested2()
    }
}
/**
 * Object 클래스
 * 익명 클래스를 정의할 때 사용한다.
 *
 * 클래스명이 없지만, 선언과 동시에 객체가 생성 된다.
 * 이름이 없으므로 반복해서 객체 생성은 불가능.
 *
 * -생성자를 추가할 수가 없다
 * */

//최상위에 작성 가능
val obj1 = object {
    var no1 : Int = 10
    fun myFun(){

    }
}
//클래스 내부에도 작성 가능
class Outer2{
    private var no : Int = 0
    /**
     * 아래에 private 이 없으면 object 클래스 내부의 프로퍼티에 접근할 수가 없다.
     * 이유는 타입 때문이라는데..?
     * */
      var myInner = object : someInterface{
        override fun interfaceFun() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        val name : String = "kkang"
        fun innerFun(){
            println("innerFun.....")
            no++
        }
    }

    fun outerFun(){
        myInner.name
        no = 1
    }
}

/**
 * 타입 명시로 object 를 이용
 */

interface someInterface{
    fun interfaceFun()
}
/**
 * object선언
 * object 예약어를 이용해 이름이 있는 클래스도 선언할 수가 있다.
 * 싱글톤 클래스 생성할 때 사용을 하면 됨
 * */

object objectClass {
    fun objectClassFun(){}
}

/**
 * companion 예약어를 통해 Outer.Nested.변수명이 아니라
 * Outer.변수명으로 접근할 수 있다.
 * 이유는 object 클래스가 자바로 변형될 때는 static 이 추가되기 때문
 * */

class OuterCompanion{
    companion object Nested {
        val no = 0
        fun myFun(){}

    }
}