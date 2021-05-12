
  Feature: Task 2

    Background:
      Given user goes to the page
      When user cliks the giris yap button
      And user login with facebook credentials


    Scenario: test the favorilerim
      When user goes to "Kozmetik & Kişisel Bakım" on Personal Page
      And user goes to "Parfüm & Deodorant" under kategories
      And user search "lacoste" in Brand Filter
      And user add the number of 7 product on the search result page to the favorits
      Then verify that user has the same product 7 in favorilerim page
