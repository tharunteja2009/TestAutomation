package com.automatedtest.steps;

import com.automatedtest.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePageSteps {


    public HomePage homePage;
    public List<String> items;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @Given("I navigates to HomePage")
    public void a_todoMVC_user_navigates_to_HomePage() {
        this.homePage.goToHomePage();
    }

    @When("I add {int} todo items to list")
    public void user_add_todo_items_to_list(Integer int1) {
        this.homePage.addItem(int1);
    }

    @When("I remove {int} todo items to list")
    public void user_remove_todo_items_to_list(Integer int1) {
        this.homePage.removeItem(int1);
    }

    @Then("todo list is displayed with {int} items")
    public void search_bar_is_displayed_items_in_list(Integer expectedCountOfItems) {
        Assert.assertEquals(expectedCountOfItems, this.homePage.getToDoItemCount());
    }

    @When("I add todo items to list")
    public void user_add_todo_items_to_list(DataTable dataTable) {
        List<String> items = dataTable.asList();
        for (String item : items) {
            this.homePage.addItem(item);
        }
    }

    @When("I edit existing todo items to list")
    public void user_edit_todo_items_to_list(DataTable dataTable) {
        List<String> oldToNewToDoItemPair = dataTable.asList();
        List<String> oldToDoItem = new ArrayList<>();
        List<String> newToDoItem = new ArrayList<>();
        for (String pair : oldToNewToDoItemPair) {
            oldToDoItem.add(pair.split("->")[0]);
            newToDoItem.add(pair.split("->")[1]);
        }
        for (int i = 0; i < oldToDoItem.size(); i++) {
            this.homePage.editItems(oldToDoItem.get(i), newToDoItem.get(i));
        }
    }

    @Then("search bar display todo items in list")
    public void search_bar_is_displayed_in_list(DataTable dataTable) {
        List<String> expectedToDoItemNames = dataTable.asList();
        List<String> actualToDoItemNames = this.homePage.getToDoItems();
        for (int i = 0; i < expectedToDoItemNames.size(); i++) {
            Assert.assertEquals(expectedToDoItemNames.get(i), actualToDoItemNames.get(i));
        }
    }

    @When("I check the todo list items")
    public void i_check_the_todo_list_items(DataTable dataTable) {
        List<String> doneItems = dataTable.asList();
        for (String doneItemName : doneItems) {
            this.homePage.checkDoneItems(doneItemName);
        }
    }

    @Then("search bar displayed done items in list")
    public void search_bar_displayed_done_items_in_list(DataTable dataTable) {
        List<String> expectedDoneItemNames = dataTable.asList();
        List<String> actualDoneItemNames = this.homePage.getDoneItems();
        for (int i = 0; i < expectedDoneItemNames.size(); i++) {
            Assert.assertEquals(expectedDoneItemNames.get(i), actualDoneItemNames.get(i));
        }
    }

}
