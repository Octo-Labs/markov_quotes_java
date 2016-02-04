package com.shoe.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarkovChainerStepDefs {

  private MarkovChainer myChainer;

  @Given("^a MarkovChainer$")
  public void a_MarkovChainer() throws Throwable {
    myChainer = new MarkovChainer();
  }

  @Then("^it should be trainable$")
  public void it_should_be_trainable() throws Throwable {
    String sentence = "Just a test sentence";
    myChainer.train(sentence);
  }

  @When("^I train it with \"([^\"]*)\"$")
  public void i_train_it_with(String arg1) throws Throwable {
    myChainer.train(arg1);
  }

  @Then("^it should gnerate \"([^\"]*)\"$")
  public void it_should_gnerate(String arg1) throws Throwable {
    String sentence = myChainer.generate();
    assertThat(sentence, is(arg1));
  }


}




