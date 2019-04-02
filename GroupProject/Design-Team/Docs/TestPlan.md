# TEST PLAN
## Team Smitty Werbenjagermanjensen
## Create List
 * Create List will allow a user to create a grocery list 
 * The app needs to be running
 * Once a list is created the list must be saved and available for manipulation
 * Sequence of events 
	  - A user will press the plus sign 
	  - It will take the user to a pop up to name the list. 
	  - You will press create and the list will automatically be saved in the list of all grocery list. 
## Select List
 * Select List will allow a user to select a list. The user will then enter the list and be able to manipulate it.  
 * A pre condition is that there are already created lists
 * A post condition is that you are now on the specific grocery list you selected.
 *  Sequence of events
	* The user selects a list and is then taken to the specified grocery list where they will be able to perform different actions on the list
## Add Item
 *  Add item will allow a user to add an item to the grocery list the user is in
 * Pre conditions would be that the user has created a list and has selected it.
 * Post conditions would be that the list now has a grocery item in it
 * Sequence of events
	* Selecting the Plus sign on the top left corner will take you to a pop up
	*  It will have a  list of item categories which you can scroll through or use the search on top 
## Create New Item
	
 * If an item doesn't exist in the list of grocery items the user will have an option to create a new item 
 * A pre condition is that user has created a list, the user has selected it and has selected add Item. The pre condition is also that the item is not already in the list of items
 * A post condition is that the item that was added is not in the list of items
 * Sequence of events
	 * When the item is not in the list of items the user will be given a pop up option to create the item.  
	 * The user will enter the item name and press ok
	 * The item will be added to the list

## Remove List
* Remove list will remove the selected list from the list of lists
*  A pre condition is that user has created a list and the user has checked it off
* A post condition is that the grocery list does not exist
 * Sequence of events
	 * A user will check off the grocery list they wish to delete
	 * They will then press the trash icon on the top right
	 * The user will then get a popup that says are you sure you want to delete this list
	 * The user will press ok

## Check off All/ Uncheck All
* Check off all will check off every value in the list while uncheck all will uncheck every checked value in the list
* Pre condition is that values are created
* Post condition is that they no longer exist
 * Sequence of events
	 *  A user will press the box at the top 
	 * If blank, a check will appear  and all values in the list will be checked
	 * If checked, it will become blank and all checks will disappear
## Remove Item
* Remove item will remove an item from a grocery list
* A pre condition is that a grocery list exists and it has items
* A post-condition is that the item no longer exists
 * Sequence of events
	 * User will check off an item
	 * The user will then press the trash on the top right corner
	  * The user will then get a popup that says are you sure you want to delete this list
	 * The user will press ok
## Check Off/ Uncheck
* A user will press the box on the item
* A pre condition is that the item exists and a list exists
* A post condition is that the item is now checked or unchecked dependent on the value 
 * sequence of events
	 * A user will press on the box by the item/ list name
	 * A check or a blank will appear dependent on whats already in the box
## Rename List
* A user has the option to rename the list he is in
* A pre condition is that a list exists
* a post condition is that the list name is different
 * sequence of events
	 * Once inside a list a user will have the option to click on the title
	 * A text box will appear and the user will be able to rename the list
	 * this will save automatically

## Options
* A user can click on options to be taken to a list of actions they can perform on each item
* A pre condition is that a list with items exists
* A post condition is that a list of actions will appear 
* Sequence of Events
	* The user will press on the ellipses next to each item
	* A list will then pop up with actions the user can click on  
## Rename Item
* A user has the option to rename an item in a list
* A pre condition is that a list exists, it has items and that the user has pressed on the options icon 
* A post condition is that the item in the list is renamed
* Sequence of Events
	* The user will select rename item from the options 
	* It will then make a pop up which will have an editable text box with the item name
	* before exiting the popup the user will be asked to confirm change
	* the item name will be changed in the list
## Change Quantity
* Change quantity will change the quantity of an item and that the user has pressed on the options icon  
* A pre condition is that an item already exists in a list
* A post condition is that the amount of that item has changed
* Sequence of Events
	* The user will select change quantity
	* There will be a popup which will give you the option to change the quantity 
	* 	 before exiting the popup the user will be asked to confirm change
	* the item quantity will be changed in the list
