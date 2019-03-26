/**
 * 클래스에는 여러 가지 구성요소를 선언할 수 있다.
 * property, method, constructor, class
 *
 * 클래스의 구성요소를 이용하려면,
 * 구성요소가 메모리에 올라와야함 (메모리 할당)
 *
 * 객체를 생성할 때 메모리가 할당됨
 * -> 객체 생성은 결국 클래스를 이용하기 위해 메모리를 할당하는 작업
 * -> 할당된 메모리를 객체명으로 참조해서 이용하는 개념
 *
 **/

/**
 * 생성자 : 주 생성자 / 보조 생성자로 구분
 **/

fun main(args: Array<String>) {

}
//주생성자는 하나의 클래스에 하나만 정의할 수 있음
class MyClass{}     //컴파일러가 자동으로 매개변수 없는 주 생성자를 추가함
class MyClass2(){}  //constructor 생략 가능
class MyClass3 constructor(){}

//매개변수가 있는 주 생성자
class User1_1 constructor(name : String, age : Int){}
class User1_2 (name : String, age : Int){}

//생성자 매개변수 기본값 명시
class User3(name : String, age : Int = 0){}
var user3_1 = User3("Jane", 4)
var user3_2 = User3("Jiho")

//생성자 초기화 블록 init
//-> 매개변수 지정 이외에 실행문도 작성하고 싶을 경우 init{} 블럭 사용

//생성자 매개변수 값 이용
//초기화 블럭이나 클래스 프로퍼티에서는 접근할 수 있지만, 클래스에 정의된 멤버 함수에서는 사용 불가
class User4(var name : String, age: Int){
    init{
        println("User4 init! $name / $age")
    }
    //프로퍼티에서 가능
    val upperNme = name.toUpperCase()

    fun sayHi(){
        //멤버 함수에서는 사용 불가가
       println("$name") //그냥 가져오지 못함 가져오기 위해서는 생성자에 val, var 필요함
    }
}

var user4_1 = User4("jane", 4)


/**
 * 보조 생성자
 *
 * 주 생성자를 생성하지 않으면 관계 없으면 관계 없지만,
 * 주생성자를 선언했다면 객체 생성 시 어떠한 경우라도 반드시 주 생성성는 실행되어야 합니다.
 *
 * 보조 생성자가 있을 경우 컴파일러가 생성해주는 기본 생성자는 자동 생성되지 않음
 *
 * 하나의 클래스에 주 생성자와 보조 생성자를 얼마든지 함께 선언할 수 있지만
 * 주 생상자를 선언했다면 보조 생상자는 무조건 주 생성자를 함께 호출해 주어야 합니다.
 *
 * 보조 생성자에는 val var 정의 불가함
 **/

class User1(name :String){
    //보조 생성자 여러개 생성 가능
    //init 초기화 블럭은 가장 먼저 실행 (주/보조 생성자 관계없이 객체 생성 때 가장 먼제 실행됨)
    init{
        println("최초로 실행됨 / 보조 생성자의 매개변수는 여기서 사용할 수 없음")
    }
    constructor(name : String, age : Int) : this(name){
        println("init 다음 실행됨 / 보조 생성자의 매개변수에는 val var 사용할 수 없음")
    }
    constructor(name : String, age : Int, tel : String) : this(name)
}
