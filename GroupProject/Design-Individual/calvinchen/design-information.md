1. A grocery list consists of items the users want to buy at a grocery store. The application
must allow users to add items to a list, delete items from a list, and change the quantity
of items in the list (e.g., change from one to two pounds of apples).
	In my design, the application allows users to create lists and users can perform add item, 
delete item, and change item's quantity operations in a created list.

2. The application must contain a database (DB) of items and corresponding item types .
	In my design, there is a database and it stores items' name and type. It also allows users
to filter items.

3. Users must be able to add items to a list by picking them from a hierarchical list, where
the first level is the item type (e.g., cereal), and the second level is the name of the
actual item (e.g., shredded wheat). After adding an item, users must be able to specify a
quantity for that item.
	After an user create a list and press add botton to add an item to the list, the application
will take the user to the database and allow user to use the item filter to pick their desired item.
For example: If the user wants to buy a cereal, then the user can filter out all the items that don't
have "cereal" as their type. If the user wants to buy cereal named "shredded wheat", the user can perform
a filter base on the first filter's result.

4. Users must also be able to specify an item by typing its name. In this case, the
application must look in its DB for items with similar names and ask the users, for each
of them, whether that is the item they intended to add. If a match cannot be found, the
application must ask the user to select a type for the item and then save the new item,
together with its type, in its DB.
	If a user is looking for a specify item, the user can create a list and press the "accessDB" botton in the 
list user interface. Then the application will take the user to the database and the user can search a specify item 
by typing the item name. Then the items with similar name will come out as the search result. If one of the result is 
the item that the user is looking for , the user can add the item to a list; If a match cannot be found, the application 
will perform "addToDB" automatically,which means the application will pop out a small window for users to eneter the type 
of item. After users enter the type of item, the application will store the item as a new item with its type and name that 
are typed by the users.

5. Lists must be saved automatically and immediately after they are modified.
	After a user delete an item from a list or add an item to a list, the list will automatically perform a "save()"
operation.Users are alson able to perform the "save()" operation in the list by themself.

6. Users must be able to check off items in a list (without deleting them).
	In the list UI, users can press "checkOff" button to mark an item or multiple items.

7. Users must also be able to clear all the check-off marks in a list at once.
	In the list UI users can press "clearCheckOff" to clear all the marks that are created by users.

8. Check-off marks for a list are persistent and must also be saved immediately.
	In the list UI, users can press "save" button to save all the modification and marks.

9. The application must present the items in a list grouped by type, so as to allow users to
shop for a specific type of products at once (i.e., without having to go back and forth
between aisles).
	The application allows users to use the filter to get a specific type of items in the database. After using a filter,	
only a specific kind of items are presented to the users.	

10. The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly
farmer’s market list”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete lists.
	In the homepage(UI) of the application, users are able to create multiple lists and also perform create list, rename list,
select list , and delete list operations.