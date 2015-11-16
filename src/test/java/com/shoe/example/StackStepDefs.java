package com.shoe.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StackStepDefs {
    private Stack myStack;
    private Object pushed;
    private Object popped;

    @When("^I pop from the stack$")
    public void I_pop_from_the_stack() {
        Object out = myStack.pop();
        popped = out;
    }

    @When("^I push another item into the stack$")
    public void I_push_another_item_into_the_stack() {
        I_push_an_item_into_the_stack();
    }

    @Given("^an empty stack$")
    public void an_empty_stack() throws Throwable {
        myStack = new Stack();
    }
    @Then("^I get the same item back$")
    public void I_get_the_same_item_back() {
        assertThat(pushed, is(popped));
    }

    @Then("^the stack contains one item$")
    public void the_stack_contains_one_item() {
        assertThat(myStack.size(), is(1));
    }

    @Then("^the stack contains two items$")
    public void the_stack_contains_two_items() {
        assertThat(myStack.size(), is(2));
    }

    @When("^I push an item into the stack$")
    public void I_push_an_item_into_the_stack() {
        pushed = new Object();
        myStack.push(pushed);
    }

}
