Feature: Compute the sum of two numbers

Scenario Outline: Add two numbers
Given I am an iPhone user using an app
When I try to add "<num1>" and "<num2>"
Then I should get "<ans>" as the answer

Examples:

|num1|num2|ans |
|1   | 2  | 3  |
|12  |100 |112 | 
|0   |1234|1234|
|0   |  0 | 0  |
|4444|4444|8888|


