import java.io.File

class Day3 : ChallengeDay {
    override fun execute() {

        // Read input
        val fileName = "src/resources/day3input.txt"
        val inputList = mutableListOf<String>()
        File(fileName).useLines { lines -> inputList.addAll(lines) }

        // Part 1
        var prioritySum = 0

        inputList.forEach { line ->
            run {
                val firstContainer = line.take(line.length / 2).toSet()
                val secondContainer = line.drop(line.length / 2).toSet()

                // println("$firstContainer $secondContainer")

                firstContainer.intersect(secondContainer).forEach { value ->
                    run {
                        val num = if (value.isLowerCase()) {
                            value.code - 'a'.code + 1
                        } else {
                            value.code - 'A'.code + 27
                        }
                        // println("$value ${num}")
                        prioritySum += num;
                    }
                }
            }
        }

        // Part 2
        var groupPrioritySum = 0
        inputList.windowed(3, 3).forEach { trioLine ->
            run {
                val firstGroup = trioLine[0].toSet()
                val secondGroup = trioLine[1].toSet()
                val thirdGroup = trioLine[2].toSet()

                // println("$firstGroup $secondGroup $thirdGroup")

                firstGroup.intersect(secondGroup).intersect(thirdGroup).forEach { value ->
                    run {
                        val num = if (value.isLowerCase()) {
                            value.code - 'a'.code + 1
                        } else {
                            value.code - 'A'.code + 27
                        }
                        // println("$value ${num}")
                        groupPrioritySum += num;
                    }
                }
            }
        }

        println("# Day 3")
        println(" a) $prioritySum")
        println(" b) $groupPrioritySum")
        //println(" b) " + elvesCal.slice(0..2).sum())
        println("-------------")
    }
}