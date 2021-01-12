import 'package:bmi_calculator/constants.dart';
import 'package:flutter/cupertino.dart';

class IconContent extends StatelessWidget {
  const IconContent({this.icon, this.cardText});

  final IconData icon;
  final String cardText;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Icon(
          icon,
          size: 80.0,
        ),
        SizedBox(
          height: 15.0,
        ),
        Text(
          cardText,
          style: kLabelTextStyle,
        )
      ],
    );
  }
}

