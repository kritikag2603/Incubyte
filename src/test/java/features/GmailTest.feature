Feature: Check login

Background:
Given browser is open
And gmail is opened
And the user logs in

@Gmail
Scenario: Login scenario
Given user clicks compose button
When when the user composes the valid email
And clicks send button
Then the popup disappears
