import 'package:flutter/material.dart';

class CustomThemeBuilder{
  ThemeData customThemeBuilder(){
    return ThemeData.dark().copyWith(
      primaryColor: Color(0xFF0A0E21),
      scaffoldBackgroundColor: Color(0xFF0A0E21),
      //accentColor: Colors.purple,
      /*textTheme: TextTheme(
        bodyText1: TextStyle(
            color: Colors.red
        ),
        bodyText2: TextStyle(
            color: Colors.white
        ),
      ),*/
    );/*ThemeData(
      primaryColor: Color(0xFF0A0E21),
      scaffoldBackgroundColor: Color(0xFF0A0E21),
      accentColor: Colors.purple,
      textTheme: TextTheme(
        bodyText1: TextStyle(
          color: Colors.red
        ),
        bodyText2: TextStyle(
            color: Colors.white
        ),
      ),
    );*/
  }
}