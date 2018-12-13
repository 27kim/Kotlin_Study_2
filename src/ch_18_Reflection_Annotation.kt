package ch18

import jdk.nashorn.internal.ir.LiteralNode
import ln
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.*

/**
 * 리플렉션이란?
 * 1. 런타임 때 프로그램의 구조를 분석해 내는 기법을 이야기함
 * */

fun main(args: Array<String>) {
    ln("""
 리플렉션이란?
 1. 런타임 때 프로그램의 구조를 분석해 내는 기법을 이야기함

 런타임 때 동적으로 클래스를 분석하려면 클래스에 대한 정보가 필요.
 이 클래스에 대한 정보를 "클래스 레퍼런스"라고 표현
 클래스 레퍼런스를 대입받는 곳은 "클래스 타입"으로 선언해야 함

    """)

    val myVal: KClass<*> = String::class

    fun myFun(arg : KClass<*>){

    }
    ln("클래스 타입은 Int 인데 대입된 레퍼런스는 String 타입이기 때문에 다음은 에러남 ")
//    val myVal2: KClass<Int> = String::class // 이러면 에러남. 클래스 타입은 Int 인데 대입된 레퍼런스는 String 타입이기 때문

    ln("""
    클래스 레퍼런스
        1. 클래스 정보 분석
            전달받은 클래스의 레퍼런스를 이용하여 클래스가 추상형으로 선언된건지, Open 인지, data 클래스 인지 등에 대한 다양한 정보를 알아내는 것을 이야기함
        2. 생성자 분석
            모든 생성자 정보 : val constructors: Collection<KFunction<T>>
            주 생성자 정보  : val <T: Any< KCalss<T>.primaryConstructor: KFunction<T>?

    """.trimIndent())

    open class MyClass(no : Int) {
        constructor(no : Int, name : String) : this(10){}
        constructor(no : Int, name : String , email : String) : this(10){}
    }

    fun someFun(arg : KClass<*>){
        val constructors = arg.constructors
        for(constructor in constructors){
            println("constructor")
            val parameters = constructor.parameters
            for(parameter in parameters){
                println("${parameter.name} : ${parameter.type}")
            }
            println()
        }

        println("primary constructor")
        val primaryConstructor = arg.primaryConstructor
        if(primaryConstructor!=null){
            val parameters = primaryConstructor.parameters
            for(parameter in parameters){
                println("${parameter.name} : ${parameter.type}")
            }
        }
    }

    someFun(MyClass::class)

    ln("""클래스 프로퍼티 분석
    1. 확장 프로퍼티를 제외한 클래스에 선언된 모든 프로퍼티 반환
    2. 확장 프로퍼티를 제외한 클래스와 상위 클래스에 선언된 모든 프로퍼티 반환
    3. 클래스에 선언된 확장 프로퍼티 반환
    4. 상위 클래스 및 현 클래스의 확장 프로퍼티 반환

    """.trimIndent())

    open class SuperClass{
        val superVal : Int = 10


    }

    class MyClass2(val no : Int) : SuperClass(){
        val myVal : String = "Hello"
        val String.someVal : String
            get() = "world"

        fun myFun(){}
        fun String.someFun(){}
    }

    fun someFun2(arg : KClass<*>){
        val properties = arg.declaredMemberProperties
        println("1. declaredMemberProperties")
        for(property in properties){
            println("${property.name} : ${property.returnType}")
        }

        val properties2 = arg.memberProperties
        println("2. memberProperties")
        for(property in properties2){
            println("${property.name} : ${property.returnType}")
        }

        val properties3 = arg.declaredMemberExtensionProperties
        println("3. declaredMemberExtensionProperties")
        for(property in properties3){
            println("${property.name} : ${property.returnType}")
        }
    }

    someFun2(MyClass2::class)

    ln("""클래스 함수 분석
    """.trimIndent())

    fun someFun3(arg : KClass<*>){
        val properties = arg.declaredMemberFunctions
        println("1. declaredMemberFunctions")
        for(property in properties){
            println("${property.name} : ${property.returnType}")
        }

        val properties2 = arg.memberFunctions
        println("2. memberFunctions")
        for(property in properties2){
            println("${property.name} : ${property.returnType}")
        }

        val properties3 = arg.declaredMemberExtensionFunctions
        println("3. declaredMemberExtensionFunctions")
        for(property in properties3){
            println("${property.name} : ${property.returnType}")
        }
    }

    someFun3(MyClass2::class)

    ln("""함수 레퍼런스와 프로퍼티 레퍼런스
        함수이름, 함수의 모든 매개변수 , 함수의 반환 타입 등을 추출할 수 있음
        이 때 험수 레퍼런스는 main 안에 있으면 에러가 납니다.₩
    """.trimIndent())



    fun refectionFun(argFun: KFunction<*>){
        println("${argFun.name}")

        val parameters = argFun.parameters

        for(parameter in parameters){
            println("${parameter.name} : ${parameter.type}")
        }
        println("${argFun.returnType}")
    }

    refectionFun(::myFun_fun)
}
fun myFun_fun(no : Int, name : String) : Boolean{
    return true
}