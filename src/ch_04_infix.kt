fun ln(header : String){
    println("=======================$header=======================")
}

//1. 확장함수일 때 infix 사용 가능
infix fun Int.myFun(x : Int) : Int{
    return this * x
}

class FunClass{
//2. class 의 멤버 함수로 infix 사용 가능
    infix fun infixFun(x : Int) : Int {
        return x * 2
    }
}


//3.
var test = 30
    get() = field + 10


//4. 확장함수


fun main(args: Array<String>) {

    println("10.myFun(6) : ${10.myFun(6)}")
    //1. 확장 함수일 경우
    println("10 myFun(6) : ${10 myFun(6)}")

    var obj = FunClass()
    println("obj.infixFun(10) : ${obj.infixFun(10)}")
    //2. 클래스의 멤버함수인 경우
    println("obj infixFun 10  : ${obj infixFun 10}")

    println(test)

    println("10.plus(5) : ${10.plus(5)}")

//    println("${}")

    var a = 1_0000_0000
println(a)
}
