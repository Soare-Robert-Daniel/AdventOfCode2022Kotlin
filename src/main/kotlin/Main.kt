import java.io.File;

fun main(args: Array<String>) {
    val days = mutableListOf<ChallengeDay>();

    days.add( Day2() )

    days.forEach{ day -> day.execute()}
}