import 'package:flutter/material.dart';

// Using Card class and Row class
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.teal,
        body: SafeArea(
          child: Column(
            children: <Widget>[
              CircleAvatar(
                radius: 50.0,
                backgroundColor: Colors.blueGrey,
                backgroundImage: AssetImage(
                  "images/Vrushank_profile.jpeg"
                ),
              ),
              Text(
                "Vrushank Patel",
                style: TextStyle(
                  fontSize: 40.0,
                  //fontWeight: FontWeight.bold,
                  color: Colors.white,
                  fontFamily: 'Pacifico',
                ),
              ),
              Text(
                "SOFTWARE ENGINEER",
                style: TextStyle(
                  fontSize: 15.0,
                  fontWeight: FontWeight.bold,
                  color: Colors.teal.shade100,
                  fontFamily: 'SourceSansPro-Regular',
                  letterSpacing: 2.5,
                ),
              ),
              Card(
                color: Colors.white,
                margin: EdgeInsets.symmetric(vertical: 10.0,horizontal: 25.0),
                // padding: EdgeInsets.all(10.0), // use this for container only not for card
                child: Padding(
                  padding: const EdgeInsets.all(21.0),
                  child: Row(
                    children: <Widget>[
                      Icon(
                        Icons.phone,
                        //size: 100,
                        color: Colors.teal,
                      ),
                      SizedBox(
                        width: 10.0,
                      ),
                      Text(
                        '+1 91028304',
                        style: TextStyle(
                          color: Colors.teal.shade900,
                          fontFamily: 'SourceSansPro-Regular',
                          fontSize: 17.5
                        ),
                      )
                    ],
                  ),
                ),
              ),
              Card(
                color: Colors.white,
                margin: EdgeInsets.symmetric(vertical: 10.0,horizontal: 25.0),
                // padding: EdgeInsets.all(10.0), // use this for container only not for card
                child: Padding(
                  padding: const EdgeInsets.all(21.0),
                  child: Row(
                    children: <Widget>[
                      Icon(
                        Icons.email,
                        //size: 100,
                        color: Colors.teal,
                      ),
                      SizedBox(
                        width: 10.0,
                      ),
                      Text(
                        'john@xyz@gmail.com',
                        style: TextStyle(
                            color: Colors.teal.shade900,
                            fontFamily: 'SourceSansPro-Regular',
                            fontSize: 17.5
                        ),
                      )
                    ],
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }

}