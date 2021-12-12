# ShoppingListApplication

1.) The Goal of the applicatiom : The goal of the application is to get a list of products from a webservice (http://fakestoreapi.com),
then be able to visualize the selected products in the cart  using the bottom navigation.

2.)How to Compile and run the application : For the develop of the application the IDE used was Android Studio Artic Fox 2020.3.1 , 
the gradle version used is 7.0.2

3.)

4.) The architecture of the application uses MVVM , for the request of information of the API i used retrofit , and for the store of the information
in the device i used Room + LiveData. Prefered to use MVVM instead MVP because i was especting to be able to also give a design for horizontal view 
of the items in the applicatiom , sadly runned out of time. The Architecture divides the data layer and view layer into two different files , the comunication
bteween this is done through the viewmodel and repository. Also used databidning for quicker and cleaner way to attach the data to the XML.

5.)Any other instruction or notes you have : Due to time there is a mistake in the data layer where i placed the database entity in the domain file. 
