package basics

Email email = new Email()

email.prospectName = "Good news"
email.emailAddress = "news@test.com"
email.sendDate = new Date()
email.notes = "Amazing"

email.display()

println email.toString()