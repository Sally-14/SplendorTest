# SplendorTest
Write test cases for implementation of the splendor card game

White Box Test Results: 

Tokens Class:
- Bad name since tokens only contains 1 token  
- constructor does not check for validity of color 
- returnColor returns invalid color as yellow
- incorrect spelling of Ruby (program spells rubby) 
- compareTo is color case sensitive (Sapphire vs. sapphire)

1 branch and 1 statement missing in returnColor method (90% branch convergence and 94% line coverage) on Jacoco report due to fault in code 
	- the branch and statement covered in a failing test case (the ruby returnColor testCase) 
As a result 97% line coverage and 90% branch coverage overall 

Cards Class: 
- Bad name since cards only contains 1 cards  
- Constructor does not check for invalid arguments 
	valid card names: mines, transportation methods, and artisans 
- Set resource doe snot check for invalid arguments 
- ToString miss-spelled Ruby
- CompareTo make sure that the two objects have at least one common out of resource, name, and point (might not be a good comparison; also care about cost) 
- SetCost does not function properly 

1 branch and 1 statement unreached in CompareTo on Jacoco report due to fault in code 
  - the branch and statement was covered in two failing test cases (compareTo with not matching resource, matching name, returns true) 
As a result, 97% branch coverage, 97% statement coverage 

Noble Class: 
- Constructor does not check for invalid cost 
- 100% statement coverage and 100% branch coverage
