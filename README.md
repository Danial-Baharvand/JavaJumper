# JavaJumper

![JavaJumper_screenshot](https://user-images.githubusercontent.com/49452399/162696356-f4f45c1a-92f3-482a-a68a-182ea65ae2ff.png)

JavaJumper is a simple RPG game about a teenager who is trapped in the nowhere dimension.
As you can guess, this is not a place you want to be growing up in. However, it is possible to escape the dimension through a dimensional portal. Unfortunately, these portals only appear at the top of a random building once every week. And they are fiercely guarded by the nowhere police, who use them to shuttle things and people in and out of the nowhere dimension.

The objective of the game is for the player to guide their character out of the nowhere dimension towards the exit portal while avoiding the nowhere police. But the main question is how, since all buildings have their roof top access restricted.

Fortunately for us, the nowhere underground has procured a jumper device. This device allows the wearer to create mini-portals that allow the wearer to ‘jump’ between end points. This device can allow the player to safely jump to the roofs of buildings and bypass the roof top access restrictions. Unfortunately, not everything in life is perfect. While the device can be quite handy, it is not nearly as powerful to create a portal equivalent to the escape portal. Furthermore, its range is also limited. While the player’s character has managed to 'acquire' this device, the supplementary power supply was not obtained. As such, the device can only hold the power for a fixed number of jumps before its battery runs out. While the battery can be recharged via power cells found distributed on building roof tops, this would still need the jumper to jump to these buildings in order to obtain the required power cells.

The game is over when one of the following occurs:

The player managed to jump to the building which has the exit portal on it.
The player’s jumper device runs out of charge and is unable to jump anymore.

The Java Jumper game gameplay can be described as follows:

* When the game begins the system will read the file called ‘buildings.txt’. This file contains a list of buildings in the game upon which the player can jump to. Each building will have the following details:

  1. Height – each building is of a random height between 1 and 5 storeys high

  2. Exit Portal – only one building on the strip can contain the exit portal. During each run of the game, the exit portal does NOT change once assigned to a specific building.

  3. Fuel Cell – this indicates if the specific building has a fuel cell which can be found on the roof to recharge the jumper device. Each fuel cell can recharge the jumper device by 5 points.

  4. Web – this indicates if the building has been booby-trapped with a web setup by the nowhere police meant to catch jumpers. Each turn, a web can only be deployed on a single building. This changes after each turn in the game, and the web is randomly assigned to one of the buildings in the game.

  5. Freeze – this indicates a frozen building. A jumper that lands on a frozen building must skip a turn as they cannot jump. Only a single building can be frozen at a time. If this happens to be the building with the exit portal, the player cannot use the exit portal in that turn while the building is frozen.

* When the game begins, it prompts the user to enter their name which must be between 3 and 12 characters respectively. Should the user enter a name which does not meet this criteria, the user is then asked to re-enter until the criteria has been met.

* Once the user has successfully entered their name, the game displays the buildings along with the indication for the exit portal as well as building on which fuel cells can be found. The maximum number of buildings which are available in the game for the player to jump to is 15.

* When the game begins, the player is always placed on the top of the first building.

* The size of the building the player is one determines the number of jump spaces the player is able to jump either forward or backward. For e.g. if the current height of the building the player is on is 2, the player can either jump 2 buildings to the left or to the right. The game should validate the end points so the player cannot jump past the 15th building or before the 1st building.

* Each jump depletes the jumper device’s battery. The charge starts at 50% charge of 10 points. 20 points is the maximum charge the jumper can hold. The cost for each jump is determined based on the height difference between the two buildings the player jumps to between using the formula – [height of building 1 – height of building 2] + 1 (note: this is the absolute value of the subtraction, so the difference cannot be negative).

* The player is then given the choice to perform the following options:

  1. Jump x buildings to the right (x is determined by the height of the current building)
  
  2. Jump x buildings to the left (x is determined by the height of the current building)
  
  3. Stay on the current building – this allows the player to skip a single turn. Doing this drains 1 charge point on the jumper device.
  
  4. The player must jump the full x number of spaces and not part of them. If the player cannot jump towards the exit portal, they can either jump backward or stay in place.

* After the player has made their selection the following occurs:
  
  1. As this is nowhere, building heights are not fixed. They change after each and every turn. And the player has no idea of this in advance. The height of the building the player lands no may not be the same as it was before the jump.

  2. Fuel cells get completely drained after three turns and disappear. New fuel cells must be randomly placed every 3rd turn. The maximum number of fuel cells which are available is 4. Should a fuel cell be consumed, if the next turn is not a multiple of 3, the cell is not replenished.
  
  3. If a player jumps to a building with a fuel cell on it, the charge level of the device is automatically updated by 5 points for each fuel cell collected.

  4. The nowhere police randomly change the building where the web booby-trap is located. If the player jumps to a building with a web booby-trap, it costs them 5 extra charge points on their jump device.

  5. The game will also randomly select a building to be frozen. Only a single building can be frozen at a time.

  6. If the player lands on the building with the exit portal, the game if over and the player wins.
  
  7. If the player has run of charge points on their jumper device and can no longer jump, the game is over and the player loses.

* Once the game is over, the final stats should be written to a file called ‘outcome.txt’. The game should write the number of turns played, the number of fuel cells found, and the win status of the game.
