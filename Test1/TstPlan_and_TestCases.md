# Test Plan and Test cases for Monefy

This is the test plan and test cases document for Monefy app on Android.

## Test Environment

### Test device selection
This section is about what are the devices that were considered as part of the test plan.

- Physical devices
    
    ``Samsung S8, Samsung Note6, one plus 5, One plus 6`` 

- Emulators 
    
    ``Nexus 5, Nexus 6``

### OS versions compatibility
This section talks about what are the OS versions that were considered as part of the test plan.
- Versions

    ``Android Oreo, Android P, Android One`` 

### Screen size compatibility
This section talks about what are the screen sizes and resolutions that were considered as part of the test plan.

- Screen resolutions
    ``70p, 080p, 0p``
- Screen Modes
 ``Potrait, Landscape``

## Scope

The scope of this document is to portray a test plan and cases for Monefy app on Andriod OS. All the screen sizes, resolutions and every other detail are examples and would vary with the real-time requirements and with the business context.

## Types of Testing and Test cases

Below are the areas in which the app needs to be tested, - Run these cases on different versions of OS and devices selected

### Installation
Test the installation of the application
  - [Priority - High] [Manual] User should be able to install the application on a device for the first time. The application should get installed and can be opened
  - [Priority - High] [Manual] User should be able to install the application after uninstalling the existing application(re-installation), Application should get installed and can be opened
  - [Priority - High] [Manual] User should be able to update the current application to a newer version of the application, the user should be able to open updated application
 
### Functional
Test the Functionality of the application

##### Account
  - [Priority - High] [Automated - API Test] User should be able to create a new account, a new account should be added and should get a notification saying the account is created.
  - [Priority - High] [Automated - API Test] User should be able to delete an existing account, account should get deleted and all the expenses and incomes related to the account. User should get a notification saying the account is deleted.
  - [Priority - High] [Automated - API Test] User should be able to create multiple accounts, New account should be created and a new account should be visible to user in accounts. User should get a notification saying the new account is created. 
  - [Priority - High] [Automated - API Test] User should be able to change between different accounts and see status, balance and visualisation
  - [Priority - Medium] [Automated - API Test] User should be able to see accounts and account details(name and available balance) under the accounts section on the side menu.
  - [Priority - Medium] [Automated - API Test] User should not be able to add accounts with the same name.
  - [Priority - High] [Automated - API Test]  If an account is deleted then the transfers of that account should remain as is, in other account details.
  
##### Categories
  - [Priority - High] [Automated - API Test] User should be able to add a new category, the new category should be added and the user should get a notification
  - [Priority - Medium] [Automated - API Test] User should not be able to add another category with the same name 
  - [Priority - Medium] [Automated - API Test] User should be able to select the newly added category while adding the expense
  - [Priority - High] [Automated - API Test] User should be able to delete an empty category(No expenses associated with category), the category should get deleted and notification should be shown.
  - [Priority - High] [Automated - API Test] User should not be able to delete a non-empty category, if the category is already associated to some expenses then it should give an alert saying can't delete category as there are some expenses associated with it.
  
##### Income
  - [Priority - High] [Automated - API Test] User should be able to add a new income type, new income type should be added and the user should get a notification
  - [Priority - Medium] [Automated - API Test] User should not be able to add another income type with the same name
  - [Priority - Medium] [Automated - API Test] User should be able to select the newly added income type while adding the expense
  - [Priority - High] [Automated - API Test] User should be able to delete an empty income type(No income associated with income type), the category should get deleted and notification should be shown.
  - [Priority - High] [Automated - API Test] User should not be able to delete a non-empty income type, if the income type is already associated to some incomes then it should give an alert saying can't delete category as there are some expenses associated with it.
  - [Priority - High] [Automated - API Test] User should be able to add income to a specific account, the balance & visualization should get updated accordingly.
  - [Priority - High] [Automated - API Test] User should be able to delete income, income should get deleted the balance & visualization should get updated accordingly.
  
##### Expense
  - [Priority - High] [Automated - API Test] User should be able to add a new expense of a category to a specific account, the expense should be deleted and the user should get a notification saying "expense added" 
  - [Priority - High] [Automated - API Test] User should not be able to add a new expense without selecting a category, the user should get a notification saying select category.
  - [Priority - High] [Automated - API Test] User should be able to delete an expense from a specific account, the balance & visualization should get updated accordingly. 
  - [Priority - High] [Automated - API Test] User should be able to select a specific account while creating an expense. By default, the default account should be selected.
  - [Priority - High] [Automated - API Test] User should be able to select a specific category while creating an expense.
  
##### Visualization
  - [Priority - High] [Automated - API+UI Test] If expense amount is more than income then Balance should be shown in Red colour.
  - [Priority - High] [Automated - API+UI Test] If income amount is more than expense then Balance should be shown in Green colour.
  - [Priority - High] [Automated - API+UI Test] Balance should be shown by formula(Total income-total expenses) and should get updated accordingly whenever there is an addition or deletion of an expense or income.
  - [Priority - High] [Automated - API+UI Test] User should be able to view visualization, with a percentage of expenses of different category and balance. 
  - [Priority - High] [Automated - API+UI Test] Percentages on the visualization should be calculated by the formula ((expense amount/total expense)*00)
  - [Priority - High] [Automated - API+UI Test] Visualisation should get updated by a selection of day to that particular day's expense and income when a particular day is selected.
  - [Priority - High] [Automated - API+UI Test] Visualisation should get aggregated and updated by a selection of week/month/year/all to that particular period expense and income when a particular period is selected.
  - [Priority - High] [Automated - API+UI Test] Visualization should show all the account details aggregated when all accounts are selected. [This should show overall account balance(Total income from all accounts - Total expenses from all accounts) and similarly percentage for specific category]
  
