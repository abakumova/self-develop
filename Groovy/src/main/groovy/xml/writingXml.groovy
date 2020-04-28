package xml

import groovy.xml.StreamingMarkupBuilder

def inFile = new File('../xml/fells_loop.gpx')
println inFile.exists()

def slurper = new XmlSlurper()
def gpx = slurper.parse(inFile)

def markupBuilder = new StreamingMarkupBuilder()
def xml = markupBuilder.bind {
    route {
        mkp.comment(gpx.name)
        gpx.rte.rtept.each { point ->
            routepoint(timestamp: point.time.toString()) {
                latitude(point.@lat)
                longitude(point.@lon)
            }
        }
    }
}

def outFile = new File('../xml/fells_loop_truncated.xml')
outFile.write(xml.toString())