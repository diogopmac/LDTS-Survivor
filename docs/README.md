## LDTS_1305 - Survivor

In this game you're the last survivor after an apocalipse. How will you stay alive?

Survivor is a game where you control the main character (the Survivor) in a post apocalyptic arena filled with monsters. In the start you can choose your class, that will affect your special ability that can be used during the game.
#### Warrior: Has increased damage for 7 seconds
#### Mage: Activates a shield that makes you immortal for 5 seconds
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
- **Leveling Upgrades** - Whenever the player levels up the user can choose wich upgrade they want.
- **Weapon and Class choice** - Before starting the game the user can choose wich class and weapon they want to play with.
- **Visual Feedback** - Whenever an ability is used and it has a duration the survivor changes color to indicate to the user that the ability is active.
- **Hud** - The hud has multiple stats showing up. It shows the player's health, damage, fire rate, level, necessary experience to level up and ability cooldown.
- **Collisions** - Every collision in the game works as expected. The player cant leave the arena, monsters and the survivor collide with other monsters.
- **Controls** - A controls menu is present to inform the user wich keys are used to control the survivor.
     
- <img width="1257" alt="image" src="https://github.com/user-attachments/assets/fa02266a-227f-43d9-a034-f343b25d266b">


## Planned Features
#### Although for the most part the game is working as expected and most planned features were implemented there were some things we couldn't do in time.
- **Sound** - The game currently lacks any sound feedback, when a monster is killed, damage is taken or menu is accessed.
- **Images** - The game currently is lacking in visuals. Both the survivor, the monsters and the projectiles are just characters, a font or images could be used to improve the game's graphics.

## Mockups
![mockup1](https://github.com/user-attachments/assets/b2a51856-aaac-4c79-80f9-05b5da5c42b7)
![mockup2](https://github.com/user-attachments/assets/392be7e4-d0e9-4384-8efa-e6899e9bb589)
![mockup3](https://github.com/user-attachments/assets/c32a3078-6c63-4199-922e-3b8d5401bfd0)
![mockup4](https://github.com/user-attachments/assets/7948767a-c8fd-4e58-8506-8010fb2285d1)



(Screenshots of the game)

## UML 
<img width="1190" alt="image" src="https://github.com/user-attachments/assets/678c7c19-7a5c-41ca-abbc-454f65aef54a">

## Patterns Used
### Structure
Two main patterns were used throughout our project. One architectural: Model-View-Controller and the State Pattern that enables objects to change their behaviour based on their internal state.
#### Model-View-Controller
![MVCSchema](https://github.com/user-attachments/assets/d9b8a570-0ca4-4844-86be-3a3fe711fc48)

#### Motivation

With MVC, we can separate the game's logic into 3 distinct components, making it easier to test and maintain the code. In future implementations, makes it easier to implement new features and functionalities. Here's how it works:
#### Model: Responsible for Data Management in the project. Present in Arena, Survivor, etc.
#### View: Responsible for rendering the Elements into the screen. Present in Viewer, GameViewer, SuvivorViewer, etc.
#### Controller: Responsible for managing the interactions and game logic. Present in Controller, ArenaController, etc.

### State Pattern

<img width="800" alt="image" src="https://github.com/user-attachments/assets/a3df5fba-953c-491d-9f64-caa353938da3">

#### Motivation

State pattern is used for managing game and menu states. It simplifies transitions between states by encapsulating the behaviour of each State in its Class and makes it simple to add new states and behaviours by simply adding more classes for each state added. For testing, having various states doing specific things, makes it easier to debug and test. Here's how we did it:
#### State interface: Provides a common structure (STATE) that all specific states inherit. 
#### Specific states: Implement a specific behaviour for the game.

### Composite Pattern
<img width="668" alt="image" src="https://github.com/user-attachments/assets/a8b35ad2-223e-464b-b76f-5fcd12738a7c">
<img width="533" alt="image" src="https://github.com/user-attachments/assets/d7b8d99d-8fa7-40ab-a682-1f4d4d7666e1">

#### Motivation

Composite pattern allows us to represent different collections of game elements, such as Entities, Projectiles, Weapons, in a uniform way, allowing us to handle specific objects such as Bow, Pistol and specific types of Monster in a consistent and uniform way. Here's how it works:
#### Base class for all components: Element
#### Leaf classes for specific elements: Entity (Element with health), Monster and Survivor (Specific entities), Projectile, Bow, Pistol and Sword (Different weapons used by the Survivor), etc.

### Factory

### Builder

## Known code Smells
All major bugs that affect playability have been patched. Although there are some bugs present that were not fixed because we didn't think they affected the game enough to be worth trying to fix them.

### Monster "Dodge"
When a monster moves at the exact moment a projectile hits him he "dodges" the projectile and does not receive damage.

### Rogue teleport
If a rogue teleports and lands exactly where a monster is the game won't prevent hit and the Survivor will be placed on top of the monster. This does not delete the monster nor does it affect the game, that's why it wasn't patched. With some time and better structuring it wouldn't be hard to fix.

## Testing
Jacoco Report
<img width="1190" alt="image" src="https://github.com/user-attachments/assets/31f7b7b8-70fa-4ce2-ac76-b3b9f06c65ef">
Pitest Report
<img width="1077" alt="image" src="https://github.com/user-attachments/assets/fede68b4-bcf1-491f-824d-1bb4cbc6c2ca">




