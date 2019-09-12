Feature: Endpoint validation to add person

Scenario: Add person proccess successfully
Given The endpoint host "http://localhost"
When The client make a request at "persona/guardar"
And Sending the required attribute name "Jorge"
Then The status response should be 200
And The response message is "true" 

Scenario: Add person proccess fails
Given The endpoint host "http://localhost"
When The client make a request at "persona/guardar"
And Sending the required attribute name ""
Then The status response should be 400
And The response message is "false" 