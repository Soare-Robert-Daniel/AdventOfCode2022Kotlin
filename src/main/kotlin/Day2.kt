import java.io.File

enum class State {
    WIN, DRAW, LOSE
}

class Day2 : ChallengeDay {
    override fun execute() {
        // Read input
        val fileName = "src/resources/day2input.txt"
        val inputList = mutableListOf<String>()
        File(fileName).useLines { lines -> inputList.addAll(lines) }

        val rulesToState = mapOf<Pair<String, String>, State>(
            Pair("A", "X") to State.DRAW,
            Pair("A", "Y") to State.WIN,
            Pair("A", "Z") to State.LOSE,

            Pair("B", "X") to State.LOSE,
            Pair("B", "Y") to State.DRAW,
            Pair("B", "Z") to State.WIN,

            Pair("C", "X") to State.WIN,
            Pair("C", "Y") to State.LOSE,
            Pair("C", "Z") to State.DRAW,
        )

        val actionToPoints = mapOf<String, Int>(
            "X" to 1,
            "Y" to 2,
            "Z" to 3
        )

        val stateToPoints = mapOf<State, Int>(
            State.LOSE to 0,
            State.DRAW to 3,
            State.WIN to 6
        )

        var totalScore = 0

        inputList.forEach { line ->
            run {
                val (otherAction, myAction) = line.split(" ")

                val result = rulesToState[Pair(otherAction, myAction)]
                // println("$otherAction $myAction $result ${choicePoints[myAction]!! + bonusPoints[result]!!}")
                totalScore += actionToPoints[myAction]!! + stateToPoints[result]!!
            }
        }

        // Part 2
        var realTotalScore = 0

        val actionToState = mapOf(
            "X" to State.LOSE,
            "Y" to State.DRAW,
            "Z" to State.WIN
        )

        val rulesToAction = mapOf(
            Pair("A", "X") to "Z",
            Pair("A", "Y") to "X",
            Pair("A", "Z") to "Y",

            Pair("B", "X") to "X",
            Pair("B", "Y") to "Y",
            Pair("B", "Z") to "Z",

            Pair("C", "X") to "Y",
            Pair("C", "Y") to "Z",
            Pair("C", "Z") to "X",
        )

        inputList.forEach { line ->
            run {
                val (otherAction, desiredResult) = line.split(" ")

                val myAction = rulesToAction[Pair(otherAction, desiredResult)]
                // println("$otherAction $myAction $result ${choicePoints[myAction]!! + bonusPoints[result]!!}")
                realTotalScore += actionToPoints[myAction]!! + stateToPoints[actionToState[desiredResult]]!!
            }
        }

        println("# Day 2")
        println(" a) $totalScore")
        println(" b) $realTotalScore")
        //println(" b) " + elvesCal.slice(0..2).sum())
        println("-------------")
    }
}