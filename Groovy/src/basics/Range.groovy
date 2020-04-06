package basics

def numbers = 1..10
for (num in numbers) {
    if (isEven(num)) {
        println num
    }
}

static def isEven(def num) {
    return num % 2 == 0
}

//static def isEven(num) {
//    num % 2 == 0
//}

def letters = 'a'..'g'
for (let in letters) {
    println let
}

enum DAYS {
    SUN,
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT
}

def weekdays = DAYS.MON..DAYS.FRI
for (var in weekdays) {
    println var
}
println "Extents: "
println weekdays.from
println weekdays.to