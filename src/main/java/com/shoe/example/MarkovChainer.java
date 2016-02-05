package com.shoe.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Hashtable;

public class MarkovChainer {

  private String sentence;
  private ArrayList<Word> beginnings;
  private Hashtable<String,Word> words;

  public MarkovChainer(){
    beginnings = new ArrayList<Word>();
    words = new Hashtable<String,Word>();
  }

  public void train(String s) {
    sentence = s;
    String[] swords = sentence.split(" ");
    for(int i = swords.length -1; i>=0; i--){
      System.out.println("dealing with word: " + swords[i]);
    }
  }

  public String generate() {
    return sentence;
  }

  private class Word {
    private ArrayList<Word> nextWords;
    private String word;

    public Word(String w){
      word = w;
      nextWords = new ArrayList<Word>();
    }

    public void addNextWord(String w){
      nextWords.add(new Word(w));
    }

    public Word nextWord(){
      return nextWords.get(0);
    }
  }
}


