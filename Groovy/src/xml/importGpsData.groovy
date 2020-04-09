package xml

@Grapes(
        @Grab(group = 'joda-time', module = 'joda-time', version = '2.10.5')
)
import org.joda.time.DateTime
@Grapes(
        @Grab(group = 'joda-time', module = 'joda-time', version = '2.10.5')
)

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

def file = new File('../xml/fells_loop.gpx')
println file.exists()

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)
println gpx

println gpx.name
println ''
println gpx.desc
println ''
println gpx.@version
println gpx.@creator

for (point in gpx.rte.rtept) {
    println point.@lat
    println point.@lon
    println point.time
}

gpx.rte.rtept.each {
    println it.@lat
    println it.@lon
    println it.time
}

//GRAPE
gpx.rte.rtept.each {
    println it.@lat
    println it.@lon

    def printableTime = new DateTime(it.time.toString())
    def format = DateTimeFormat.forPattern('MM/dd/yyyy - hh:mm aa')
    println printableTime.toString(format)
}