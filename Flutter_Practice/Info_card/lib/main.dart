import 'package:flutter/material.dart';

// Using Card class and ListTile standard approach
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
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              CircleAvatar(
                radius: 70.0,
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
              SizedBox(
                height: 20.0,
                width: 150.0,
                child: Divider(
                  color: Colors.teal.shade100,
                ),
              ),
              Card(
                margin: EdgeInsets.symmetric(vertical: 10.0,horizontal: 25.0),
                child: ListTile(
                  leading: Icon(
                    Icons.phone,
                    //size: 100,
                    color: Colors.teal,
                  ),
                  title: Text(
                    '+1 91028304',
                    style: TextStyle(
                        color: Colors.teal.shade900,
                        fontFamily: 'SourceSansPro-Regular',
                        fontSize: 17.5
                    ),
                  ),
                ),
              ),
              Card(
                margin: EdgeInsets.symmetric(vertical: 10.0,horizontal: 25.0),
                child: ListTile(
                  leading: Icon(
                    Icons.email,
                    //size: 100,
                    color: Colors.teal,
                  ),
                  title: Text(
                    'john@xyz@gmail.com',
                    style: TextStyle(
                        color: Colors.teal.shade900,
                        fontFamily: 'SourceSansPro-Regular',
                        fontSize: 17.5
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

}