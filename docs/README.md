## LDTS_1305 - Survivor

In this game you're the last survivor after an apocalipse. How will you stay alive?

Survivor is a game where you control the main character (the Survivor) in a post apocalyptic arena filled with monsters. In the start you can choose your class, that will affect your special ability that can be used during the game.
#### Warrior: Has increased damage for 7 seconds
#### Mage: Activates a shield that makes the player immortal for 5 seconds
#### Rogue: Does a small teleport in front.

The class of the survivor also affects its health. Besides the class you can also choose your weapon.
#### Bow: The weapon with the longest range, slow fire rate and medium damage.
#### Pistol: Weapon with medium range, low damage but high fire rate.
#### Sword: The weapon with the smallest range but highest fire rate and damage.

You have to battle various waves of monsters with spawn rate, damage and health increasing as the player levels up.
When killing a monster the player gets some experience that enables him to level up. Whenever the player levels up he has a choice to increase the fire rate, damage or health. You have to choose wisely to be able to progress in the game and get to higher levels.

Lecturer:
- **José Carlos Medeiros de Campos** 

Developed by:

- **Diogo Sousa Campeão** (up202307177)
- **Hugo Miguel Gomes Silva** (up202307383)
- **Tomás Costa Barros** (up202303664)

LDTS 24/25

## Implemented Features
- **Working Menus** - All the menus are working correctly and are connected. The user can brouse through the pause, options, settings and main menu freely.
- **Game repeatability** - Whenever the player dies he can instantly restart the game and play again. Also, at any point in the game the player can leave to the main menu and start again with a different class or weapon.
- **Keyboard Control** - The game is controlled exclusively with the keyboard.
- **Player Control** - The user can make the survivor move, shoot and use abilities.
- **Monster Spawning** - Monster spawning is completely random. All the monsters spawn on the border of the map and the spawn rate is increased with player level.
- **Fully working leveling system** - As mentioned before, the player can level up and the player's level affects every aspect of the game. Such as monster damage, health and spawn rate.
- **Leveling Upgrades** - Whenever the player levels up the user can choose which upgrade they want.
- **Weapon and Class choice** - Before starting the game the user can choose wich class and weapon they want to play with.
- **Visual Feedback** - Whenever an ability is used and it has a duration the survivor changes color to indicate to the user that the ability is active.
- **Hud** - The hud has multiple stats showing up. It shows the player's health, damage, fire rate, level, necessary experience to level up and ability cooldown.
- **Collisions** - Every collision in the game works as expected. The player cant leave the arena, monsters and the survivor collide with other monsters.
- **Controls** - A controls menu is present to inform the user wich keys are used to control the survivor.
     


## Planned Features
All features were sucessfully implemented.

## Previews of the Game
### Main Menu
<img width="1257" alt="image" src="https://github.com/user-attachments/assets/2dd7273d-50ba-4dfb-ad7c-19c32fe1f1c4" />
### Game Preview
<img width="1254" alt="image" src="https://github.com/user-attachments/assets/09f01434-7130-443f-b83c-13fdfe23b2c9" />
### Level Up Menu
<img width="1259" alt="image" src="https://github.com/user-attachments/assets/b0a741ee-9721-415d-8599-b34c2cb8fec3" />
### Game Over Menu
<img width="1257" alt="image" src="https://github.com/user-attachments/assets/b13c5b32-4702-4236-8081-d1b473085e37" />
### Settings Menu
<img width="1257" alt="image" src="https://github.com/user-attachments/assets/694bf1bb-6d13-48d9-8cd3-f65e6ae37daf" />
### Controls Menu
<img width="1253" alt="image" src="https://github.com/user-attachments/assets/d849fbca-2816-4063-9bf6-dc03603446a1" />




