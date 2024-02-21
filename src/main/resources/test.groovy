//Code to print jacoco report results directly to the terminal

def reportFile = new File("target/site/jacoco/index.html")

if (!reportFile.exists() || !reportFile.canRead()){
    println "[INFO] Skipped due to coverage issue"
    return
}

reportFile.withReader("UTF-8") {
    reader ->
        def parser = getParser()
        def html = parser.parseText(reader.readLine())
        def footerRow = html.body.table.tfoot.tr
        def instructionsMissed = footerRow.td[1]
        def instructionsMissedPercentage = footerRow.td[2]
        def branchesMissed = footerRow.td[3]
        def branchesMissedPercentage = footerRow.td[4]

        println "[INFO] Jacoco Coverage Report: Instructions ${instructionsMissed}  - ${instructionsMissedPercentage}"
        println "[INFO] Jacoco Coverage Report: Branches ${branchesMissed}  - ${branchesMissedPercentage}"
}

XmlSlurper getParser() {

    parser = new XmlSlurper()
    parser.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false)
    parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false)

    return parser
}
