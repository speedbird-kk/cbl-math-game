# cbl-math-game
Falling math not failing math !

In order to run the game go to the src/ folder and run the main function of Main.java

The game has a title screeen with a button that starts the game. While the game runs, blocks fall on 4 lanes and
the player must input the correct number that, when the operation is applied to it, results the number on the block.

Features to test: 
- Blocks dissapear when correct number is inputed
- Hearts dissapear when blocks hit the bottom
- When hearts are depleted the game over screen is displayed
- The blocks become faster and the numbers become more difficult over time

## Developer Notes

Our two chosen topics were UML class diagrams and design patterns.

### Design patterns

The program implements 6 main design patterns.
1. State (Behavioural)
2. Strategy (Behavioural)
3. Factory (Creational)
4. Singleton (Creational)
5. Observer (Behavioural)
6. Mediator (Behavioural)

In addition, we implemented an event driven architecture through combining and adapting the Observer and Mediator patterns.

Consideration was put into complying with the SOLID design principles. Here are a few examples of design choices made in the program to ensure compliance with each of the design principles.

#### 1. Single Responsibility Principle (SRP)


#### 2. Open Closed Principle (OCP)

#### 3. Liskov Substitution Principle (LSP)

#### 4. Dependency Inversion Principle (DIP)

#### 5. Interface Segregation Principle (ISP)

