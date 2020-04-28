Feature: People


Background:
* url 'http://localhost:8080/api'


Scenario: get all people

Given path 'pessoas'
When method get
Then status 200
And assert response.length == 2
And match response[0].nome == 'Michael Thomas'


Scenario: create a person

Given path 'pessoas'
And request read('classpath:karate/person-create.json')
When method post
Then status 201


Scenario: delete a person
 
Given path 'pessoas', '3'
When method delete
Then status 204


Scenario: update a person

Given path 'pessoas'
And request read('classpath:karate/person-update.json')
When method put
Then status 201
