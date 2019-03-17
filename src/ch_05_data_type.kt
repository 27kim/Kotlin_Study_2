import Util.gogo
import java.lang.Exception

fun main(args: Array<String>) {
    /**
     * ch5. 데이터 타입
     * 5.1 기초 데이터 타입
     * 5.1.1 숫자 타입 : Int Long, Short, Double, Float
     *   코틀린에서는 기초 타입 자체가 없음
     *       -> 모두 클래스이며, 선언한 변수는 그 자체로 객체가 됨 -> 타입 클래스에 정의된 기초 함수와 프로퍼티를 사용할 수 있음
     *   char 는 숫자타입이 아님
     *   숫자 타입에 대한 자동 형변환을 제공하지 않음
     *
     * */

    val intData: Int = 10
    //타입 클래스에 정의된 기초 함수 사용가능
    //여기서는 Int 의 minus 사용
    val result = intData.minus(5)

    gogo("val result = intData.minus(5)", result)

    /**
     * 숫자 타입에 대한 자동 형변환을 제공하지 않는다
     * 숫자 타입에 underscore 사용 가능
     */
    val i: Int = 10
//    val l : Long = i //컴파일 에러
//    println(l)


//    int i = 10;
//    long l = i;
//    System.out.println(l);
//    위의 코드는 자바의 자동 형변환 코드이다.
//    작은 범위의 타입은 큰 범위 타입으로 자동 형 변환이 가능하다.

    var hundred = 1_000_000

    /**
     *  5.1.2 논리, 문자와 문자열 타입
     *  - 논리
     *  ||, &&, ,!
     *  - 문자
     *  char : 숫자로 표현안됨
     *  string : str[i] 로 표현되는 char 의 집합
     *  raw string 가능 """ """
     *  문자열 템플릿 $변수명 ${표현식}
     * */
    val rawString = """
        첫번째 줄
        두번째줄
        세번째줄
    """

    gogo("rawString", rawString)

    //문자열 템플릿
    println("rawString은  ? ${rawString} 이렇게 나옵니다")


    /**
     * 5.1.3 Any 타입
     *  코틀린의 데이터는 모두 객체.
     *  최상위 클래스는 Any -> 어떤 데이터는 담을 수 있다
     * */

    fun anyTest(any: Any) {
        when (any) {
            1 -> println("1에 걸림")
            is String -> println("String에 걸림")
            is Boolean -> println("Boolean 걸림")

        }
    }

    anyTest(1)
    anyTest("하하")

    /**
     * 5.1.4 null 허용 타입
     * */
//    val a: Int = null
    val b: Int? = null

    fun parseInt(input : String) : Int? {
        return input.toIntOrNull()
    }

    /**
     * 5.1.5 Any, Any?
     * Any? > Any
     * */

    val myVal1: Any = 10
    val myVal2: Any? = myVal1

    val myVal3: Any? = 10
    //as 가 없으면 컴파일 안됨
    val myVal4: Any = myVal3 as Any

    /**
     * 5.1.6 Unit과 Nothing
     * Unit : void
     * Noting : 데이터가 없다는 것을 명시적으로 뜻함
     * */

    fun myFun(args : Nothing?) : Nothing{
        //항상 Exception 을 발생시칸다 --> 의미있는 데이터를 반환하지 못한다
        // -> Nothing 리턴해서 이를 명시적으로 표현함
        throw Exception()
    }

    /**
     * 5.1.7 타입 확인과 캐스팅
     * is
     * as : 상하위 클래스 관계에서 사용
     * */
    fun getStringLength(obj: Any): Int? {
        val stData: String = obj as String //as 없으면 컴파일 안됨
        //Smart casting ? is 연산자를 통해 특별한 타입으로 확인되면 명시적으로 타입캐스팅을 하지 않아도 자동으로 캐스팅 됨
        if (obj is String) {
            return obj.length
        }
        return null
    }
    /**
     * 기초 데이터 타입에 대한 자동 형변환 안되지만 값의 형변환은 정상적으로 됨
     * */
    val longData = 1L + 3
}

