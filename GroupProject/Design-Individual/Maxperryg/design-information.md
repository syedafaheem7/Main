# groceryListManager Design

1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
	

To realize this requirement, I created a List Of Lists class to be a list to. Hold the list(s) that the user creates. This class has only one attribute, quantity, that holds the amount of grocery lists are present. I also created a Grocery List class that has a name. The user can have many lists by different names, and so, can add a new list, remove lists, and select which list to view. 


2. The application must contain a database (DB) of items and corresponding item types.
	

To realize this requirement, I added the Item and ItemType classes. Item type lass is a more general class with just a name. An Item is the specific item of the item type. It has its own name and price.

3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.
	

With the Item Type class, the user can add an item to the list of any type saved in the database, and then, with the the Item class, can specify the more - grocery list specific - attributes such as quantity.

4. Users must also be able to specify an item by typing its name. In this case, the
application must look in its DB for items with similar names and ask the users, for each
of them, whether that is the item they intended to add. If a match cannot be found, the
application must ask the user to select a type for the item and then save the new item,
together with its type, in its DB.
	

In order to accomplish this, The Item Type class has a newItem method so that the user can create a new item belonging to an Item Type and add it to the DB to be used in the application.


5. Lists must be saved automatically and immediately after they are modified.
	

Not considered because it does not affect the design directly.

6. Users must be able to check off items in a list (without deleting them).
	

To realize this requirement, the Item class has a method, markCompleted, that allows the user to show an item was purchased.

7. Users must also be able to clear all the check-off marks in a list at once.
	

To realize this requirement, the Grocery List class has a method, checkOffAll, that will mark all the items in the list as completed.

8. Check-off marks for a list are persistent and must also be saved immediately.
	

Not considered because it does not affect the design directly.

9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).
	

Not considered because it does not affect the design directly. This will be the default view of the list.


10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.
	

To realize this requirement, I supplied the List Of Lists class with the following methods:

newList, which allows the user to create a new list and add it to their list of lists
removeList, which allows the user to remove any of these lists after they're are no longer necessary
selectList, which allows the user to select which list they want to view at the moment.
Also, the Grocery List class has a method, rename, which allows the user to rename whichever Grocery List the method was called on


11. The User Interface (UI) must be intuitive and responsive. 


Not considered because it does not affect the design directly.
