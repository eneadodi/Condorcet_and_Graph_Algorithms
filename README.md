# Social Voting and Graph Algorithms

### Introduction

My first three years of College and majoring in Computer Science I had one goal of expanding my breadth of knowledge in the Computer Science realm.  
I have explored the fields of Scientific Computing, Android Application Development, Assembly and Computer System principles, Game Design and Visual Programming, web design, Encryption, etc.
I have gained an (at least basic) intuitive understanding of each of these fields to develop myself as a well rounded Computer Scientist. For my senior year, I am focusing on further exploring depths of certain fields and make myself ready as a competent competitor for namely two categories : IOS/Android Application development and Artifical Intelligence. 

For the Summer of 2020 I decided to keep myself very busy with my fields of interests. In the prior 2/3rds of the Summer, I explored fields such as Graph Theory and Finite Calculus, built my own [website](http://www.eneadodi.com), and completed a multidude (30+) of Computer Science Interview Preperation Questions.

**During the first 2/3rds of Summer 2020 I also:**

* Impletemented various algorithms from scratch (in C++ or Java) such as:
    * Djikstra's algorithm 
    * Kruskal's algorithm
    * BFS & DFS
    * Quicksort and Mergesort
 
* Read the works of Great Philosophers such as:
    * Immanuel Kant
    * René Descartes
    * Aristotle
    * Confucius
 
* Changed my morning routine to include Meditation and Cold Showers

* Stayed Physically active and exercised most days of the week

* Learned [Usher's Waltz](https://www.youtube.com/watch?v=w3ulenPf_II) in it's entireity on Classical Guitar

* Made time to have fun too!

**The Final Third of Summer 2020 I plan to implement my knowledge and buld projects to feature on my resume.**

1) Machine Learning Stock Predictor
2) Social Voting Theory Android Application 
3) Philosophical Essay

### Summer 2020 Project 2 : Social Voting Theory Android Application

Both the Android Application repository and the algorithms used/researched will be posted here. 

Be it for a head start, rememberance, and/or simply necessity to create certain Condorcet algorithms, I built/will built from scratch:
 * Generic Vertex Class
 * Generic Weighted & Unweighted Edge Class
 * Generic Weighted & Unweighted Graph Class
 * BFS
 * DFS 
 * Djikstra
 * Tideman Method
 * Kemeny-Young Method
 
**Application Explanation**

For understanding of Software Engineering and the methodologies (such as Agile), I am currently enrolled in a course which focues on just that (where we built a software from scratch throughout the semester as a team). The hope is to understand the team-building, communication, and overall nature of software engineering in this course. That coupled with this project will hopefully give me a necessary foundation not only in the term software engineering as a whole, but the connections and links involved in the entity.

I will be developing a Condorcet Voting Application for the Android operating system. The goal of this application is to familiarize myself with the Front-End and Back-End of application development.

**The overall process of this application will be defined below. For a more in depth analysis and explanation of the application there will be a complementary document with exactly that function.** 

This application can be viewed as an election application. One user will create a voting process, specifying discrete candidates that the other users will be voting upon. Each other user will rank their preferences from their most preferred to their least preferred.
These rankings will be on a 100 point system. With the current implementation, no two candidates can tie in points. As an example:

Dinner for Tonight:
   Enea's Ranking
   * Pizza : 63
   * Pasta : 64
   * Börek : 97
   * Cheesecake : 23

Initally, these rankings will simply be converted to a candidate sorting (1st Börek , 2nd Pasta, 3rd Pizza, 4th Cheescake)

Once a user has voted, their rankings will be uploaded to a cloud dattabase (such as firebase) under their account. 
Once all users have voted, the backend automatically runs Tideman's method on the rankings and will attempt to output the candidate who is the Condorcet Winner.
Each user will be notified of the results on their accounts.

In the case where no Condorcet winner is achieved, my modification of the Tideman's method, using the point system, will weigh the preferences of the users and 
output a proxy-Condorcet Winner. It will initally attempt to do so with the slightest weighing of the preferences, and increase the weights until a proxy-Condorcet Winner is found. 

**Condorcet Winner** - The candidate that would win a majority of the vote in all of the head-to-head elections against each of the other candidates
More information about Condorcet winners: https://en.wikipedia.org/wiki/Condorcet_method

----------------------------------

Note: As I was working on both a Java project and a Python project at the same time, I did my best to adhere to code conventions of the individual projects. However, there is a possibility I camel-cased something in Python, or I snake-cased something in Java and I was unable to catch it doing read throughs of my code due to working on both projects at the same time. If there are conventions I am not following please feel free to contact me!

Contact: eneadodi@umass.edu
