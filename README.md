# SplendorTest
Write test cases for implementation of the splendor card game

#Subject
- In this project, we aim to test a computer implementation of the resource management game Splendor by z1103246. Splendor is a board game designed to be played by between 2-4 players and recommended for any interested player age 10+. The rules for the game play can be found here: https://cdn.1j1ju.com/medias/7f/91/ba-splendor-rulebook.pdf.

- The game is written in Java and contains a text-based terminal interface and a gui interface. The project has a total of 3579 lines of code, 3473 of which is Java code. Below are more detailed breakdown of the language that the project contains:

- The project contains 17 classes and 171 methods [17 (Cards), 46 (Game), 10 (GraphicInterface), 1 (MyFrame), 9 (MyPanel), 14 (Noble), 48 (Player), 19 (TextBasedInterface), 7 (Tokens)].

- We test the program using the following testing strategies:
- Systematic blackbox testing facilitated by the rulebook for Splendor
- Systematic whitebox unit testing
- Mutation testing using PIT

- We will not need to do load testing because Splendor is designed to only have 2-4 players. Mock testing is also not necessary because development of the entire game is finished and it will not interact with new classes or methods in the future. GUI testing is also not needed because the graphical interface is not interactive.

| Task       |  GitHub Username |
| ----       | --------------- |
| White box Testing   |   100% method coverage, 90%+ branch coverage     |
| Black box Testing  |   100% rule coverage    |
| Mutation Testing  |   80% mutation coverage    |

# White Box Test Results: 

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

# Black Box Test Results:

- 100% coverage of the rules from the Splendor rule book

- When we are using system.in to read Buffered Input Stream, we wrote one input of scanner array interacting with text-based interface. The No line found error is keep popping out. It is probably because the author initialize multiple scanner which the initial scanner (with all inputs) could not continue to be used. I have to separate the input into multiple scanner.

- If players choose the second option: Take 1 token from each of 3 different types of tokens(excluding gold). If the player chooses the same token repetitively, the error was correctly showing up but it continue to show the conversation even the user input is correct: Choose another different token that you have not selected. 1. Onyx x4 2. Sapphire x4 3. Emerald x4 4. Diamond4 5. Rubby x4 6. Gold x4

- According to the rule 2, To reserve a card, a player simply needs to take a face-up development from the middle of the table or (if you’re feeling lucky) draw the first card from one of the three decks without showing it to the other players. If user choose to reserve a development car a card on the table and receive one gold token, "Which card do you wish to reserve? 1. Blue Card 1 *** 2. Blue Card 2 *** 3. Blue Card 3" You cannot know which Jeweries required for each card. The possible issue here is the incompleteness of the rules.

- According to the rule 3, Reserving a card is also the only way to get a gold token (joker). If there is no gold left, you can still reserve a card, but you won't get any gold. but in the second round for player to choose token, Choose another different token that you have not selected. 1. Onyx x3 2. Sapphire x3 3. Emerald x3 4. Diamond4 5. Rubby x4 6. Gold x3

- When choosing option 2: Take 1 token from each of 3 different types of tokens. The test input is Diamond and Rubby. It is not repeated but it shows "Choose another different token that you have not selected".

- Based on the game rule: 90 development cards: 40 level 1, 30 level 2, and 20 level 3. Based on the blackbox testing, only one card for each card deck Blue Deck, Yellow Deck, Green Deck. If the player 2 reserve one Blue Deck, one Yellow Deck, one Green Deck. It will show "The deck you chose ran out of cards. Please choose another one."

- There is no way to end or quit the game. The graphical interface is not able to interact with.

- End game test case could never be reached because the limitation of tokens and development cards limitation.

- When selecting tokens, the number of token never drops until the next round. For example, player choose option 2, selecting Onyx x1 ,Sapphire x1 and the number of Onyx and Sapphire should drop but it never did.