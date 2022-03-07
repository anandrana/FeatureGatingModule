# FeautureGating
Designed a feature gating module which decides whether the user is allowed to access a particular feature or not depending on conditional expression evaluated against user attributes.

Designed as an easily extensible module, where attributes and operators can be added fairly simply. The operator can be any logical operator with a possibly different number of operands required (say, Logical AND requires 2 operands and Logical NOT requires only one operand) and different types of operands (say, Logical NOT can only work on Boolean operands whereas == can work with Integer, Double, String, Boolean datatypes.)
The following things can be updated about any operator fairly easily:
a. relative precedence
b. operand count
c. symbols supported (like you can use '&&', 'and', 'AND' for Logical AND and so on)
d. operand types on which the operator is defined on
e. operation logic

Functional Requirements Met :

1. Conditional expression supports any infix expression

2. Supported operators >, >=, <=, <, ==, !=, BETWEEN, ALLOF, NONEOF
> Assumed the ALLOF operator to be TRUE if operand1 matches all the other operands
operand1 ALLOF operand1 operand3 evaluates to TRUE if operand1==operand2 AND operand1==operand3
> Similarly, assumed NONEOF evaluates to TRUE if operand1!=operand2 AND operand1!=operand3

4. The module is extensible to allow new attributes and new operators without major changes
> For adding an attribute, a variable needs to be added in the class User/Address/Person, and a getter function needs to be added.
> For adding a new operator, an operator class needs to be defined which implements the LogicalOperator interface, and an instance of the new class needs to be added in the populateOperators() function of the Calculator class.


Supported:
A. user attributes
User = {
Person = {
	Name
	Address = {
		HouseNumber
		Street
		City
		State
		Country
		PinCode
		}
	Email
	Phone
	Gender
	Age
}
PastOrderAmount
PreferredModeOfPayment
CustomerType
AccountType
}


B. operators
>, >=, <=, <, ==, !=, BETWEEN, ALLOF, NONEOF

C. data types supported
Integer, Double, String, Boolean


While creating new feature gates in the code. Just keep in mind the following while creating the conditional expression :
1. Between each operand and operator use whitespace. Whitespace is also required before and after brackets (\)
2. The operators can be written in various ways. You can find out the symbols used for each operator in that operator's class
3. The data member operand of the class 'User' must be written keeping in mind the case. Refer to the user details printed above.




