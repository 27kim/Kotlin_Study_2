/*
 ## CLASSES VS STRUCTURES

 Imagine you're writing a movie-viewing application in Kotlin.
 Users can create lists of movies and share those lists with other users.

 Create a `MovieList`  and a `MovieGoer` class

 - `MovieList` - Contains a genre String passed in the constructor
    and an array of movie titles set as a property.
    Create a `print` method that will print all the movies in the list.
 - `MovieGoer` - Add a method `addList(movieList)` which adds the given list
    to a map of `movieList` objects (using the `genre` as a key).
    Add a method `movieListFor(genre) : MovieList?`
    that will return the Nullable `MovieList` for the provided genre.
    Add a method 'addMovie'(genre, movie) that will add a movie to the given genre
 - Create `jane` and `john` users in main and have them create and share lists.
    Have both `jane` and `john` modify the same list and call `print` from both users.
    Are all the changes reflected?
*/

class MovieList(var genre: String) {
    //    var movieTitle = titles
    private var movies = ArrayList<String>()

    fun addMovie(movie : String){
        movies.add(movie)
    }

    fun print() {
        println("Movie List : $genre")
        for (title in movies) {
            print ("$title  ")
        }
        println()
    }
}

class MovieGoer {
    private var movieList = mutableMapOf<String, MovieList>()

//    fun addList(list: MovieList) {
//        movieList[list.genre] = list
//    }

    fun movieListFor(genre: String): MovieList? {
        return movieList[genre]
    }
    //Create a new method in MovieGoer called addGenre that takes a genre and creates a new MovieList object.
    fun addGenre(genre : String){
        movieList[genre] = MovieList(genre)
    }
    fun addMovie(genre: String, movie: String) {
        if(!movieList.containsKey(genre)){
            addGenre(genre)
        }
        movieList[genre]?.addMovie(movie)
    }

//    fun addList(genre: String, movies: List<String>) {
//        for (movie in movies) {
//            movieList[genre] = movie
//        }
//    }
//
//    fun addMovie(genre: String, movie: String) {
//        movieList[genre] = movie
//    }
//
//    fun movieListFor(genre: String): List<MovieList>? {
//        var returnData = mutableListOf<MovieList>()
//        returnData.add()
//        return movieList.get(genre)
//    }
}

/*
 ### Challenge 2
Make movieList private and remove addList.
Add a method to MovieList to add a movie and make movies private
Create a new method in MovieGoer called addGenre that takes a genre and creates a new MovieList object.
Update MovieGoer.addMovie to use the MovieList's addMovie method and check to see if the MovieList
exists before trying to add
*/


// Your Solution Here

fun main(args: Array<String>) {
    var x = 4
    var sb = StringBuffer("..fedcba");
    sb.delete(3,6)
    println(sb)
    sb.insert(3,"az")
    println(sb)
    if(sb.length>6) x = sb.indexOf("b")
    println(sb)
    sb.delete((x-3),(x-2))
    println(sb)


    // Test your classes here
//    - Create `jane` and `john` users in main and have them create and share lists.
//    Have both `jane` and `john` modify the same list and call `print` from both users.
//            Are all the changes reflected?
    val jane = MovieGoer()
    val john = MovieGoer()
//    val actionList = MovieList("Action")
//
//    jane.addList(actionList)
//    john.addList(actionList)

    jane.addMovie("Action", "Rambo")
    jane.addMovie("Action", "Terminator")

    john.addMovie("Action", "Die Hard")

    jane.movieListFor("Action")?.print()
    john.movieListFor("Action")?.print()
/*
 ### Challenge 3

 Your challenge here is to build a set of objects to support a t-shirt store.

 - `TShirt` - Represents a shirt style you can buy. Each `TShirt` has a size (Int), color(Int), price (Double)
 - `Address` - Represents a shipping address, containing the
    number, street, city, and zip code.
 - `ShoppingCart` - Holds a current order, which is composed of an list of `TShirt`
    that the `User` wants to buy, as well as a method to calculate the total cost.
    Additionally, there is an `Address` that represents where the order will be shipped.

 - `User` - A registered user of the t-shirt store app.
    A user has a name, email, and a `ShoppingCart` (below).
 */

    // Your Solution Here


}