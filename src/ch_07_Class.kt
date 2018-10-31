/**
 * 클래스에는 여러 가지 구성요소를 선언할 수 있다.
 * property, method, constructor, class
 *
 * 클래스의 구성요소를 이용하려면,
 * 구성요소가 메모리에 올라와야함 (메모리 할당)
 *
 * 객체를 생성할 대 메모리가 할당됨 -> 객체 생성은 결국 클래스를 이용하기 위해 메모리를 할당하는 작업
 * 할당된 메모리를 객체명으로 참조해서 이용하는 개념
 *
 **/

/**
 * 생성자 : 주 생성자 / 보조 생성자로 구분
 **/

//1. 주생성자는 하나의 클래스에 하나만 정의할 수 있음
class MyClass{}     //컴파일러가 자동으로 매개변수 없는 주 생성자를 추가함
class MyClass2(){}  //constructor 생략 가능
class MyClass3 constructor(){}

//2. 생성자 초기화 블록 init

class User4(var name : String, age: Int){
    init{
        println("init! $name / $age")
    }

    fun sayHi(){
        println("$name") //그냥 가져오지 못함 가져오기 위해서는 생성자에 val, var 필요함
    }
}

/**
 * 보조 생성자
 * 하나의 클래스에 주 생성자와 보조 생성자를 얼마든지 함께 선언할 수 있지만
 * 주 생상자를 선언했다면 보조 생상자는 무조건 주 생성자를 함께 호출해 주어야 합니다.
 **/

class User1(name :String){
    //보조 생성자 여러개 생성 가능
    init{
        println("최초로 실행됨 / 보조 생성자의 매개변수는 여기서 사용할 수 없음")
    }
    constructor(name : String, age : Int) : this(name){
        println("init 다음 실행됨 / 보조 생성자의 매개변수에는 val var 사용할 수 없음")
    }
    constructor(name : String, age : Int, tel : String) : this(name)
}
