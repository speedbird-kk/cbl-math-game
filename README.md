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
PLEASE NOTE: The code in src/ is a working prototype. We have also developed a separate program towards the same goals in Experimentation/ folder, but the code in that package focuses more on applying SOLID design principles, design patterns and program architecture. It is the result of what we have learned about these topics, however the program itself is not working yet. It is incomplete. For a working version, please refer to the code in src/.

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

We made sure that each class knows only about one thing and has only a single responsibility or reason to change. From the start, the architecture of the program was designed so that the logic of the game is decoupled as much as possible from the GUI of the game. The event driven architecture played a large role in enabling this as well, since it enabled GUI classes to be decoupled from their corresponding logic classes by having both communicate with the mediator, an event broker that receives and notifies events, instead of with each other. Styling elements were decoupled as well by grouping all styles in a single utility class.

#### 2. Open Closed Principle (OCP)

Components of the program are designed to be open for extention but closed for modification. For example, the level strategy pattern enables this by breaking down each level into separate strategy classes. This means that if new levels or modes are to be added, this can be easily done by simply adding a new strategy class rather than needing to modify any existing classes. The same can be said for the state pattern with game modes and other game states.

#### 3. Liskov Substitution Principle (LSP)

Inheritance structures created in the program were done with consideration for the LSP to ensure that subtypes are substitutable for their base types. An easy way to see this is that there are no places in the program where it was necessary to check subtypes using `instanceof`, use down casts or to make it illegal to call a super method on a subclass. More specifically, at one stage of the design it was considered to make separate `RedBlock` and `NormalBlock` subtypes for the basetype `Block`. However, this was not done, opting instead for a simple `boolean isRed` attribute because doing so would have necessitated an `if (Block block instanceof RedBlock)` check to decide if a block reaching the bottom of the lane should remove all hearts or only one hearts, thereby violating the LSP as `RedBlock` is not substitutable for `Block`. Another example is the block creation strategy pattern to generate blocks with correct numbers according to which lane it is on. Different lanes are subtypes of the base type `Lane`, so there was the risk that we would need `instanceof` checks to see which lane the block was on. This was avoided by generating new blocks using a strategy pattern instead. On Java 21+, switch pattern matching could also be used, though this is not available on Java 17.

#### 4. Dependency Inversion Principle (DIP)

As much as possible, dependencies were made so that modules do not depend on volatile concrete classes. Modules in general depend on abstractions and details depend on abstractions. This can be clearly seen on the UML diagram which illustrates the direction of dependency well. Most arrows are pointing towards abstractions, that is, abstract classes or interfaces. Interfaces on context classes were created to avoid the clients depending on the context classes themselves but rather on the interface abstraction. For example, the abstract `Lane` class depends on the interface `BlockCreaterStrategy` rather than on any concrete strategies and `BlockCreatorStrategy` itself depends on the interface `LevelBlockCreatorContext` rather than on its implementation `LevelContext`. The event driven architecture is also an example of this as all components that subscribe to events or publish events are dependent on the abstraction, that is the event broker, rather than on volatile concrete classes, that are each other.

#### 5. Interface Segregation Principle (ISP)

The architecture was designed so that clients do not, in general, depend on methods that they do not need to use or know about. This is achieved by having a fat class with many methods, such as `LevelContext` and `GameContext` implement interfaces that can control which methods of the classes to expose to clients. For example, `LevelStrategy` only needs the `getLanes()` method from `GameContext` and so `GameLevelStrategyContext` interface exposes only that method of the `GameContext` to the client, `LevelStrategy`. Similarly, `LevelBlockCreatorContext` is an interface that exposes only the necessary methods of `LevelContext` for its client the `BlockCreatorStrategy`.

Below is a summary of the main design patterns used in the program.

#### 1. State

The state pattern is used to define several game states that define the current panel displayed on the frame and certain parameters of the game. The states in the game are `ModeOneState`, `ModeTwoState`, `LevelTransitionState`, `NoHeartsState`, `PauseState`. The states all implement an interface state with a handle method that is in an aggregation relationship with a context.

#### 2. Strategy

The strategy pattern is similar to the state pattern and is used in a few locations in the program. A variation of the strategy pattern where the context passes itself as the argument of the strategies was used, mostly so that the concrete strategies could alter the field values of the context according to the specific strategy. Specifically, a strategy pattern was used to define various game parameters such as the possible numbers on the block and the speed of the block for each level. A strategy pattern was also used to create blocks with the appropriate number for each type of lane. Strategies define families of algorithms. Each strategy can thus implement a different variation of the algorithm through polymorphism, in this case enabling the levels to compute and change game parameters according to the level, for instance.

#### 3. Factory

The factory design pattern is useful when needing to instantiate objects without knowing the concrete type at runtime. In fact, javax.swing also uses the factory pattern, for example for creating borders with the `BorderFactory`. Our implementations of the factory pattern include one for generating lanes and one for creating new windows. For each concrete product, that is for example the concrete type of lane class of the base type `Lane`, a factory method is defined in its corresponding factory class which extends the abstract `LaneFactory`. In the case of lanes, the factory method also takes a parameter for the operand. Similarly, abstract class `WindowFactory` declares a factory method implemented by each of the concrete window creators and `GameWindow` provides an interface for each of the concrete products, the windows such as `ModeOneWindow` and `TitleScreenWindow`. 

#### 4. Singleton

Singletons are useful when a globally shared single instance should be used for a type. In this program, `EventBroker` and `GameProgress` are singletons. Only one instance is required of each so that every module dependent on the singletons refer to the same object and hence they are a global class. This makes sense, as there should only be one instance of all the game progress attributes such as the score and current level, and one broker to receive events and publish events to all subscribers. Singletons are achieved in Java by making the constructor private, declaring an instance constant of its own type and creating a `getInstance()` method that returns it.

#### 5. / 6. Observer and Mediator

Observer patterns are essential for bridging together the decoupled systems of the logic and the GUI to have them come together in the swing loop. Certain events such as a correct answer, a block hitting the bottom of the lane, a level up, a score changing and so on need to trigger another component to act on it and modules of the GUI and its corresponding logic module must have the same state. For example, the score in `GameProgress` must reflect the score displayed in `ScoreLabel` GUI and vice versa. Ideally, this is done without coupling the two modules with each other. The mediator pattern allows us to do this, as instead of having modules communicate with each other, we have a central module which handles all communications. In particular, we used an adaptation of the observer and mediator pattern combined from the Design Pattern books, looking into alternatives specifically for event driven design. Here, components are able to publish events to an event broker which keeps a list of subscribers to each event. When events are published by the publishers, the broker looks through the list of all components subscribed to that event and notifies all of them. In our implementation a `Consumer` functional interface is used so that the broker can directly invoke the subscribers' methods for each event type.