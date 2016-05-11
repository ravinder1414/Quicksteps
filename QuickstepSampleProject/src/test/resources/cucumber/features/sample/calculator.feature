Feature: Math.com simple calculator

In order to get answers to my mathematical questions
As a user of Math.com
I want to be able to use the simple calculator

Scenario Outline: Basic calculation
Given I am a user of Math.com using the simple calculator
When I calculate "<x><op><y>"
Then I should see the answer <answer>

Examples:

| x | op | y | answer |
| 5 | +  | 2 |   7    |
| 9 | -  | 1 |   8    |
|11 | *  | 6 |  66    |
|12 | /  | 6 |   2    |
|1  | /  | 0 |Infinity|
