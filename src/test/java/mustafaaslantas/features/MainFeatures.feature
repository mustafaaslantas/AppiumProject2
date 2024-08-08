Feature: Application Test
  Scenario: Login and cart tests of Kitapyurdu App

    Given Go Home Page
    And Login
    And Find and press the search button
    And Press Kitap Button
    And Select Edebiyat
    And Press on Show All Button
    And Select a random book and add it to the cart
    Then The book in the cart must match the selected book
    And Remove the item from the cart
    Then The cart must be empty
    And Click to search button
    And Search for Orhan Pamuk
    Then The results must be relevant to Orhan Pamuk