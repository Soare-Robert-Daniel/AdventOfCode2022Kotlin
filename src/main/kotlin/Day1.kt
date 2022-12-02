import java.io.File

class Day1 : ChallengeDay {
    override fun execute() {
        // Read input
        val fileName = "src/resources/day1input.txt"
        val inputList = mutableListOf<String>()
        File(fileName).useLines { lines -> inputList.addAll(lines) }

        // Find the elf
        var currCal = 0
        val elvesCal = mutableListOf<Int>()
        inputList.forEachIndexed { _, s ->
            run {
                if (s.isEmpty()) {
                    elvesCal.add(currCal)
                    currCal = 0
                } else {
                    currCal += s.toInt();
                }
            }
        }

        elvesCal.sortDescending()
        println("# Day 1")
        println(" a) " + elvesCal[0])
        println(" b) " + elvesCal.slice(0..2).sum())
        println("-------------")
    }

}