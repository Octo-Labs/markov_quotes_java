package com.shoe.example;

import java.util.Hashtable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MarkovChainerStepDefs {

  private MarkovChainer myChainer;
  private Hashtable<String, Integer> results = new Hashtable<String, Integer>();

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

  @Then("^it should generate \"([^\"]*)\"$")
  public void it_should_generate(String arg1) throws Throwable {
    String sentence = myChainer.generate();
    assertThat(sentence, is(arg1));
  }

  @When("^call generate (\\d+) times$")
  public void call_generate_times(int arg1) throws Throwable {
    for(int i=1; i<arg1; i++){
      System.out.print("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
      String sentence = myChainer.generate();
      Integer score = results.get(sentence);
      if(score == null){
        score = 0;
      }
      score++;
      results.put(sentence,score);
      System.out.println(sentence);
      System.out.println(score);
    }
  }

  @Then("^it should generate \"([^\"]*)\" at least once$")
  public void it_should_generate_at_least_once(String arg1) throws Throwable {
    Integer score = results.get(arg1);
    if(score == null){
        score = 0;
    }
    System.out.println("Score for: " + arg1);
    System.out.println(score);
    boolean greaterThanZero = score > 0;
    assertThat("greaterThanZero",greaterThanZero);
  }

}




