import 'package:flutter/material.dart';
import 'package:audioplayers/audio_cache.dart';

void main() => runApp(XylophoneApp());

class XylophoneApp extends StatelessWidget {
  final player = AudioCache();
  var xyloButtonColors = [
    Colors.red,
    Colors.orange,
    Colors.yellow,
    Colors.green,
    Colors.teal,
    Colors.lightBlue,
    Colors.purple
  ];

  Expanded buildXylophoneButton(Color color,int soundNumber) => Expanded(
      child: FlatButton(
        color: color,
        onPressed: (){
          player.play('note$soundNumber.wav');
        },
      ),
    );

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.black,
        body: SafeArea(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              for(var i=0; i<xyloButtonColors.length; i+=1) buildXylophoneButton(xyloButtonColors[i], i+1)
            ]
          ),
        ),
      ),
    );
  }
}