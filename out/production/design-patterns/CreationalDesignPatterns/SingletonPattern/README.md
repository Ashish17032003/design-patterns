# Singleton Design [Pattern
- The Singleton Pattern ensures that only one instance of a class is created throughout the application and provides a global access point to that instance.
### ✅ Why Use It?
Imagine:
- A Database Connection Manager
- A Logger
- A Configuration Reader
- A Thread Pool

You don’t want multiple instances of these. You want one consistent object shared everywhere.



### Enter Our Savior: The Singleton Design Pattern

The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. 🌍

Here’s how the Singleton works:
1. We make the constructor private, so no one can directly instantiate the class. 🚫
2. We create a static instance of the class inside the class itself. 📦
   We provide a public static method (getInstance()) to return the single instance of the class. 🔄

```Java
public class Logger {
  private static Logger logger = null;
  private Logger() {} // Private constructor to prevent external instantiation

  public static Logger getLogger() {
    if (logger == null) {
      logger = new Logger(); // New instance only if one doesn't exist
    }
    return logger;
  }
  public void log(String message) {
    System.out.println("Log: " + message);
  }
}

public class Application {
  public void run() {
    Logger logger = Logger.getLogger(); // Always fetch the same instance
    logger.log("Application started.");
  }
}
```





## Usage of Singleton in Multithreading 🧵
Let’s take a step back and imagine you’re working on an application that has multiple parts, each running on different threads (like a multi-tasking kitchen with different chefs preparing different dishes at the same time). 👨‍🍳👩‍🍳 Now, let’s say one of those parts needs to access a Logger to write some logs. You’ve already applied the Singleton Design Pattern to ensure that only one instance of the Logger class exists, which is great! 👍

But here’s where the multithreading magic happens: Since multiple parts of the application might be running at the same time, multiple threads might try to access and create the Singleton instance of the Logger simultaneously. 😬
What happens then? 🤯

## Problem in Multithreading: The Chaos of Multiple Instances 🤯
Imagine this:
- Thread A checks if the Logger instance is null (it is, because no instance has been created yet). 🔍
- Thread B does the same thing at the same time, not knowing that Thread A is also trying to create the Logger instance. 🚨

Both threads decide to create a new instance of the Logger, and suddenly you have two instances of the Logger, which totally breaks the Singleton pattern! 😱

This problem is especially common in multithreaded environments where multiple parts of the program are running simultaneously, trying to access shared resources. 🧩

## Why is this a problem?
- Multiple instances: Now you have more than one Logger when you only wanted one, leading to inefficiency and possible issues with logging output (e.g., logs could be written to different places, causing confusion). 🔄📉
Race conditions: This also introduces race conditions, where the threads are competing to create the instance, leading to unpredictable behavior. ⚠️

## Solution: Making Singleton Thread-Safe 🛡️
Now, we need to fix this problem so that no matter how many threads try to access the Logger at the same time, only one instance gets created. 🔑

The solution is to make the Singleton instance creation process thread-safe. Here's how we can do it:
1. Using Synchronized Blocks 🛠️
   We can use synchronization to ensure that only one thread can create the Logger instance at a time. In Java, the synchronized keyword is used to control access to critical sections of code, making sure that only one thread can execute a block of code at any given time. 🕐
   Here’s how we can apply synchronization:
```Java
1. public class Logger {
2  private static volatile Logger instance; // volatile keyword ensures visibility across threads
4  private Logger() {} // Private constructor to prevent instantiation
5
6  public static Logger getInstance() {
7    if (instance == null) { // First check (no synchronization needed here)
8      synchronized (Logger.class) { // Synchronize only when creating the instance
10        if (instance == null) { // Second check (inside synchronized block)
11          instance = new Logger(); // Create the instance if it's still null
12        }
13      }
14    }
15    return instance; // Return the single instance
16  }
17
18  public void log(String message) {
19    System.out.println("Log: " + message);
20  }
21}
```

## What’s different here?
• The volatile keyword ensures that when one thread updates the instance, it’s visible to all other threads. This prevents any threads from getting an outdated version of the Logger object.
• We only use the synchronized block once—when the instance is null and needs to be created.

After that, any thread can access the already-created Logger instance without needing
synchronization.

## How It Works:
1. First Check: The getInstance() method first checks if the instance is already created (i.e., not null). If it is, no synchronization is needed, and the method immediately returns the existing instance.
2. Second Check (Inside Synchronized Block): If the instance is still null, we enter the synchronized block, ensuring that only one thread can create the instance.
3. Efficient Access: Once the instance is created, other threads can access it without needing to wait.
   This makes the Singleton thread-safe without the performance cost of synchronizing on every call to getInstance().
   ‍

