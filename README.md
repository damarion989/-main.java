# Factory Patterns Journal

## Phase 1

Moving object creation into SimpleEnemyFactory decouples the main method from concrete enemy classes because main asks the factory for an Enemy instead of directly creating Goblin or Skeleton objects. To add a Slime later, I would create the Slime class and add it to the factory.

## Phase 2

Inheritance allows each EnemySpawner subclass to decide which enemies belong in its level. A new level such as MountainSpawner could extend EnemySpawner and create its own enemies without changing ForestSpawner or DungeonSpawner.

## Phase 3

The Abstract Factory pattern guarantees compatible equipment because each equipment factory creates a matching set. The WarriorEquipmentFactory creates a Sword and PlateArmor, while the MageEquipmentFactory creates a Staff and Robe.

## Phase 4

The main method uses EnemySpawner and Enemy reference types instead of depending on concrete enemy classes. This makes the program easier to maintain because new enemies, spawners, and equipment families can be added without changing the high-level game logic.