##### Transfer
  - [Priority - High] [Automated - API Test] User should be able to do transfer from one account to another, that money transfer should get reduced in the debit account and should get added to a credit account, the transfer should be added to transfers list.
  - [Priority - High] [Manual - API Test] User should not be able to use the transfer feature if there is only one account.
  - [Priority - High] [Automated - API Test] If a user transfers amount from an account that is empty the transfer should be shown as a negative value
  - [Priority - High] [Automated - API Test] User Should not be able to transfer the negative amount.

##### Data Backup
  - [Priority - High] [Automated - API Test] User should be able to create data backup.
  - [Priority - High] [Automated - API Test] User should be able to restore data from specific backup file.
  - [Priority - High] [Automated - API Test] User should be able clear data from application and (synconization application(i.e. Dropbox and google Drive))
 
##### Synchrozation
  - [Priority - High] [Automated - API Test] User should be able to sync data with Dropbox.
  - [Priority - High] [Automated - API Test] User should be able to sync data with Google Drive.
 
##### General settings
  - [Priority - High] [Automated - API Test] User should be able to Select Specific language.
  - [Priority - High] [Automated - API Test] User should be able to Select Specific Currency.
  - [Priority - High] [Automated - API Test] User should be able to Select Frist day of the week.
  - [Priority - High] [Automated - API Test] User should be able to apply/remove Dark theme.
  - [Priority - High] [Automated - API Test] User should be able to enable/disable Budget mode.
  - [Priority - High] [Automated - API Test] User should be able to enable/disable Carry over feature.
  - [Priority - High] [Automated - API Test] User should be able to enable/disable passcode protection.
  - [Priority - High] [Automated - API Test] User should be able to export data to csv file.
  - [Priority - High] [Automated - API Test] User should be able buy Monefy Pro(to use pro features).
   
### Usability
 This considers all the usability angles of the application.
 
 - [Priority - High] [Manual] Validate all the buttons when enabled should perform an action when clicked/touched.
 - [Priority - High] [Manual] Validate all the buttons which are in disable state should not, should not be touchable/clickable or perform any action when clicked/touched.
 - [Priority - Medium] [Manual] Validate when a user enters some data and minimizes the app and comes back to the app after some time then it should have the data persisted.
 - [Priority - Medium] [Manual] Validate that the user receives an appropriate error message like “Network error. Please try after some time” whenever there is any network error.
 - [Priority - Medium] [Manual] Validate that notifications should be cleared or notifications should be time-based which disappear after certain time say 0 seconds
 
### UI & Design
 - [Priority - High] [Automated - UI Test] Validate that branding should be intact with organizational rules.
 - [Priority - High] [Automated - UI Test] Validate that all the buttons/icons should be as per design, buttons should have the required size and be suitable to big fingers.
 - [Priority - High] [Automated - UI Test] Validate that all the buttons/icons should be of defined size on various resolutions.
 - [Priority - Medium] [Automated - UI Test] Validate that contextual menus are not overloaded because it has to be used quickly.
 - [Priority - High] [Automated - UI Test] Validate that the application provides a method for going back or undoing an action, on touching the wrong item, within an acceptable duration.
 - [Priority - High] [Automated - UI Test] Validate that all the notifications should follow the same pattern and should be consistent.
 - [Priority - Medium] [Automated - UI Test] Validate that font should be consistent in the app as per design.
 - [Priority - Medium] [Automated - UI Test] Validate that all the mandatory fields and non-mandatory fields should be distinguished properly
 
### Performance tests
 - [Priority - High] [Automated] Validate that App should use optimal memory, should not overuse memory and crash.
 - [Priority - High] [Automated] Validate that Logs should be monitored to understand the crashes and should be fixed.
 - [Priority - High] [Automated] Validate that App should not use memory when the app is not opened.
 - [Priority - High] [Automated] Validate that App should not drain the battery when not in use.
 - [Priority - Medium] [Automated] Validate that all the required CPU cycles should be optimised
 - [Priority - Low] [Automated] Validate the application longevity whenever the user load is rigorous.
 
### Compatibility tests
 - [Priority - High] [Automated - API/UI Test] Validate that all the above test cases should be carried out on different devices, resolutions, screen sizes as mentioned in Test environment details 

### Security tests
 - [Priority - High] [Automated] Validate that app libraries should not have any known vulnerabilities.
 - [Priority - High] [Manual] Validate that app should not let other apps to use its content.
 - [Priority - Medium] [Manual] Check for investigate file caching and prevent any malicious possibilities from the same.
 - [Priority - Medium] [Manual] Check for insecure data storage in the keyboard cache of the applications. 
 
  __Lot of exploratory testing needs to be done as part of the testing, which includes testing the app for random scenarios and doing random stuff with different versions of OS and different devices.__
 
## What kinds of tests are carried out and when 

### Smoke Testing
  - __What__: Helps in verifying the application whenever a new artifact is generated when check-in is done by a developers 
  - __When__: After every check-in
  - __How__: Automated
  - __Where__: On CI pipelines
  
  ``Testcases: We add one or two major end to end flows, and some high priority functional tests to make sure build is good for testing. Following test pyramid: Mostly consists of all the unit tests, some API tests and very few UI tests to get faster feedback ``
  
### Regression Testing
  - __What__: Helps in verifying the application to regress once the application is built.
  - __When__: Scheduled
  - __How__: Automated
  - __Where__: On CI pipelines
  
  ``Testcases: Consists of all the tests required to be run frequently and can be automated will be part of this. These can be run across different devices and emulators``


__Note: Given the time constraints and stuff, I have tried my best to write some tests cases and a small test plan. I still feel there are lot of other scenarios that can be covered (many more negative cases, validations, etc). Happy to discuss on the same.__
