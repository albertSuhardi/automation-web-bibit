Feature: Search Functionality Bibit

  Scenario: User mencari manajemen investasi
    Given User opens the Bibit homepage
    Then Login and click login button "081222333444"
    And User enters OTP "123456" dan pin "123456"
    Then User should be redirected to homepage account and search investor "GOTO"
