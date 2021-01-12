import 'package:bmi_calculator/screens/result_page.dart';
import 'package:bmi_calculator/components/themebuilder.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'screens/input_page.dart';

void main(){
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp])
      .then((_) {
    runApp(BMICalculator());
  });
}

class BMICalculator extends StatelessWidget {
  final themeBuilder = CustomThemeBuilder();
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: themeBuilder.customThemeBuilder(),
      home: InputPage(),  // you can create home either home property or routes
      /*initialRoute: '/',
      routes: {
        '/': (context) => InputPage(),
        '/result_page': (context) => ResultsPage()
      },*/
    );
  }
}

