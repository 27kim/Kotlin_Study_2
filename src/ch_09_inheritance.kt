/**
모든 클래스는 Any 클래스의 서브 클래스

함수, 클래스는 기본값이 final 임

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