package basics

println "GROOVY"

//Variables
def (a, b, c) = [10, 20, 'foo']
assert a == 10 && b == 20 && c == 'foo'

def nums = [1, 3, 5]
def d, e, f
(d, e, f) = nums
assert d == 1 && e == 3 && f == 5

sheduledActivityCount = 5
println "Good morning! You have " + sheduledActivityCount + " activities scheduled for today."
println "Good morning! You have $sheduledActivityCount activities scheduled for today."
println "Good morning! You have ${sheduledActivityCount + 1} activities scheduled for today."

println 3**2 //Math.Pow(3,2)
println 3**3 //Math.Pow(3,3)

println 1 + 2 + "5" + 1 + 2 //3512

//SWITCH
int myOpportunity = 5500
switch (myOpportunity) {
    case 0..999:
        println "email"
        break
    case 1000..4999:
        println "phone"
        break
    default:
        println "face to face"
}

int opportunity1 = 1000
int opportunity2 = 2000
int opportunity3 = 3000
int opportunity4 = 4000

List opportunities = [opportunity1, opportunity2, opportunity3, opportunity4]

//LOOPS
int i = 0
while (i < opportunities.size()) {
    println "Found an opportunity ${opportunities[i]}"
    i++
}

for (int j = 0; j < opportunities.size(); j++) {
    println "Found an opportunity ${opportunities[j]}"
}

for (int it in opportunities) {
    println "Found an opportunity $it"
}

opportunities.each { println "${it}" }
opportunities.stream().map { it + 100 }.forEach { println "${it}" }

//CLOSURES
def myClosure = { println "In a closure" }
myClosure()
myClosure.call()

(1..3).each { myClosure() }