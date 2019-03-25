1. A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples). 

Note: First the user will engage the Organizer part of the diagram first, which will then createList(). After users will be able to modify the list according to their preferences and selections.

 
2. The application must contain a database (DB) of items and corresponding item types. 

Note: This is for the app User Interface

3. Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item. 

Note: This can be completed when the user engages the addItem() option in the diagram under Grocery List. They will then pick from a category which will simulate different aisles and such in an actual supermarket and provide options to add for the user.

4. Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB. 

Note: This will be completed when the user first creates a list and is then thrown into the Item Type section where they will select from a category of what they want to add on the list. This list will be premade according to the simulation of an actual grocery store.


5. Lists must be saved automatically and immediately after they are modified. 

Note: This is for the app User Interface

6. Users must be able to check off items in a list (without deleting them). 

Note: This can be completed under the editList() option of the Organizer.

7. Users must also be able to clear all the check-off marks in a list at once. 

Note: This can be completed when the editlist() option is engaged and operating properly.

8. Check-off marks for a list are persistent and must also be saved immediately. 

Note: This is for the app User Interface

9. The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles). 


Note: This is for the app User Interface / Item Type section of the diagram. The interface will reflect the Item Type section which will display items grouped by Category.



10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists. 

Note: This can be done from the Organizer section of the diagram. The entitys display createList(),deleteList(), editList() (rename will also be included here, and selection will have tickboxes as explained earlier.



11. The User Interface (UI) must be intuitive and responsive.

Note: This is for the app User Interface and will be done very responsibly.
