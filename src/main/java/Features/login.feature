Feature: feature to login

Scenario: user tries to login in to page scenario
	Given user opens browser with url
	Then user enters "surajp" as "username" and "suraj@1995" as "password" in "login" page
	Then user clicks on "login_button" in "login" page
	Then user validates "title" as "CRMPRO  - CRM software for customer relationship management, sales, and support." in "home" page
	Then user validates "userNameLabel" as "User: padmanabhuni suraj" in "home" page