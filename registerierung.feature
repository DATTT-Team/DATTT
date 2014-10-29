Feature: User Registration
	Users can registrate on the website to use the features of DATTT
	
Scenario: User tries to registrate with wrong email adress
	Given user is not logged in
	And user hat clicked the registration link
	When user enters user@domain as email adress
	And user enters mypassword1234 as password
	And user enters MaxMustermann as name
	And user pushes the confirm button
	Then user receives a failure notification
	And the email field is highlighted
	
Scenario: User tries to registrate with wrong email adress
	Given user is not logged in
	And user hat clicked the registration link
	When user enters user@domain.de as email adress
	And user enters password1234 as password
	And user enters MaxMustermann as name
	And user pushes the confirm button
	Then user receives a success notification
	And an email is sent to user@domain.de with a confirmation link
	
