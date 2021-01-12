void main() {

  perform();
}

void perform() async{
  int a = await task1();
  task2(a);
  task3();
}

Future task1() async{
  int count;
  await Future.delayed(Duration(seconds:3),(){
    count = 0;
    while(count < 10){
      print("yes" + count.toString());
      count++;
    }
  });
  return count;
}
void task2(int a){
  print("thanks" + a.toString());
  print("thanks2");
}
void task3(){
  print("vrushank");
  print("patel");
}