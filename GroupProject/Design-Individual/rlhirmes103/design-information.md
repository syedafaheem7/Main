1. A grocery list consists of items the users want to buy at a grocery store. The application
must allow users to add items to a list, delete items from a list, and change the quantity
of items in the list (e.g., change from one to two pounds of apples).  This is achieved in the last which consits of an array list of items.  the list has functionality for for adding items, deleting items and editing the amount of items.  

2. The application must contain a database (DB) of items and corresponding item types.  The database of items is contained in the items.  items has an item type.

3. Users must be able to add items to a list by picking them from a hierarchical list, wherethe first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.  Inside of items type is actual item which is a string therefore can be used to specify.  ITem also has a function itemamount so a user can specify the quantity for the item.

4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.

5. Lists must be saved automatically and immediately after they are modified.

6. Users must be able to check off items in a list (without deleting them).  Users can check off an item usign the check function in the items db

7. Users must also be able to clear all the check-off marks in a list at once. a user can clear off the check marks in a list in the clearChecks function in the list db.

8. Check-off marks for a list are persistent and must also be saved immediately.

9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).  Inside of items is itemType therefore that is the specification

10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists. List manipulation is done by the user db.  it has functionality for name, select,delete and create.  

11. The User Interface (UI) must be intuitive and responsive.