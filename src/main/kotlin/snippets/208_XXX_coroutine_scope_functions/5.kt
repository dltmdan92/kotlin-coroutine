package f_208_XXX_coroutine_scope_functions.s_5

import kotlinx.coroutines.*

//sampleStart
data class Details(val name: String, val followers: Int)
data class Tweet(val text: String)
class ApiException(
    val code: Int,
    message: String
) : Throwable(message)

fun getFollowersNumber(): Int =
    throw ApiException(500, "Service unavailable")

suspend fun getUserName(): String {
    delay(500)
    return "marcinmoskala"
}

suspend fun getTweets(): List<Tweet> {
    return listOf(Tweet("Hello, world"))
}

/**
 * coroutineScope 함수는 기존의 중단 컨텍스트에서 벗어난 새로운 스코프를 만든다.
 * 부모로부터 스코프를 상속받고 구조화된 동시성을 지원한다.
 *
 */
suspend fun getUserDetails(): Details = coroutineScope {
    val userName = async { getUserName() }
    val followersNumber = async { getFollowersNumber() }
    Details(userName.await(), followersNumber.await())
}

fun main() = runBlocking<Unit> {
    val details = try {
        getUserDetails()
    } catch (e: ApiException) {
        null
    }
    val tweets = async { getTweets() }
    println("User: $details")
    println("Tweets: ${tweets.await()}")
}
// User: null
// Tweets: [Tweet(text=Hello, world)]
//sampleEnd
