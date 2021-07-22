fun main(args: Array<String>) {
    val maxConsencutive = maxConsecutiveOf1(listOf(1,1,1,0,0,1,1,1,1,1,0,1,1,1))
    println("Max Consencutive : $maxConsencutive")

    val reversedWord = reverseWord(mutableListOf('h','e','l','l','o',' ','w','o','r','l','d'))
    println("Reversed Word : $reversedWord")

    val isBracketsBalanced = balancedBracket("{[]([{}{}[][]])}")
    println("Bracket Balanced : ${if(isBracketsBalanced) "YES" else "NO"}")
}

fun maxConsecutiveOf1(data: List<Int>): Int{
    var result = 0
    var current = 0

    data.forEach{ item ->
        if(item == 0){
            current = 0
        } else {
            current++
            if(current > result)
                result = current
        }
    }

    return result
}

fun reverseWord(data: MutableList<Char>) : String
{
    return if (data.size > 1) {
        val last = data.last()
        data.removeAt(data.size - 1)
        last + reverseWord(data)
    } else {
        data.last().toString()
    }
}

fun balancedBracket(data: String): Boolean {
    val brackets = mutableListOf<Char>()
    val close = arrayOf('}', ']', ')')

    data.forEach {
        if (close.contains(it)) {
            if (brackets.isEmpty())
                return false
            when {
                it == '}' && brackets.last() == '{' -> brackets.removeAt(brackets.size - 1)
                it == ')' && brackets.last() == '(' -> brackets.removeAt(brackets.size - 1)
                it == ']' && brackets.last() == '[' -> brackets.removeAt(brackets.size - 1)
                else -> return false
            }
        } else {
            brackets.add(it)
        }
    }
    return true
}