## UML 
TODO
## Patterns Used
### MVC
#### Motivation
With the increasing complexity of the game itself, it became a must to separate different responsabilities in different locations of the code, so that we could separate different types of functions and responsabilities in the game.
#### The Pattern
For this, we used the **_Model-View-Controller_** Pattern. With MVC, we can separate the game's logic into 3 distinct components, making it easier to test and maintain the code. In future implementations, makes it easier to implement new features and functionalities. Here's how it works:
#### Model: Responsible for Data Management in the project. Present in Arena, Survivor, etc.
#### View: Responsible for rendering the Elements into the screen. Present in Viewer, GameViewer, SuvivorViewer, etc.
#### Controller: Responsible for managing the interactions and game logic. Present in Controller, ArenaController, etc.
![image](https://github.com/user-attachments/assets/339007e8-add4-4883-a6a0-935fb658cd5f)

### State Pattern
#### Motivation
The game can quickly transition from States. In every state, we need to have the correct behaviour, correct data and handle the inputs the correct way. For example, when the game is running and the game is paused, the behaviour shown is completely diferent from each.
#### The Pattern
**_State_** pattern is used for managing game and menu states. It simplifies transitions between states by encapsulating the behaviour of each State in its Class and makes it simple to add new states and behaviours by simply adding more classes for each state added. For testing, having various states doing specific things, makes it easier to debug and test, respecting SRP (Single-Responsability-Principle) and OCP (Open/Closed-Principle). Here's how we did it:

![state_ image](https://github.com/user-attachments/assets/947d75e7-a735-4e46-bbea-583f1e39b0d4)


### Factory
#### Motivation
With the implementation of Survivor classes and the configurations from the Settings menu, the step from the Main Menu to the Game can be different and the game can start in different forms, so, it was necessary to create the arena based on said configurations.
#### The Pattern
We used **_Factory_** pattern for this one, allowing us to create different arenas and begin the game with different selected weapons and classes, eliminating the need to bind specific classes into our code, and it only needs to deal with the ArenaFactory interface to create any Arena.
### Implementation
When we need to create an Arena, we call ArenaFactory, that calls ArenaBuilder, that creates the wanted arena with the current selected Class and Weapon. This respected SRP (Single-Responsability-Principle), ISP (Interface-Segregation-Principle) and OCP (Open/Closed Principle).
![factory_image](https://github.com/user-attachments/assets/10d3b234-b1d0-499e-b751-ca212c53e960)

### Singleton
### Motivation
The Settings Menu can change the way we play the game by changing the Class and Weapon we want to play with. There is not a direct transiction between Settings Menu and the actual game, you'll have to pass again by Main Menu. This would lose the configuration chosen by the user and start the game with the default settings
### The Pattern
To solve this problem, we used a **_Singleton_** GameConfig, responsible for saving and preserving the current options selected by the user.
### Implementation
The GameConfig starts with a default setting, ensuring that even if the game is started without changing anything, the game still works. In the Settings Menu, after a selection is made, the GameConfig saves the selected Class and Weapon. At game start, Arena Builder fetches the GameConfig options and starts the game based on them. We respected SRP (Single-Responsability-Principle) and DIP (Dependency-Inversion-Principle) with this solution.
![singleton_image](https://github.com/user-attachments/assets/04482886-15ee-4aab-8e14-e9111b189a68)



### Strategy
#### **Motivation:** 
With the implementation of Abilities in the game, it became necessary to ensure that if we needed to extend the game to have more player Classes, and therefore more Abilities (since every Survivor Class has an ability), we wouldn't need to modify any code, we just needed to add one more class and behaviour for said Ability.
#### The Pattern:
We've then applied the **_Strategy_** Pattern, allowing us to, when needed, execute the correct Ability behaviour, based on the selected Survivor class.
#### Implementation:
The AbilityCommand interface was created with a method use(), and a method update(). We created as well 3 different abilities, one for each class.
Implementation went well, since the methods from the interface can be called upon any situation or game configuration.
With this, we respected and went along with SRP (Single-Responsability-Principle), since every Ability executes it's specific behaviour, OCP (Open-Closed-Principle), because the code can be extended and more abilities can be added as we see fit.

![strategy_image](https://github.com/user-attachments/assets/ef95536d-940c-40b9-8dd0-367f538befc1)


## Known code Smells
All major bugs that affect playability have been patched. Although there are some bugs present that were not fixed because we didn't think they affected the game enough to be worth trying to fix them.

### Monster "Dodge"
When a monster moves at the exact moment a projectile hits him he "dodges" the projectile and does not receive damage.

### Rogue teleport
If a rogue teleports and lands exactly where a monster is the game won't prevent hit and the Survivor will be placed on top of the monster. This does not delete the monster nor does it affect the game, that's why it wasn't patched. With some time and better structuring it wouldn't be hard to fix.

## Testing
### Jacoco Report
<img width="1237" alt="image" src="https://github.com/user-attachments/assets/6852d6d6-2c5b-40a7-b889-a23fce47f974" />

### InteliJ Report
<img width="897" alt="image" src="https://github.com/user-attachments/assets/b8cfea27-7553-4a2b-8299-787dffa65e68" />

### Pitest Report
<img width="1085" alt="image" src="https://github.com/user-attachments/assets/41d84c6b-fb36-4312-97a5-7e302061a562" />





