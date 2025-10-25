## 🧩 1. What is the Command Design Pattern (in simple words)
Think of a remote control —
you press a button (command), and it tells a TV (receiver) what to do (like “turn on” or “turn off”).
The remote doesn’t care how the TV works internally — it just sends a command.
That’s what the Command Pattern does in code.

It encapsulates a request (like “turn on light”) as an object, so you can:
- Store it 🗃️
- Undo it ↩️
- Reuse it 🔁
- Execute it later ⏰
```aiignore
remoteButton.setCommand(new TurnOnLightCommand(light));
remoteButton.click(); // internally calls command.execute()
```


1. We’ll start by defining a Command interface that every command will implement
2. Each specific command (like turning the TV on or changing the channel) will be represented by a class that implements this interface.
3. The RemoteControl class will only hold references to these command objects, and when a button is pressed, it will execute the corresponding command.
4. TV (Receiver):
   - The TV class is the receiver that performs the actual actions (turning on/off, changing channels, adjusting volume).