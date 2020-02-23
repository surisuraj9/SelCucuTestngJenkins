$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "feature to login",
  "description": "",
  "id": "feature-to-login",
  "keyword": "Feature"
});
formatter.before({
  "duration": 15319876000,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "user tries to login in to page scenario",
  "description": "",
  "id": "feature-to-login;user-tries-to-login-in-to-page-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user opens browser with url",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters \"surajp\" as \"username\" and \"suraj1234\" as \"password\" in \"login\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user clicks on \"login_button\" in \"login\" page",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 7,
      "value": "#Then user validates \"title\" as \"CRMPRO  - CRM software for customer relationship management, sales, and support.\" in \"home\" page"
    }
  ],
  "line": 8,
  "name": "user validates \"userNameLabel\" as \"  User: padmanabhuni suraj\" in \"home\" page",
  "keyword": "Then "
});
formatter.match({
  "location": "GeneralSteps.openUrl()"
});
formatter.result({
  "duration": 3982961800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "surajp",
      "offset": 13
    },
    {
      "val": "username",
      "offset": 25
    },
    {
      "val": "suraj1234",
      "offset": 40
    },
    {
      "val": "password",
      "offset": 55
    },
    {
      "val": "login",
      "offset": 69
    }
  ],
  "location": "GeneralSteps.validateLogin(String,String,String,String,String)"
});
formatter.result({
  "duration": 940737700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "login_button",
      "offset": 16
    },
    {
      "val": "login",
      "offset": 34
    }
  ],
  "location": "GeneralSteps.clickMethod(String,String)"
});
formatter.result({
  "duration": 6218742800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "userNameLabel",
      "offset": 16
    },
    {
      "val": "  User: padmanabhuni suraj",
      "offset": 35
    },
    {
      "val": "home",
      "offset": 67
    }
  ],
  "location": "GeneralSteps.validateMethod(String,String,String)"
});
formatter.result({
  "duration": 161485200,
  "status": "passed"
});
formatter.after({
  "duration": 95100,
  "status": "passed"
});
formatter.after({
  "duration": 1171717700,
  "status": "passed"
});
});