import 'package:flutter/material.dart';
import 'dart:math';

void main() => runApp(
  MaterialApp(
    home: Scaffold(
      backgroundColor: Colors.blue[400],
      appBar: AppBar(
        title: Text(
          'Ask Me Anything'
        ),
      ),
      body: BallPage(),
    ),
  ),
);

class BallPage extends StatefulWidget {
  @override
  _BallPageState createState() => _BallPageState();
}

class _BallPageState extends State<BallPage> {
  int ballnumber = 1;
  @override
  Widget build(BuildContext context) {
    return FlatButton(
        child: Center(
          child: Image.asset('images/ball$ballnumber.png'),
        ),
        onPressed: (){
          setState(() {
            ballnumber = Random().nextInt(5)+1;
          });
        },
    );
  }
}
