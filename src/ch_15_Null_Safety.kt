package NullSafety

import ln
import java.lang.NumberFormatException
import kotlin.Exception

var data1 : String = "Kim"
var data2 : String?= null

fun myFun(input : String){

}


fun main(args: Array<String>) {
//    data1 = null // null 불가라서 넣을 수 없다.
    data2 = "Jane"

    /**
     * Not Null 에 nullable 을 넣을 수 없다.
     */
    //var data3 : String = data2
    //myFun(data2)

    /**
     * ?. --> Null 확인 연산자
     */
    ln("?. Null 확인 연산자")
    data2 = null

    //val length = data2.length //data2 가 nullable 이라서 넣을 수 없다
    val length = data2?.length

    class Address{
        val city : String? = "Seoul"
    }

    class User {
        val address : Address? = Address()
    }

    val user : User?  = User()
    println("이런 식으로도 사용 가능하다고 합니다 user?.address?.city ? : ${user?.address?.city}")

    /**
     * Null 이 아닐 때 실헹하도록 하기 위해서는
     * let{}을 사용할 수도 있음
     */
    ln("let{}을 사용")

    var array : Array<String?> = arrayOf("안녕하세요", null, "재인이에요")

    array.forEach {
        it?.let {println("it?.let -> null 이 아닌 it 가 나옵니다 : $it")  }
    }


    array.forEach {
        it.let {println("it.let -> it 가 나옵니다 : $it")  }
    }

    /**
     * 엘비스 연산자 ?: --> null 일 경우 실행되는 구문 혹은 값
     */
    ln("엘비스 연산자")

    data1?: 1
    data2?: 1 //data2 는 String 이지만 Int 값을 넣을 수도 있네

    ln("data2 는 String 이지만 Int 값을 넣을 수도 있네")
    println("data2? : ${data2}")

    /**
     * !! -> 예외 발생 연산자
     * null 이면 예외를 발생 시킨다
     */
    ln("예외 발생 연산자")


    /**
     * as? --> 안전한 캐스팅
     */
    ln("as --> 안전한 캐스팅")
    ln("타입 캐스팅을 잘못하면 ClassCastException 이 발생 하지만 as? 를 통해 null을 반환하게 한다.")

    val strData  : String = "Jane"

    val intData : Int? = strData as? Int
    println("intData? $intData")

    /**
     * 예외 처리
     */
    ln("예외 처리")
    ln("try catch 를 표현식으로 사용하면 각 영역의 마지막 줄이 반환값입니다.")
    ln("finally 는 실행되어도 어떤 값을 반환하지 않습니다. -> try / catch 의 마지막 줄만 리턴 값임")

    fun some1(arg : String) : Int {
        val parseData : Int = try{
            println("try 의 top")
            arg.toInt()
        }catch (e: Exception){
            println("try 의 catch")
            0
        }finally {
            println("try 의 finally")
            100
        }

        return parseData
    }

    println(some1("7"))
    println(some1("호호호"))

    class MyException (e: String) : Exception(e){

        init {
            println("e ? $e")
        }

        fun printError(e : String){
            println(e)
        }

        val errorData = e
    }

    ln("some2")
    fun some2(arg : String) : Int {
        val parseData : Int = try{
            println("try 의 top")
            arg.toInt()
        }
//        catch (e : NumberFormatException){
//            throw MyException(e.toString())
//        }
        catch (e: Exception){
            throw MyException(e.toString())
            10
//            println("try 의 catch")
//            println("e.errorData : ${e.errorData}")
//            println("e.printError : ${e.printError(e.toString())}")
//            0
        }finally {
            println("try 의 finally")
            100
        }

        return parseData
    }

    try {
        some2("호호호")
    }catch (e : MyException){
        println(e.errorData)
        println(e.printError(e.toString()))

    }

    /**
     *  throw 만 반환하는 함수라면
     *  리턴 타입은 Nothing 으로 하면 된다.
     */

    fun returnThrowOnly(s : Int) : Nothing{
        if(s < 0  ){
            println("s > 0")
            throw NumberFormatException()
        }else if(s > 5){
            println("s > 5")
            throw Exception()
        }else{
            println("else")
            throw Exception()
        }
    }

//    returnThrowOnly(7)
}