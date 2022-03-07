# FeatureGatingModule

Design a feature gating module which decides whether the user is allowed to access a particular feature or not depending on conditional expression evaluated against user attributes Assume user is on a ecommerce app Feature Examples of features could be
1. Exclusive access to certain set of categories
2. Same day delivery etc

User Attributes
In this context, user attributes could be age, gender, total order amount over the last 30 days, day of week and so on...

Conditional Expression
In this context, condition is basically an infix expression to decide whether the user is allowed to use a particular feature or not
Ex: (age > 25 AND gender == "Male") OR (past_order_amount > 10000)

“Read as”
If the age is greater than 25 and gender is Male or if the total purchase in the past exceeds 10000

If this condition evaluates to true, user will be allowed to use the feature Input to the module
boolean isAllowed(String conditionalExpression, String featureName, Map<String, Object>user);

Function takes a conditional Expression, a name of feature and user attributes defined as complex map and returns a boolean.

Functional requirements
1. conditionalExpression should be able to support any infix expression
2. Supported operators >, >=, <=, <, ==, !=, BETWEEN, ALLOF, NONEOF
3. Datatypes supported numbers, string, boolean
4. Module should be extensible to allow new attributes and new operators without major changes

Notes
1. Follow standard OOPs concept and best practices in the industry.
2. List the user attributes, operators and data types supported
3. Mention assumptions made if an
