import 'package:flutter/material.dart';

void main() {
  runApp(My_app());
}

class My_app extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.blueGrey,
        appBar: AppBar(
          title: Text('I Am Rich.'),
          backgroundColor: Colors.blueGrey[900],
        ),
        body: Center(
          child: Image(
              //image: NetworkImage('https://www.w3schools.com/w3css/img_lights.jpg'),
            image: AssetImage('images/diamond.png'),
          ),
        ),
      ),
    );
  }
}