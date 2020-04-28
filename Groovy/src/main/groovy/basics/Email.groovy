package basics

class Email {

    String prospectName
    String emailAddress
    Date sendDate
    String notes

    def display() {
        println "Recipient: $prospectName\nEmail: $emailAddress\nDate: $sendDate\nSummary: $notes"
    }

    //return can be omitted
    String toString() {
        return "Recipient: $prospectName\nEmail: $emailAddress\nDate: $sendDate\nSummary: $notes"
    }
}