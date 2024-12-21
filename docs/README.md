## LDTS_1305 - Survivor
Survivor is a game inspired by the Survivor.io and the Realm of the Mad God games, but with a few twists. The objective of the game is to maneuver a character, the protagonist, through a series of waves of enemies coming from everywhere.

Each enemy, when killed, drops an item\coin that the player can pick up. later in the game the player will have opportunities to upgrade their weapons or craft new ones using those items\coins. The game ends when the player's health bar drops to 0.

Be aware that Survivor is an addictive game that tests the player's IQ, reflexes, instincts and patience. It's a great way to challenge yourself.

Lecturer:
- **José Carlos Medeiros de Campos** 

Developed by:

- **Diogo Sousa Campeão** (up202307177)
- **Hugo Miguel Gomes Silva** (up202307383)
- **Tomás Costa Barros** (up202303664)

LDTS 24/25

## Implemented Classes
- Our game for now just represents an arena, with a survivor and some monsters going after the survivor trying to damage him.
- **Survivor**
    - **Health** - Add functioning health.
    - **Movement** - Implement proper movement. Preferably not dependent on FPS.
    - **Firing** - Make the survivor be able to fire.
    - **Leveling** - Add experience and level to the player and define experience requirements for level-up.
- **Projectile**
    - **Function** - Implement properly working projectiles.
- **Monsters**
    - **Health** - Add functioning health.
    - **Damage** - Make monster be able to attack and deal damage to the survivor.
    - **Spawn** - Add proper random spawning of monsters.
    - **Movement** - Add proper monster movement with monsters targeting the survivor and walking towards him.
- **Menu**
    - **Start** - Add start menu.
    - **Class and weapon** - Add a menu for selecting class and weapon.
    - **Pause** - Add a pause menu.
     
- <img width="1257" alt="image" src="https://github.com/user-attachments/assets/fa02266a-227f-43d9-a034-f343b25d266b">


## Planned Features
- **Survivor**
    - **Debuffs** - Add debuffs to the player, such as slowing down when hit.
    - **Level-Up rewards** - Add rewards for leveling up such as increased firing, health and damage.
- **Projectile**
    - **Variety** - Add different projectiles for all weapons.
- **Monsters**
    - **Difficulty** - Make monsters have more health and deal more damage depending on level.
    - **Drops** - Add monster drops such as experience to level-up the player.
- **Arena**
    - **Lobby** - Add a lobby to select the map prior to starting the game.
- **Viewer**
    - **HUD** - Enhance the existing hud and add a level progress bar.
    - **Textures** - Create proper textures for the survivor, monsters, weapons and projectiles.
    - **Background** - Add a map background, preferably multiple maps to choose from.
- **Controller** - Implement controllers for all model classes.

## Mockups
![mockup1](https://github.com/user-attachments/assets/b2a51856-aaac-4c79-80f9-05b5da5c42b7)
![mockup2](https://github.com/user-attachments/assets/392be7e4-d0e9-4384-8efa-e6899e9bb589)
![mockup3](https://github.com/user-attachments/assets/c32a3078-6c63-4199-922e-3b8d5401bfd0)
![mockup4](https://github.com/user-attachments/assets/7948767a-c8fd-4e58-8506-8010fb2285d1)



(Screenshots of the game)

## UML 
<img width="1190" alt="image" src="https://github.com/user-attachments/assets/e7814c6e-edb5-4f52-a6de-332042bb7ddb">

## Patterns Used
Structure of the code
### The Pattern: Model-View-Controller (MVC)
![MVCSchema](https://github.com/user-attachments/assets/d9b8a570-0ca4-4844-86be-3a3fe711fc48)

#### Motivation

With MVC, we can separate the game's logic into 3 distinct components, making it easier to test and maintain the code. In future implementations, makes it easier to implement new features and functionalities. Here's how it works:
#### Model: Responsible for Data Management in the project. Present in Arena, Survivor, etc.
#### View: Responsible for rendering the Elements into the screen. Present in Viewer, GameViewer, SuvivorViewer, etc.
#### Controller (Not implemented yet): Responsible for managing the interactions and game logic. Present in Controller, ArenaController, etc.

### The Pattern: State Pattern

<img width="800" alt="image" src="https://github.com/user-attachments/assets/a3df5fba-953c-491d-9f64-caa353938da3">

#### Motivation

State pattern is used for managing game and menu states. It simplifies transitions between states by encapsulating the behaviour of each State in its Class and makes it simple to add new states and behaviours by simply adding more classes for each state added. For testing, having various states doing specific things, makes it easier to debug and test. Here's how we did it:
#### State interface: Provides a common structure (STATE) that all specific states inherit. 
#### Specific states: Implement a specific behaviour for the game.

### The Pattern: Composite Pattern
<img width="668" alt="image" src="https://github.com/user-attachments/assets/a8b35ad2-223e-464b-b76f-5fcd12738a7c">
<img width="533" alt="image" src="https://github.com/user-attachments/assets/d7b8d99d-8fa7-40ab-a682-1f4d4d7666e1">

#### Motivation

Composite pattern allows us to represent different collections of game elements, such as Entities, Projectiles, Weapons, in a uniform way, allowing us to handle specific objects such as Bow, Pistol and specific types of Monster in a consistent and uniform way. Here's how it works:
#### Base class for all components: Element
#### Leaf classes for specific elements: Entity (has health), Monster, Projectile, Collectible

#### Future pattern implementation
We will implement patterns such as Observer, to react to changes in the game, and Factory, to create the different types of Monster and the different customizations of the Surivor class.


## Testing
Jacoco Report
<img width="1190" alt="image" src="https://github.com/user-attachments/assets/31f7b7b8-70fa-4ce2-ac76-b3b9f06c65ef">
Pitest Report
<img width="1077" alt="image" src="https://github.com/user-attachments/assets/fede68b4-bcf1-491f-824d-1bb4cbc6c2ca">



