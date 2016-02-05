Feature: Markov Chainer
  As chainer
  I need to take sentences for training
  And combine them randomly
  So that I can create comedy

Scenario: Accept a sentence for training
  Given a MarkovChainer
  Then it should be trainable

Scenario: Regurgitating a sentence
  Given a MarkovChainer
  When I train it with "Heloooo there!"
  Then it should generate "Heloooo there!"

Scenario: Mixing two sentences
  Given a MarkovChainer
  When I train it with "Ryan brews JAVA"
  When I train it with "Jeremy brews beer"
  And call generate 20 times
  Then it should generate "Ryan brews beer" at least once
