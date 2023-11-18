fun main() {
    game()
}

fun game(){
    var unique = false
    var peopleNumberString = ""
    val computerNumber = mutableListOf<Int>()
    var computerNumberString = ""
    while (!unique){
        for(i in 0 .. 3) {
            computerNumber.add((0..9).random())
            computerNumberString += computerNumber[i].toString()
        }
        unique = uniqueNumber(computerNumberString)
        if (!unique){
            computerNumber.clear()
            computerNumberString = ""
        }
    }
    var countTurn = 1
    while (countTurn < 10){
        unique = false
        while (!unique){
            println("Введите четырёх значное число")
            peopleNumberString = readln()
            unique = uniqueNumber(peopleNumberString)
            if(!unique){
                println("Число должно быть уникальное. Попробуйте ввести его снова\n")
                peopleNumberString = ""
            }
        }
        var countBull = 0
        var countCow = 0
        for (i in computerNumberString.indices){
            if(peopleNumberString[i] == computerNumberString[i]){
                countBull++
            }
            else{
                for (j in computerNumberString.indices){
                    if (peopleNumberString[i] == computerNumberString[j]){
                        countCow++
                        break
                    }
                }
            }
        }
        println("$countTurn. $peopleNumberString     $countBull Bull $countCow Cow")
        countTurn++
        if (countBull == 4){
            println("Поздравляю вы выйграли")
            break
        }
        if (countTurn == 10) print("К сожелению вы проиграли. число заданное компьютером $computerNumberString")
    }
}


fun uniqueNumber(number: String): Boolean {
    for(i in number.indices){
        for (j in number.indices){
            if(i == j) continue
            if (number[i] == number[j]) {
                return false
            }
        }
    }
    return true
}
