import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.blueGrey[300],
        appBar: AppBar(
          backgroundColor: Colors.blueGrey[800],
          title: Text('I am poor.'),
        ),
        body: Center(
          child: Image(
            image: AssetImage('images/i_am_poor_icon.png'),
          ),
        ),
      ),
    );
  }

}