import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class RoundIconButton extends StatelessWidget {
  RoundIconButton({@required this.icon, @required this.changeWeight});

  final IconData icon;
  Function changeWeight;

  @override
  Widget build(BuildContext context) {
    return RawMaterialButton(
      child: Icon(icon),
      onPressed: changeWeight,
      constraints: BoxConstraints.tightFor(width: 45.0, height: 45.0),
      shape: CircleBorder(),
      //shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20.0)),
      fillColor: Color(0xFF4c4F5E),
    );
  }
}
