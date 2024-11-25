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

### Implemented Classes
- **Model** - Model for all classes in the game implemented
    - **Element** - Super Class for all viewable elements in the game.
    - **Entity** - Super Class for all elements that have health in the game. Inherits from Element.
    - **Survivor** - Playable character in our game. For now, has a position and health. Inherits from Entity
    - **Monster** - Enemy in the game. For now, only has position and health as well. Inherits from Entity
    - **Collectible** - Super Class for all elements that can be aquired by the player. Inherits from Element
    - **Projectile** - Super Class for all elements that are launched on the screen.
  (TODO COMPLETE)

### Planned Features
- **Survivor**
    - **Health** - Add functioning health.
    - **Movement** - Implement proper movement. Preferably not dependent on FPS.
    - **Firing** - Make the survivor be able to fire.
    - **Debuffs** - Add debuffs to the player, such as slowing down when hit.
    - **Leveling** - Add experience and level to the player and define experience requirements for level-up.
    - **Level-Up rewards** - Add rewards for leveling up such as increased firing, health and damage.
- **Projectile**
    - **Function** - Implement properly working projectiles.
    - **Variety** - Add different projectiles for all weapons.
- **Monsters**
    - **Health** - Add functioning health.
    - **Damage** - Make monster be able to attack and deal damage to the survivor.
    - **Spawn** - Add proper random spawning of monsters.
    - **Difficulty** - Make monsters have more health and deal more damage depending on level.
    - **Movement** - Add proper monster movement with monsters targeting the survivor and walking towards him.
    - **Drops** - Add monster drops such as experience to level-up the player.
- **Arena**
    - **Lobby** - Add a lobby to select the map prior to starting the game.
- **Menu**
    - **Start** - Add start menu.
    - **Class and weapon** - Add a menu for selecting class and weapon.
    - **Pause** - Add a pause menu.
- **Viewer**
    - **HUD** - Enhance the existing hud and add a level progress bar.
    - **Textures** - Create proper textures for the survivor, monsters, weapons and projectiles.
    - **Background** - Add a map background, preferably multiple maps to choose from.
- **Controller** - Implement controllers for all model classes.

### Mockups
![mockup1](https://github.com/user-attachments/assets/b2a51856-aaac-4c79-80f9-05b5da5c42b7)
![mockup2](https://github.com/user-attachments/assets/392be7e4-d0e9-4384-8efa-e6899e9bb589)
![mockup3](https://github.com/user-attachments/assets/c32a3078-6c63-4199-922e-3b8d5401bfd0)
![mockup4](https://github.com/user-attachments/assets/7948767a-c8fd-4e58-8506-8010fb2285d1)



(Screenshots of the game)

### UML 
<img width="1190" alt="image" src="https://github.com/user-attachments/assets/e7814c6e-edb5-4f52-a6de-332042bb7ddb">

### Patterns Used
(Design usage)

### Testing
Jacoco Report
<img width="1190" alt="image" src="https://github.com/user-attachments/assets/31f7b7b8-70fa-4ce2-ac76-b3b9f06c65ef">
Pitest Report
<img width="1077" alt="image" src="https://github.com/user-attachments/assets/fede68b4-bcf1-491f-824d-1bb4cbc6c2ca">



