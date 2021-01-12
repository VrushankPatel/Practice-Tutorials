void main(){

  String a = "123abc";

  double b;
  try{
    b = double.parse(a);
  }catch(e){
    print("Exception is : " + e.toString());
  }

  print(b);

  int aa;

  print(aa ?? 23); // check if a is null then print 23 otherwise print a's value

}