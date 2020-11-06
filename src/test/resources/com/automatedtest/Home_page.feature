Feature: Validate todo list application

  @validate_todo_count
  Scenario Outline: As todoMVC user add <add> todo items and remove <remove> todo items
    Given I navigates to HomePage
    When I add <add> todo items to list
    And I remove <remove> todo items to list
    Then todo list is displayed with <final> items
    Examples:
    |add|remove|final|
    |  5|  2    |3     |
    |20 |5      |15    |

  @validate_todo_edit
  Scenario:  As todoMVC user change existing todo items
    Given I navigates to HomePage
    When I add todo items to list
         |food|money|wallet|
    #mapping for existing to do item name to new item name
    And I edit existing todo items to list
         |food->water|money->digital money|wallet->e-wallet|
    Then search bar display todo items in list
         |water|digital money|e-wallet|

  @validate_check_done_items
  Scenario:  As todoMVC user check done items
    Given I navigates to HomePage
    When I add todo items to list
      |running|jogging|eating|
    And I check the todo list items
     |running|
    Then search bar display todo items in list
      |jogging|eating|
    And search bar displayed done items in list
      |running|