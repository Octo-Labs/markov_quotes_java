Feature: Markov Chainer
  As chainer
  I need to take sentences for training
  And combine them randomly
  So that I can create comedy

Scenario: Accept a sentence for training
  Given a MarkovChainer
  Then it should be trainable
