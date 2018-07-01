Feature: Login

Scenario: Valid User
  Given a user with valid credentials
  When they log in
  Then they will have access to secure sections of the site

Scenario: Invalid User
  Given a user with invalid credentials
  When they log in
  Then they will not gain access to secure sections of the site