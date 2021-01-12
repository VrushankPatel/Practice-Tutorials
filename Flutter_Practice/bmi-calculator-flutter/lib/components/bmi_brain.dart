import 'dart:math';

class BMIBrain{
  BMIBrain({this.weight,this.height});
  final int height;
  final int weight;
  double _bmi;

  String calculateBMI(){
    this._bmi = weight/pow(height/100, 2);
    return this._bmi.toStringAsFixed(1);
  }

  String getResult(){
    if(this._bmi >=25){
      return 'Overweight';
    }else if(this._bmi > 18.5){
      return 'Normal';
    }else{
      return 'Underweight';
    }
  }

  String getSuggestion(){
    if(this._bmi >= 25){
      return 'You have higher then normal body weight. Try to exercise more.';
    }else if(this._bmi > 18.5){
      return 'You have normal weight, Good job!';
    }else{
      return 'You have lower then normal body weight, you can eat bit more.';
    }
  }
}