import 'package:bmi_calculator/constants.dart';
import 'package:flutter/cupertino.dart';

class BottomButton extends StatelessWidget {
  const BottomButton({@required this.buttonText,@required this.onPressed});

  final String buttonText;
  final Function onPressed;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onPressed,
      child: Container(
        color: kMaterialActiveColor,
        margin: EdgeInsets.only(top: 10.0),
        width: double.infinity,
        height: kBottomContainerHeight,
        child: Center(
          child: Text(buttonText,style: kLargeButtonStyle),
        ),
        //padding: EdgeInsets.only(bottom: 15.0),
      ),
    );
  }
}