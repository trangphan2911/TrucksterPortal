$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Trucks.feature");
formatter.feature({
  "line": 1,
  "name": "User can not a new truck without entering required fields",
  "description": "Company description\n\nThis feature verify scenario on Truck Page",
  "id": "user-can-not-a-new-truck-without-entering-required-fields",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5448890419,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "User can not add a Truck without any data",
  "description": "",
  "id": "user-can-not-a-new-truck-without-entering-required-fields;user-can-not-add-a-truck-without-any-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I was on Truck Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I click on Add button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I click on Confirm button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Displaying error messages for missing fields",
  "keyword": "Then "
});
formatter.match({
  "location": "TruckStepDefinition.i_was_on_Truck_Page()"
});
formatter.result({
  "duration": 7497277393,
  "status": "passed"
});
formatter.match({
  "location": "TruckStepDefinition.i_click_on_Add_button()"
});
formatter.result({
  "duration": 2253149285,
  "status": "passed"
});
formatter.match({
  "location": "TruckStepDefinition.i_click_on_Confirm_button()"
});
formatter.result({
  "duration": 3082019866,
  "status": "passed"
});
formatter.match({
  "location": "TruckStepDefinition.displaying_error_messages_for_missing_fields()"
});
formatter.result({
  "duration": 3032636103,
  "error_message": "java.lang.AssertionError: expected [Name is required] but found [Name is required3333]\n\tat org.testng.Assert.fail(Assert.java:93)\n\tat org.testng.Assert.failNotEquals(Assert.java:512)\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:134)\n\tat org.testng.Assert.assertEquals(Assert.java:115)\n\tat org.testng.Assert.assertEquals(Assert.java:189)\n\tat org.testng.Assert.assertEquals(Assert.java:199)\n\tat com.dice.stepDefinitions.TruckStepDefinition.displaying_error_messages_for_missing_fields(TruckStepDefinition.java:56)\n\tat ✽.Then Displaying error messages for missing fields(Trucks.feature:9)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.write("Scenario failed.");
formatter.after({
  "duration": 751543925,
  "status": "passed"
});
});