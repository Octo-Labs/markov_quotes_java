package com.shoe.example;

public class MarkovChainer {

  private String sentence;

  public void train(String s) {
    sentence = s;
  }

  public String generate() {
    return sentence;
  }
}
