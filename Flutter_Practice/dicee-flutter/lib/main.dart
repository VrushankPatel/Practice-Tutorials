import 'dart:math';

import 'package:flutter/material.dart';

final _random = new Random();

void main() {
  return runApp(
    MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.blue[600],
        appBar: AppBar(
          backgroundColor: Colors.blue[900],
          title: Text('Dicee'),
        ),
        body: DicePage(),
      ),
    ),
  );
}

class DicePage extends StatefulWidget {
  @override
  _DicePageState createState() => _DicePageState();
}

class _DicePageState extends State<DicePage> {
  int leftDiceNumber = Random().nextInt(6)+1;  // 6 means 0 to 5 so +1 is required for convert it to 1 to 6
  int rightDiceNumber = Random().nextInt(6)+1;

  void generateDiceFace(){
    setState(() {
      rightDiceNumber = Random().nextInt(6)+1;
      leftDiceNumber = Random().nextInt(6)+1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        children: <Widget>[
          Expanded(
            //flex: 10, // default flex is 1 for all widgets
              child: Padding(
                padding: const EdgeInsets.all(0.0),  // remove padding class and paddding property if you're using the flat button
                child: FlatButton(   // Flat button comes with padding of 16 for left and right
                    onPressed: generateDiceFace,
                    child: Image.asset('images/dice$leftDiceNumber.png')
                ),
              )  // replace of Image( image: AssetImage('fdsafdsa.png'))),
          ),
          Expanded(
            //flex: 3, // default flex is 1 for all widgets
              child: Padding(
                padding: const EdgeInsets.all(0.0),  // remove padding class and paddding property if you're using the flat button
                child: FlatButton(   // Flat button comes with padding of 16 for left and right
                  onPressed: generateDiceFace,
                  child: Image.asset('images/dice$rightDiceNumber.png'),
                ),
              )  // replace of Image( image: AssetImage('fdsafdsa.png'))),
          )
        ],
      ),
    );
  }
}
class DiceAction{

}
// to generate random number between range but we havn't used this in this program
class Utilities{
  static int getRandom(int min, int max) => min + _random.nextInt(max - min);
}