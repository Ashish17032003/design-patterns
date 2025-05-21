[//]: # (## Problem Statement)

[//]: # (Design a low-level system for a parking lot that satisfies the following requirements:)

[//]: # ()
[//]: # (1. The parking lot should have multiple entrances and exits.)

[//]: # (2. A global display board should show the number of free parking spots of all types.)

[//]: # (3. The parking lot should have different types of parking spots &#40;mini, compact, and large&#41; that allow   parking for motorbikes, cars, and trucks, respectively.)

[//]: # (4. The parking lot should have multiple floors.)

[//]: # (5. The admin should be able to add and remove entrances and exits.)

[//]: # (6. The parking attendant should be able to create parking tickets.)

[//]: # (7. The parking lot should support different parking strategies like nearest first or farthest first on the basis of floor number and id of the parking spot.)

[//]: # (8. The parking lot should support different means of payment.)

[//]: # ()
[//]: # (Please provide a detailed low-level design for the parking lot system that can handle the above requirements. You should consider how the parking lot will handle incoming and outgoing vehicles, track parking spots, generate and process parking tickets, and manage payments. Additionally, you should consider how the system will communicate with the display board and handle different parking strategies.)

[//]: # ()
[//]: # (![img.png]&#40;ClassDiagram/img.png&#41;)

[//]: # ()
[//]: # (### Parking Lot Class Diagram)

[//]: # (1. Composition relation exists between them)

[//]: # (![img_1.png]&#40;ClassDiagram/img_1.png&#41;)

[//]: # (![img_2.png]&#40;ClassDiagram/img_2.png&#41;)

[//]: # (2. Parking Spot will be an abstract class )

[//]: # (![img_3.png]&#40;ClassDiagram/img_3.png&#41;)

[//]: # (3. Vehicle will be there as well as an abstract class.)

[//]: # (4. Parking Ticket)

[//]: # (   -Which vehicle is this parking ticket for?)

[//]: # (   -For which Parking Spot &#40; 4th floor 3rd spot? or smthin &#41;)

[//]: # (   -At what time was this parking ticket alloted)

[//]: # (![img_4.png]&#40;ClassDiagram/img_4.png&#41;)

[//]: # (5. Admin has instance of parking lot and parking attendant can issue parking ticket)

[//]: # (![img_5.png]&#40;ClassDiagram/img_5.png&#41;)

[//]: # ()
[//]: # (## Services)

-------------------------------------------------

Objects:

1. Vehicle -> ( vehicle number, vehicle types (enum -> 2 or 4 wheeler))
2. Entrance Gate -> ( Find parking space, Update Parking space, generate ticket )
3. Ticket -> ( entry time, parking spot, price for that parking spot acc to your vehicle type)
4. Parking Spot ( what are the diff types of spot? .... 2 wheeler, 4 wheeleer should be extensible ) -> spotId, isEmpty, Vehicle that is allocated to it, price, type of parking spot
5. At Exit Gate What  are the payment strategies? ( Hourly based or min based or mix? ) -> cost calculation, collect payment, update parking spot ( free )


-------------------------------------------------

## Bottom Up Approach

1. Parking Spot
