---
tags: CSE12WI21
---
---
# PA1 (Open): Testing Shopping Baskets
---

**This assignment is <a href="https://ucsd-cse12-w21.github.io/#programming">open to collaboration</a>.**

This assignment will teach you to use JUnit to test implementations of an interface, and review a number of Java concepts.

This PA is due on ** **Wednesday, January 13 at 11:59pm** **

Link to FAQ: https://piazza.com/class/kirvel5rj2337n?cid=35   
*Link to PA Video: https://canvas.ucsd.edu/courses/21784/external_tools/82   

*Note: the PA video focuses on Part 1 of the PA. For tips on Part 3, watch the live recording from Discussion last Tuesday (on Debugging). Updated slides and code from the video will be posted on the course GitHub. 

## CSE Mantra: *Start early, start often!*
*You will notice throughout the quarter that the PAs get harder and harder. By starting the quarter off with good habits, you can prepare yourself for future PAs that might take more time than the earlier ones.*



## Baskets and Interns

Imagine that you work for a hot new Web shopping company. You know it's critical to have shopping cart functionality so users can keep track of items before they check out. Focus group studies tell you that `Basket` is the name for the feature your users will enjoy the most.  So, you set out to implement a shopping basket interface. The inventory team has already decided that all items will be constructed from the class `Item` (given in `baskets/Item.java`), which you need to work with.

As an excellent software designer, you consider things interface-first, and come up with the following interface for the `Basket`:

```java
public interface Basket {
	/*
	 * @return the total count of all items, counting duplicates, in the basket.
	 */
	int count();

	/*
	 * @param i The item to count
	 *
	 * @return The number of the provided Item that are in the basket
	 */
	int countItem(Item i);

	/*
	 * @return the total cost in cents of all items in the basket, counting duplicates
	 */
	int totalCost();

	/*
	 * @param i The item to add
	 */
	void addToBasket(Item t);

	/*
	 * Remove a single copy of an item from the basket
	 *
	 * @param i The Item to remove
	 *
	 * @return false if the item was not in the basket, true otherwise
	 */
	boolean removeFromBasket(Item i);

	/*
	 * Remove all copies of an item from the basket
	 *
	 * @param i The Item to remove
	 *
	 * @return false if the item was not in the basket, true otherwise
	 */
	boolean removeAllFromBasket(Item i);

	/*
	* Remove all items from the basket
	*/
	void empty();

}
```

You're strapped for time because you're working on a number of projects, but
you figure you can leverage your interns to get this done on time and under
budget. You send a message with the interface above to your team of
interns and tell them to implement it.

A few days later, you realize you sent the message to _all_ the interns in
your department, and you now have 13 _different_
implementations of `Basket`. All of them indeed implement the interface
in terms of Java types, but as you begin trying them out, you notice that
they don't all have the same behavior.

You want to understand the situations that make each of these
implementations differ, in order to decide which one to use. In addition,
you figure it would be useful to give all the interns some feedback. You
want to be able to tell them, specifically, why their implementation
differed. So you set a goal for yourself: You will come up with a set of
tests such that, for each implementation, the tests pass and fail in a way
that is _unique_ to that implementation. This will truly demonstrate how
they differ.

## Getting the Code

The starter code is in the Github repository that you are currently looking at. If you are not familiar with Github, here are two easy ways to get your code.

