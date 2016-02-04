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
  When I train it with "Heloooo!"
  Then it should gnerate "Heloooo!"
