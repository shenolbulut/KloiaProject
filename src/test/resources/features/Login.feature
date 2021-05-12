
  Feature: login

    @login
    Scenario: login with facebook
      Given user goes to the page
      When user cliks the giris yap button
      And user login with facebook credentials
      Then verify that user's account is displayed
