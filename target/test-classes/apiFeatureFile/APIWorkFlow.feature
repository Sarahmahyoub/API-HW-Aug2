@APIAllTest
Feature: Syntax API HRMS Flow

  Background:
    Given a JWI is generated

  @api
  Scenario: Creating the employee using API
    Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

  @api2
  Scenario: Get the created employee
    Given a request is prepared for retrieving an employee
    When a GET call is made to retrieve the employee
    Then the status code for retrieved employee is 200
    And the employee id "employee.employee_id" must match with globally stored employee id
    And this employee data at "employee" object matches with the data used to create the employee
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status | emp_job_title |
      | Amy           | Smith        | G               | Female     | 2005-07-25   | Happy      | QA            |

  @json
  Scenario: Creating an employee using json body
    Given a request is prepared for creating an employee using json payload
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

  @dynamic
  Scenario: Creating an employee using highly dynamic scenario
    Given a request is prepared for creating an employee with data "Amy" , "Smith" , "G" , "F" , "2005-07-25" , "Happy" , "QA"
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

  @updateEmployee
  Scenario: Partial employee update
    Given a request is prepared for partial employee update
    When a PATCH call is made to partial employee update
    Then the status code for partial employee update is 201
    And the employee update contains key "Message" and value "Employee record updated successfully"

  @updateEmployee1
  Scenario: Get the updated employee
    Given a request is prepared for retrieving the partially updated employee
    When a GET call is made to retrieve the updated employee
    Then the status code for partially updated employee is 200
    And this updated employee data at "employee" object matches with the data used to update the employee
      | emp_firstname | emp_lastname | emp_middle_name | emp_gender | emp_birthday | emp_status  | emp_job_title|
      | Amy           | Smith        | G               | Female     | 2005-07-25   | Happy       | QA           |
