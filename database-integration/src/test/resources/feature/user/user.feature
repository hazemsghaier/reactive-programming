Feature: User Management

  Background:
    * url "http://localhost:9000"
    * path "/users"

  Scenario: Add user
    Given request { name: "hazem", email: "hazem2888", password: "hazem", age: 20, phone: "1234567", address: "hazem" }
    When method post
    Then status 201

    And match response.name == "hazem"
    And match response.email == "hazem2888"
    And match response.password == "hazem"
    And match response.age == 20
    And match response.phone == "1234567"
    And match response.address == "hazem"
    * def id = response.id

    # Store the ID in a global variable so it can be reused in other scenarios
    * configure report = { id: '#(id)' }

  Scenario: Get user by ID
    # Retrieve the ID from the global report
    * print karate.get('id')
    * def id = karate.get('id')
    Given path '/#{id}'
    When method get
    Then status 200

    And match response.name == "hazem"
    And match response.email == "hazem2888"