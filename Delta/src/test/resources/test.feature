@test
Feature: Validate login functions
Scenario Outline: To pass both positive and negative credentials
Given Open browser and launch URL
When Pass email on the email field "<emails>"
And pass password on the password field "<passwords>"
And Click on the signIn button
And Validate the displaying notifications
Then Close the browser

Examples:

|emails|passwords|
|prakashpaiyya@gmail.com|123123123Aaqwe|
|Test@gmail.com|123456787890Aqwe&|

@dropDown
Scenario: Dropdown validation
Given Open browser and launching the URL
When Check if the first dropdown working as expected
And Check if the second dropdown working as expected
And Check if the third dropdown working as expected
Then close the browser

