package com.shoe.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.StringJoiner;

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
    Word previousWord = null;
    for(int i = swords.length -1; i>=0; i--){
      System.out.println("dealing with word: " + swords[i]);
      Word word = words.get(swords[i]);
      if(word != null){
        System.out.println("we had the word");
        word.addNextWord(previousWord);
      }else{
        System.out.println("we didn't have the word");
        word = new Word(swords[i],previousWord);
        words.put(swords[i],word);
      }
      previousWord = word;
    }
    beginnings.add(previousWord);
  }

  public String generate() {
    StringJoiner words = new StringJoiner(" ");
    Collections.shuffle(beginnings);
    Word word = beginnings.get(0);
    while(word != null){
      words.add(word.toString());
      word = word.nextWord();
    }
    String sentence = words.toString();
    System.out.println("*************");
    System.out.println(sentence);
    return sentence;
  }

  private class Word {
    private ArrayList<Word> nextWords;
    private String word;

    public Word(String w, Word nextWord){
      word = w;
      nextWords = new ArrayList<Word>();
      nextWords.add(nextWord);
    }

    public void addNextWord(Word w){
      nextWords.add(w);
    }

    public Word nextWord(){
      if(nextWords.size() > 0){
        System.out.println("we have a next word");
        Collections.shuffle(nextWords);
        return nextWords.get(0);
      }else{
        System.out.print("We do not have a next word");
        return null;
      }
    }

    public String toString(){
      return word;
    }
  }
}