1. Download as a ZIP folder 

    After going to the Github repository, you should see a green button that says *Code*. Click on that button. Then click on *Download ZIP*. This should download all the files as a ZIP folder. You can then unzip/extract the zip bundle and move it to wherever you would like to work.  
    ![](https://i.imgur.com/ujaxqBP.png)


2. Using git clone (requires terminal/command line)

    After going to the Github repository, you should see a green button that says *Code*. Click on that button. You should see something that says *Clone with HTTPS*. Copy the link that is in that section. In terminal/command line, navigate to whatever folder/directory you would like to work. Type the command `git clone _` where the `_` is replaced with the link you copied. This should clone the repository on your computer and you can then edit the files on whatever IDE you see fit.
    
If you are unsure or have questions about how to get the starter code, feel free to make a Piazza post or ask a tutor for help.

## Code Layout

There are a number of files provided in the starter code in the folder `baskets`:

- `Basket0-12.java`: These files hold the interns' implementations of
  `Basket`. You are free to read and inspect them as much as you'd
  like. You should *not* change them.
- `Basket.java`: The interface we defined above. You should *not*
  change this.
- `BasketTest.java`: This is where you will do your work, described in
  detail below.

## Part 1: Writing Tests (13 points)

You will write your tests as JUnit tests in the file `BasketTest.java`.
There is some pre-existing code in this file that you shouldn't change, and
an example that follows to get you started.

The top of the file sets things up so that the tests will run once against each
provided implementation of `Basket`. This is what the `@Parameterized` and
related methods are doing. The main feature that is relevant to your work is
that the method `makeBasket`, which can be called to create a new, empty
`Basket` of the current type under test. You will use `makeBasket` to create
the objects you test against.

Your work will happen in methods annotated with `@Test`, below the definition
of `makeBasket`. We've gotten you started with an example. Intern 0 _really_
didn't get much working (go look at `Basket0.java` to see just how much). The
implementation `Basket0` is the only one that will fail this test:

```java
@Test
public void addedHasCount1() {
  Basket basketToTest = makeBasket();

  Item i = new Item("Shampoo", 5);
  basketToTest.add(i);
  assertEquals(basketToTest.count(), 1);
}
```

That is, if we create a new empty `Basket` and add an `Item` to it, we should
expect that the total count of items is `1` after. If you run the program with
just this test defined, you will see that it fails _only_ on `Basket0`-created
bags. It works just fine on the other implementations, whose mistakes and
differences are more subtle.

Your task is to write more methods like `addedHasCount1` with more
sophisticated assertions that fail on the different implementations in
different ways. Here are some things to think about; they don't exhaustively
cover the space of issues, but they help.

- Adding duplicate items to the baskets
- Adding lots of items to the baskets
- Different kinds of removal from the baskets
- Adding and removing the same item
- Focusing on potential off-by-one errors with the first and last items in a
  basket

## Running and Reading JUnit Results

To run the tests, you can click the green arrow button in Eclipse with `BasketTest.java` open (or *Run As* > *JUnit Test*). The left-hand pane will show a tree view of which tests succeeded and failed on each Basket implementation. You can click on the dropdown arrow next to each Basket name to see which specific tests suceeded and failed, and click on the individual tests to see them in the source window and see a description of the failures.

(Optional) You can also run the tests from the command line. In the `baskets` folder, you may execute the following commands to compile and run. 

Running on UNIX based (Mac or Linux) systems:
- Compile: `javac -cp ../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar:. *.java`
- Execute: `java -cp ../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore BasketTest`

Running on Windows systems:
- Compile: `javac -cp ..\lib\junit-4.12.jar;..\lib\hamcrest-core-1.3.jar; *.java`
- Execute: `java -cp ..\lib\junit-4.12.jar;..\lib\hamcrest-core-1.3.jar; org.junit.runner.JUnitCore BasketTest`



Note that in this assignment, _a failing test is not (necessarily) a bad thing_. You are _trying_ to write tests that fail on some implementations and not others, in order to distinguish their behavior. As a result, you should not expect JUnit to be responding with all successes. In fact, you should be consulting the various outputs to make sure that the test suite produces a _unique_ set of results on each `Basket` implementation. A consequence of this is that there should have at most one `Basket` implementation that succeeds on all the tests you wrote.

Hint: One `Basket` might not necessarily be that buggy. This means it will pass all of your tests. HOWEVER, it is possible to have all `Basket` implementations fail tests. 

## Part 2: Gradescope Assignment (7 points)

You will also answer question on Gradescope regarding the assignment.
The following are the questions you will need to answer. **Make sure to submit directly to the Gradescope assignment: "Programming Assignment 1 - questions"** 

1. Some of the `Basket` implementations are buggy – they have clear mistakes in
   some situations. Others simply differ in behavior. For each implementation,
   indicate if you think it has a clear _bug_, and describe the problem, or if
   it's simply an implementation _choice_. Give one sentence for each bag. Note
   that this requires exercising your own judgment, which we cannot do for you.

   Here's an example: “Basket0 is clearly buggy, because under no reasonable
   implementation should the bag claim to be empty after having something added.”

2. Pick three of the `Basket` implementations other than `Basket0`. In 150
words or less, describe the tests that differ across them, and why the
implementations produce those different results. You don't have to talk in
detail about _all_ of your tests, just the ones that usefully distinguish three
implementations of your choice.

In addition, put any collaborators you worked with in the Collaborator section of the gradescope assignment <a href="https://ucsd-cse12-w21.github.io/#programming">as described in the collaboration policy for open assignments</a>.

## Part 3: Debugging (5 points)
When programming, debugging skills are just as necessary as testing. Imagine that you work for an online bank. The previous software developer left some code that deals with managing user accounts, specifically withdraws and deposits. Unfortunately, the file is riddled with errors, bugs, and no comments!

The file can be found in `bank/BankAccount.java`. From the file, you know that the main method is error-free, however, everything else might have errors. Do **NOT** modify the `printBalance()` method, the `main()` method, or the filename. Everything else can be modified, within reason, as long as it follows the descriptions below.  

### There are two instance variables:
- ##### `int accountID`
    Represents the account number for the `BankAccount` object.

- ##### `double[] accountBalance`
    Stores the current balance amounts for the account. `accountBalance` is a double array that should have a length of two. The array index 0 represents the "Checking" account and the array index 1 represents the "Savings" account.

### And four methods:
- ##### `getAccountID()`
    Returns the account ID.

- ##### `getBalance(int account)`
    Returns the balance of the given account (Checking or Savings).

- ##### `deposit(double amount, int account)`
    Adds the amount to the given account.

- ##### `withdraw(double amount, int account)`
    Removes the amount from the given account. 


The expected output for the given main method should be: 
```
Account 101 balance: Checking = $50.00, Savings = $125.00
Withdraw payment 1 of $19.95
Account 101 balance: Checking = $30.05, Savings = $125.00
Withdraw payment 2 of $19.95
Account 101 balance: Checking = $10.10, Savings = $125.00
Withdraw payment 3 of $19.95
Insufficient funds. You need: $9.85
Account 101 balance: Checking = $10.10, Savings = $125.00
```

However, currently the code outputs this: 
```
Error: Could not find or load main class BankAccount
Caused by: java.lang.ClassNotFoundException: BankAccount
```

For this part of the assignment, find *all* errors in `BankAccount.java` and correct them to get the expected output. For each error that you find, add a comment where the error occurred and what type of error it is (Compile, Runtime, or Logic).  

Again, do **NOT** modify the `printBalance()` method, the `main()` method, or the filename. Everything else can be modified within reason. Ensure that you are using the method headers stated above (hint: this might help you catch one of the bugs!).  


## Style

To find the full style guideline, follow this link: https://docs.google.com/document/d/1XCwv_vHrp1X4vmlmNJIiXnxPuRLPZQkQEGNrJHJ0Ong/edit?usp=sharing  

All guidelines that we will be following this quarter are marked in the Style Guidelines document. These are required and will be graded. 

On this assignment, we will give you feedback on style but not deduct points
for problems with style. For the first few PAs we will be lenient and only focus on a few guidelines at a time. However, by PA5 we will expect all marked guidelines to be followed. 

Here are some suggestions for style in this PA:

- Names of methods (especially test methods) can appear in error output and
  test output. Choose meaningful names for them to help you understand the
  output of your program.

- Consider writing helper methods if you repeatedly use the same set of
  statements to construct or manipulate a `Basket`. This can make writing tests over larger examples much simpler.


## Submitting
#### Part 1 & 3
On the Gradescope assignment **Programming Assignment 1 - code** please submit only your `BasketTest.java` and `BankAccount.java` file. You may encounter errors if you submit extra files or directories. You may submit as many times as you like till the deadline. 
#### Part 2
Please submit your answers to the questions from part 2 on the Gradescope assignment **Programming Assignment 1 - questions**. You may submit as many times as you like till the deadline.


## Scoring (25 points total)
* **Coding Style** (0 points)
* **Part 1 - Code Correctness** (13 points)
    * Does your code compile? If not, you will get 0 points.
    * Note: we will make all tests visible on Gradescope for this first assignment. For future assignments this will change. Do not rely on Gradescope for debugging!
* **Part 2 - Questions** (7 points)
* **Part 3 - Debugging** (5 points)
    

