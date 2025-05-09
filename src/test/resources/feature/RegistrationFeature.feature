Feature: This is for Registation test

Scenario: Sucessful Registation feature test

Given User is on Register Home page
When User enter "firstname" "lastname" "username"  "password" and "captcha"
Then click on login page and captcha
And Register successful


Scenario Outline: Unsucessful Registation feature test

Given User is on Register Home page
When User enter "<firstname>" "<lastname>" "<username>"  "<password>" and "<captcha>"
Then click on login page and captcha
And Register successful

Examples:
|firstname|lastname|username|password|captcha|
|Seeta	  |Patil    |`seeta	|	Seeta|Yes|
|Seeta	  |      |`seeta	|	Seeta|Yes|
|	  |Patil       |`seeta	|	Seeta|Yes|
|seeta	  |Patil       |`	|	Seeta|Yes|
|seeta	  |Patil       |`	|	Seeta|Yes|
|Seeta	  |Patil    |`seeta	|	Seeta|No | 