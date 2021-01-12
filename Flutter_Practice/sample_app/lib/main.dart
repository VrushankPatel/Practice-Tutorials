import 'package:flutter/material.dart';

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
            //mainAxisSize: MainAxisSize.min,
            //mainAxisSize: MainAxisSize.max,
            //verticalDirection: VerticalDirection.up, // arrange down to up side
            verticalDirection: VerticalDirection.down, // default arrange up to down side
            //mainAxisAlignment: MainAxisAlignment.start,  // arrange starting to ending part, if verticaldirection is up then up to down
            //mainAxisAlignment: MainAxisAlignment.end,  // arrange ending to starting part, if verticaldirection is up then down to up
            //mainAxisAlignment: MainAxisAlignment.center,
            //mainAxisAlignment: MainAxisAlignment.spaceBetween, //first child at the starting os most, last will on end pos most and between's widgets will be with same space
            //mainAxisAlignment: MainAxisAlignment.spaceEvenly, // same space between all childeren widgets
            crossAxisAlignment: CrossAxisAlignment.stretch, // it will make all the widgets long as the widest widgets to keep them parallel
            //crossAxisAlignment:  CrossAxisAlignment.center, // keep all widgets in center aligned with original size
            //crossAxisAlignment: CrossAxisAlignment.end, // align all widgets at the end of axis horizontally
            children: <Widget>[
              Container(
                height: 100.0,
                width: 100.0,
                // Margin means the spacing outside of the border,
                // while padding is the spacing inside of the border
                //margin: EdgeInsets.all(90.0),
                //margin: EdgeInsets.symmetric(vertical: 50.0, horizontal: 10.0),
                //margin: EdgeInsets.fromLTRB(30.0, 10.0, 45.0, 35.0),
                margin: EdgeInsets.only(left: 30.0),
                padding: EdgeInsets.all(30.0),
                color: Colors.white,
                child: Text('container 1'),
              ),
              SizedBox(height: 20.0), // kind of spacer to keep the space between children widgets also we can give width to it
              Container(
                height: 100.0,
                width: 300.0,
                margin: EdgeInsets.only(left: 30.0),
                padding: EdgeInsets.all(30.0),
                color: Colors.white,
                child: Text('Container 2'),
              ),
              Container(
                height: 100.0,
                width: 100.0,
                margin: EdgeInsets.only(left: 30.0),
                padding: EdgeInsets.all(30.0),
                color: Colors.white,
                child: Text('Container 3'),
              ),
            ],
          )
        )
      ),
    );
  }
}