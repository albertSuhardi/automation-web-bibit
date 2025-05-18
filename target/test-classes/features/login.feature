Feature: Search Functionality Bibit

  Scenario: User mencari manajemen investasi
    Given User opens the Bibit homepage with logged-in profile with pin "112233"
    And User clicks Explore
    Then User sees search field and types "Saham"
    
