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

MyFrame Class: 
- 100% statement coverage (branch coverage N/A)

Game Class: 
- Constructor takes in an arraylist of winners?
- GetDeck does not check for validity of arguments (returns yellow deck for invalid strings)
- GetRandom does not check for validity of argument (returns yellow deck for invalid strings; comment says //enter blue, yellow, or green. NOTHING ELSE REMEMBER, but does not check for validity)
- updatePlayers does not check for validity of argument (does not check if player exists and does not throw exception)
- differentColors contains for-loop indexing error (loop does not reach last element)
- win always returns true regardless of if the game is won 
- checkActionTwo always returns true 
- checkActionTwo does not check arguments to make sure the two tokens are of different colors
- checkActionTwo does not check arguments to make sure the use is not taking a gold token 
- checkActionThree allow row argument to be 4 
- checkActionThree String version does not throw Player Already Holds Three Reserve Cards exception
- checkActionThree String version allows Player to add another card in reverse when the Player have three cards reserved
- checkActionThree String version does not check for validity of string argument (i.e. purple, greenyellow)
- checkActionThree String version does not handle capitalized string
- checkActionFive does not throw error when column is boundary bad case (4) 
- toString does not handle uninitialized variables from simple constructor 
- toString deck loop hard coded does not work with decks with less than or greater than 4 cards on the table

checkActionTwo: 50% branch coverage due to unreachable code 
checkActionThree: 90% branch coverage because some failing tests excluded from jacoco report

Player Class: Partially tested!!! Incomplete
- nobleVisit does not consider number of card (only considers if they have the card)
- visit does not check for invalid int argument
- visit does not check for no possible visiting nobles
- getTwoTokens have random print statements
- getOneOfEachTokens does not check if the token is available 
- containsAll does not consider duplicates
- removeAll always returns true 
- can buy with yellow only takes "gold" not anything else 
- can buy does not check the counts of each color token

MyPanel Class: 
- Did not unit test draw 
- Did not unit test mouse clicked
100% branch and statment coverage for rest of methods 

Invalid Cards Selection Of Cards In Reserve not tested !!!

Invalid Tokens Selection Exception covered
Player Does Not Have Selected Card In Reserve Exception covered
Player Does Not Have Enough Resources To Buy Selected Card Exception covered
Selected Deck Ran Out Of CARDS Exception covered 
Not Enough Tokens On Table Exception covered 
Player Already Holds Three Reserve Cards covered 
Invalid Cards Selection Of Cards On Table covered 

Black Box Test Results:
- When we are using system.in to read Buffered Input Stream, we wrote one input of scanner array interacting with text-based interface. The No line found error is keep popping out. It is probably because the author initialize multiple scanner which the initial scanner (with all inputs) could not continue to be used. I have to separate the input into multiple scanner.

- If players choose the second option: Take 1 token from each of 3 different types of tokens(excluding gold). If the player chooses the same token repetitively, the error was correctly showing up but it continue to show the conversation even the user input is correct: Choose another different token that you have not selected. 1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4