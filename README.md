# BlackjackProject

## Project Description
This project learning objectives were to improve object-oriented class structures and to improve comfort with building casses with object fields. Enum class types were introduces. I was meant to focus on using collections to organize and manage data and it forced me to focus on having strong logic to facilitate a gameplay that feels real.

This program runs like a real game of Blackjack between the user and the Dealer(computer). The initial cards are instantiated, dealt and the user is faced with a decision period where they can either hit and stand. When they're satisfied with the hand, the game moves into dealer runnout mode where the dealer follows casino logic of value<17=hit. Once the dealer is at a value > 17, the win/loss logic is applied and a message is delivered to the user on the results.

## Class Descriptions
Classes were created to define what a card is, what a deck is and how they interact together in a hand. I created a dealer and player class who woud each have their own hand, and the dealer is able to manipulate the deck. The app itself is where all other method calls occur in a non-static method to drive the game itself.

## What I learned
This  game was a challenge to build. I am still building confidence with collections and referencing multiple collections and methods over multiple classes is still a slow process. Through this coding project, I'm building my confidence in being able to abstractly maintain objectives and objects to have an action occur in the proper space/class (i.e. the dealer shuffles the deck. The player adds a card to their hand, etc.). I also tried to focus on making my code dry, minimizing my main method and having readable code. I aimed for the stretch goal of having "soft aces". While it would make the MOST sense to have this happen at a card level, I'm not savvy enough yet for all the code and calls that would happen in the given timeframe so I tried to "hack" it in the "getHandValue" method by subtracting 10 points from the players hand IF they go over 21 AND they have an ace in their hand. It works every time, however, if the player has multiple aces, it subtracts 20 points which doesn't happen often and can lead to a loss when in real life the player would win. I left this in because that instance is infrequent and having that "soft ace" logic is much more frequent making for a more "real life" feel to the game.

## How to run
This program was made to run in an IDE console. Just download, import and run.

## Technologies used
Java, Eclipse, Git
