# Prototype Design Pattern


### Why It's called Prototype
- The Prototype pattern is named so because it allows you to create a new object by cloning an existing prototype and modifying only what’s necessary.
It’s like using a template (prototype) to create multiple similar objects with small variations.

## What's the problem in tradiitonal way?

```Java
public class Character {
  private String name;
  private int health;
  private int attackPower;
  private int level;
  public Character(String name, int health, int attackPower, int level) {
    this.name = name;
    this.health = health;
    this.attackPower = attackPower;
    this.level = level;
  }
  public void showCharacterInfo() {
    System.out.println("Character [Name=" + name + ", Health=" + health
        + ", AttackPower=" + attackPower + ", Level=" + level + "]");
  }
}

public class CharacterFactory {
  // Creating a new character each time with similar attributes
  public Character createCharacterWithNewName(String name) {
    // Creating a new character with the same attributes, just changing the name
    return new Character(name, 100, 50, 1); // Default attributes for simplicity
  }

  public Character createCharacterWithNewLevel(int level) {
    // Creating a new character with the same attributes, just changing the
    // level
   return new Character(
        "DefaultName", 100, 50, level); // Default name and attributes
  }

  public Character createCharacterWithNewAttackPower(int attackPower) {
    // Creating a new character with the same attributes, just changing the
    // attack power
    return new Character(
        "DefaultName", 100, attackPower, 1); // Default name and level
  }
}

public class CharacterFactory {
    // Too many methods for every small change
    public Character createCharacterWithNewName(String name) {
        return new Character(name, 100, 50, 1);
    }

    public Character createCharacterWithNewLevel(int level) {
        return new Character("DefaultName", 100, 50, level);
    }

    public Character createCharacterWithNewAttackPower(int attackPower) {
        return new Character("DefaultName", 100, attackPower, 1);
    }

    public Character createCharacterWithNewHealth(int health) {
        return new Character("DefaultName", health, 50, 1);
    }

    // More and more methods for every possible variation...
}

```

- This approach quickly becomes hard to maintain and scalable. We end up creating a bunch of methods for every small change, which makes the code harder to read and manage.
- Code Duplication, Inefficient, Hard TO Maintain.


## How to fix it

```Java
public class Character implements Cloneable {
    private String name;
    private int health;
    private int attackPower;
    private int level;

    public Character(String name, int health, int attackPower, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.level = level;
    }

    @Override
    public Character clone() throws CloneNotSupportedException {
        return (Character) super.clone(); // Shallow copy of the character object
    }

    public void showCharacterInfo() {
        System.out.println("Character [Name=" + name + ", Health=" + health
            + ", AttackPower=" + attackPower + ", Level=" + level + "]");
    }
}

// Cloneable Interface:
// The Character class implements the Cloneable interface. This is necessary because Java’s Object class provides a clone() method that can be used to clone objects, but this method only works if the class explicitly implements Cloneable.
```
- Cloning the Prototype in the Factory
  Now, let’s see how we can use this clone() method to solve the problem of creating new characters that are similar to an existing prototype but with some modifications:

```Java
public class CharacterFactory {
    private Character prototypeCharacter;

    // Constructor to create a prototype character (default character)
    public CharacterFactory() {
        prototypeCharacter = new Character("DefaultName", 100, 50, 1); // Default prototype character
    }

    // Create a character by cloning the prototype and changing only the required attributes
    public Character createCharacterWithNewName(String name) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(name, clonedCharacter.health,
            clonedCharacter.attackPower, clonedCharacter.level);
        return clonedCharacter;
    }

    public Character createCharacterWithNewLevel(int level) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(clonedCharacter.name,
            clonedCharacter.health, clonedCharacter.attackPower, level);
        return clonedCharacter;
    }

    public Character createCharacterWithNewAttackPower(int attackPower) throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(clonedCharacter.name,
            clonedCharacter.health, attackPower, clonedCharacter.level);
        return clonedCharacter;
    }
}
```

• Prototype Object:
 - In the CharacterFactory constructor, we create a prototype character that serves as the template. This character is used as the base for creating new characters.
```prototypeCharacter = new Character("DefaultName", 100, 50, 1);  // Default prototype character```

• Cloning and Modifying:
- The createCharacterWithNewName, createCharacterWithNewLevel, and createCharacterWithNewAttackPower methods all clone the prototype character using the clone() method. After cloning, we modify only the attribute that needs to change (like name, level, or attackPower), while the rest of the attributes remain the same.
For example, to create a new character with a new name:
```Java
public Character createCharacterWithNewName(String name) throws CloneNotSupportedException {
  Character clonedCharacter = prototypeCharacter.clone();
  clonedCharacter = new Character(name, clonedCharacter.health, clonedCharacter.attackPower, clonedCharacter.level);
  return clonedCharacter;
}
```






