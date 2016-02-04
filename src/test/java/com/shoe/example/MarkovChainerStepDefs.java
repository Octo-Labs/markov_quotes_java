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


}




