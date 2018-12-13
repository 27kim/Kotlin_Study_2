package ch19

import ln
import kotlin.reflect.KProperty

interface Print{
    fun print(arg : String)
}

fun main(args: Array<String>) {

    /**
     * 1. Delegation class
     */

    ln("Delegation class")
    ln("Delegator 와 Delegatee 는 동일한 interface 를 구현해야 한다")

    class MyDelegatee : Print{
        override fun print(arg: String) {
            println("I am delegatee : $arg")
        }
    }

    class MyDelegator(obj : MyDelegatee) : Print by obj


    /**
     * 2. Delegation Property
     */

    ln("Delegation Property")
    ln("""
        1. getValue , setValue 는 operator 키워드를 추가 해야한다.
        2. getValue 는 2번째 param 으로 적용된 property의 이름을 가져온다.
        3. setValue 는 3번째 param 을 이용해 프로퍼티에 대입된 값을 얻는다.

    """.trimIndent())
    class MySumDelegate{
        var result : Int = 0

        operator fun getValue(thisRef : Any?, property : KProperty<*>) : Int{
            println("getValue call / ref : $thisRef , property : ${property.name}")
            return result
        }

        operator fun setValue(thisRef : Any?, property : KProperty<*>, value : Int){
            result = 0
            println("setValue call / value : $value,  '${property.name}'")
            for(i in 1..value){
                result += i
            }
        }
    }

    class Test{
        var sum : Int by MySumDelegate()
    }

    var obj2 = Test()
    obj2.sum = 10
    println("obj2.sum ${obj2.sum}")

    /**
     * 3. SAM전환
     */
    // 하나의 추상 함수를 가지는 인터페이스를 목적으로 한다.ㅃ
    ln("SAM : Single Abstract Method")
    ln("하나의 추상 함수를 가지는 인터페이스를 목적으로 한다.")
    ln("인터페이스와 그 인터페이스를 등록하는 setter 함수가 자바에 작성되어 있다면, 코틀린에서 setter 함수를 이용하여 인터페이스를 구현한 객체를 등록할 때 람다 함수를 이용하여 수비게 등록하는 방법을 제공")
}