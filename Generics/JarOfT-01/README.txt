1. Jar of T
Create a class Jar<> that can store anything.
It should have two public methods:

void add(element)
element remove()
Adding should add on top of its contents. Remove should get the topmost element.

Examples:

Jar<Pickle> jarOfPickles = new Jar<>();

jarOfPickles.add(new Pickle());
jarOfPickles.add(new Pickle());

Pickle pickle = jarOfPickles.remove();