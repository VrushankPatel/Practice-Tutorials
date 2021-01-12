import Cocoa
import Darwin

//var declaration
var h = 12 //default int
var b:Bool = true
var a:Int = 344
var w:String = "Hello world"
let pi = 3.14 //constant
var pi2:Float = 3.1415 //float
var pi3:Double = 3.1415 //double
var t:Character = "A" //character
var (v,g,f) = (23,34,45) //multi var assignment
(v,g) = (g,v) //swap variables

//Maximum and minimum limits of data type
print("Min int is \(Int64.min)")
print("Max int is \(Int64.max)")
print("Min double is \(Double.leastNormalMagnitude)")
print("Max double is \(Double.greatestFiniteMagnitude)")
print("Max Float is \(Float.greatestFiniteMagnitude)")

//Type casting
var msg = String(a) + w, three:Double = 3.0, two:Int = 2
var five = three + Double(two)
print("3:\(Int(3.14))")

//and operator with if else conditions
var age:Int = 8
if age < 5{
    print("Goto preschool")
} else if age == 5 {
    print("Goto kindergarten")
} else if (age > 5) && (age <= 18){
    print("Goto grade \(age-5)")
} else {
    print("Goto college")
}

// or operator with if else conditions
var income:Double = 12000, gpa:Double = 3.7
print("Get grant : \((income < 15000) || (gpa >= 3.8))")
print("not true :\(!true)")

age = 8
var canDrive:Bool = age>=16 ? true : false

//switch case
let ingrediant = "pasta"

switch ingrediant {
case "tomatoes","pasta":
    print("Spaghetti")
    fallthrough
case "potatoes":
    print("Mashed potatoes")
case "beans":
    print("Burrito")
default:
    print("Water")
}
//switch to maths ranges
let test:Int = 98

switch test {
case 93...100:
    print("You got A")
default:
    print("You didn't got A")
}

//maths oparators
print(5/4)
5.0/4.0
5.0/4
5/4.0
5*1.0
5%2
5+4
5+4.1
Int(5+4.1)
4.1+5.1*10
age+=1
age-=1
age/=3
age*=2

//some inbuilt math functions
abs(-5.3)
floor(2.34)
ceil(2.34)
max(5,4,7,2,1)
min(1,6,2,5,3,9,4)
pow(2, 7)
sqrt(99)
log(2.76)
sin(2.5432)
cos(2.5432)
tan(2.5432)
sinh(4.45)
cosh(4.45)
tanh(4.45)
asin(4.45)
acos(4.45)
atan(4.45)

//Swift strings

print("\tvrushank")

var randstr = "This is random string"
var randstr2 = "and here is another"

print(randstr + " " + randstr2)
print(randstr.count)
print((randstr + " " + randstr2).count)
randstr2[randstr2.startIndex]

//getting 5th element of string randstr
print(randstr[randstr.index(randstr.startIndex,offsetBy : 0)])

//Check if string is empty or not
print(randstr.isEmpty)
randstr = ""
print(randstr.isEmpty)
randstr = "This is random string"

//insert character between strings
randstr.insert("V", at: randstr.startIndex)

//insert string between strings
randstr.insert(contentsOf : "Vrushank" , at : randstr.index(randstr.startIndex,offsetBy : 3))

//getting string or sub string from apecific range of main strings
    // slicing string from 0 to 11 or up to 11
randstr[..<randstr.index(randstr.startIndex,offsetBy : 11)]
    // slicing string from 11 to ... end of string
randstr[randstr.index(randstr.startIndex,offsetBy : 11)..<randstr.index(randstr.startIndex,offsetBy : randstr.count)]
    // slicing string from 8 to 15
randstr[randstr.index(randstr.startIndex,offsetBy : 8)..<randstr.index(randstr.startIndex,offsetBy : 15)]
    //replace string by another if found
if let herematch = randstr.range(of: "random"){
    randstr.replaceSubrange(herematch,with:  "best random")
}

//Arrays
var tt = [1,3,66,65,22,3,1,66] //simple array
(tt[1],tt[2]) = (tt[2],tt[1]) //swaping values of array
tt.reverse() //reverse the array
tt.first //first element of array
tt.last //last element of array
tt.capacity //how much capacity does array has to insert elements
tt.count //length of array
tt.min() //smallest element of array
tt.max() //maximum value of array elements
tt.remove(at: 3) //removing number by passing destination number index
tt.removeFirst()
tt.removeLast()
tt.removeAll() //removing all values with its capacity
tt.removeAll(keepingCapacity: true) //removing all value but not remove its highest capacity

var array1 = [Int]() //blank array declaration only with type
print(array1.isEmpty) //Check if array is empty or not
//appending the element to array at index 0
array1.append(12)
array1 += [7,9]
array1[0]
array1[0]=13
//inserting elements to array at specific index
array1.insert(10, at: 0)
array1.insert(10, at: 0)
array1.insert(34, at: 2)
array1[2..<5] //sliceing array
array1[2..<array1.count] //sliceing array
array1[0..<3] //sliceing array >=0 but <3
array1[0...2] //slicing array >=1 and <=2
array1[0...4] = [32,43,54,65,755] //replace the value of index 0,1,2,3, and 4
array1.count

var array2 = Array(repeating: 3, count: 5)
array1 + array2

// for in loop in swift
//print index and their values of array
    // array1.enumrated will return index and value both one by one
for (index,value) in array1.enumerated()
{
    print("\(index) : \(value)")
}
//for loop and range
for i in 1...18{ //1...18 means >=1 and <=18
    print("I is \(i)")
}
//print values of array
for item in array1
{
    print(item)
}

for i in 1...10 //range of 1 to 10 means >=1 and <=10
{
    print(i)
}
    // for in loop with condition. it'll print only even numbers from 1 to 10
for i in 1...10 where i % 2 == 0
{
    print(i)
}

//while loop to print odd number up to 10 but break when found 7
var i:Int = 1
while i<10
{
    if i % 2 == 0{
        i+=1
        continue
    }
    if i == 7{
        break
    }
    print(i)
    i+=1
}

// Swift repeat - while loop insted of do - while loop
//this program will reeat loop random number times where random number will up to 15
let randnum:UInt32 = arc4random_uniform(15)
var guess: UInt = 0
/*
 repeat{
 print("Guess : \(guess)")
 guess += 1
 }while randnum != guess*/
print("Magic random number was : \(randnum)")

//Swift dict
var sampledict = Dictionary<Int,String>() //declaration of dict, easy declaration dict by statement given below
var months:[Int:String] = [1:"Jan",2:"Feb",3:"Mar"] //declare dict
var month = [1:"Jan",2:"Feb",3:"Mar"] //easy declare dict
print(months[2]!) //to access value ! is copulsory becauseof optionals
month.updateValue("New Value 2", forKey: 1) //updating the value of dict by key. this function will return the old value.
print("Old value is \(month.updateValue("Ultra new value", forKey: 1)!)")
month
month.keys.sorted() //sort dict by key
month
month.removeValue(forKey: 2) //removing the value from dict by key
    //capacity of array,dict,tuple or set is property that specify maximum how may elements can be stored
month.removeAll() //removing all values from dict with removing it's capacity
month.removeAll(keepingCapacity: true) //removing all values from dict without removing it's capacity.
print(month)

var dict1 = [Int:String]() //dictionary declaration
print(dict1.isEmpty) //check if dictionary is empty or not
dict1[1] = "Vrushank Patel"
var cust : [String : String] = ["1":"vrushank","pol":"opl"]
cust["pol"]
cust["pol"] = "changed" //replace the value
cust["pol"]
// check if key 'pol1' is in dict or not if found then execute the loop otherwise not
if let name = cust["pol1"] //check if the dict key-value exist or not
{
    print("value found and it is : \(name)")
}
//to get all keys and their values of dictionary
for (key,value) in cust {
    print("\(key) : \(value)")
}

// Swift Tuples
    //swift tuples are based on assigned keys which are by default 0,1,2... but we can define the callable keys for tuple
let mydata = (1,"vrushank")
mydata.1 //getting value from tuple is little bit different then array or dict
print(mydata)
var mydata2 = (height: 6.25,weigt : 175) //tuple with callable keys
print(mydata2.height)
print(mydata2.weigt)
    //tuple ex.
var stp = ("vrushank","programmer","Data analyst")
var (kkk,vvv,mmm) = stp //tuple return all elements in 3 variables so one element to each

//swift optionals
//this program will check if there is any party or not. if any party is there then it will print its name
var politicalparty : String?
politicalparty = "Independent"
if politicalparty != nil{
    let party = politicalparty!
    print(party)
}

//insted of above program we can use the rogram represented bwlow
if let party = politicalparty {
    print("Party = \(party)")
}else {
    print("No party")
}

//insted of above two program we can write inline code fiven below
let party = politicalparty ?? "No party"

//Swift user defined functions
    //simple functions with two args defined with their types
func getsum(num1:Int,num2:Int)
{
    print("Sum : \(num1+num2)")
}
getsum(num1:65,num2:29) //calling function

    //function to return int so we will write "-> Int" before function paranthesis {}
func getsum2(num1:Int,num2:Int=1) ->Int{ //look this fun has defaulr parameter
    return num1 + num2
}
print(getsum2(num1: 12,num2:34))

    //function to take many numbers at a time and return sum of them
func getsum3(nums : Int...)->Int{
    var sum:Int = 0
    for num in nums{
        sum += num
    }
    return sum
}
print("Sum : \(getsum3(nums: 1,2,3,4,5,6,7))") //calling function

    //nesting of function
func domath(num1:Double ,num2:Double){
    func divide()->Double{
        return num1 / num2
    }
    print("Division : \(divide())")
}
domath(num1: 5.4, num2: 6.1)

    //function returning multiple values
func twomults(num:Int) -> (two:Int,three:Int){
    return (num*2,num*3)
}

print("7's 2 & 3 mults are : \(twomults(num : 7))")

//Swift variadic parameter.. means dynamic no. of parameters passed to fun
func showname(names:String...){ //... define the param variadic
    for i in names{
        print(i)
    }
}
showname(names: "vrps","avi","masum","hrn")
//Swift closures - miniature function returning value
//we can say that swift closure are functions without function
    //here is the ex of closure. first Int represent Int parameter pass and second Int is return type
var square: (Int) -> (Int) = {
    num in //get argument
    return num*num
}

print("Square of 5 is : \(square(5))")
    //sorting of numbers
let numbers = [8,9,2,3,1,0,7,6,4,5]
let ascendingnums = numbers.sorted()
let dscendingnums = numbers.sorted(by:{
    x,y in x>y
})
print(ascendingnums)
    //getting square of numbers by mapping
let squarednums = numbers.map({
    (num:Int) -> String in
    "\(num * num)"
})

    //program to write closure that will return the function
func add(a:Int,b:Int) -> Int{ //first we'll create function add then use it as return type of another function
    return a+b
}
var mathfun:(Int,Int) -> Int=add //we created closure by above function
print(mathfun(34,43)) //using the closure and indirectly call add function implicitly

//Structs in Swift
    //simple struct
struct mylocation{  //similer to C
    var name : String
    var latitude : Double
    var longitude : Double
}

var myloc = mylocation(name: "vrushank", latitude: 13.344, longitude: 23.544) //making struct var and passing the value
print(myloc)
print(myloc.name,myloc.latitude,myloc.longitude)

    //making function that will accept the parameter struct variable
func showlocation(currloc : mylocation){
    print("Location is \nname : \(currloc.name) \nLatitude : \(currloc.latitude) \nLongitude : \(currloc.longitude)")
}
showlocation(currloc: myloc) //calling function and passing struct var as a parameter

//Swift Enums are our defined types used for making variables those are from perticular type
enum direction{
    case north
    case south
    case east
    case west
}
var dir = direction.west //making var of enums
print(dir)

switch dir
{
case direction.north: //call the enum var by enum name
    print("It is north")
case .south:    //call enum var by directly because dir is from type direction enum so we dont have to write it everytime
    print("It is south")
case .east:
    print("It is east")
case .west:
    print("It is east")
}

//Swift Enums with values
enum direction2:String{
    case north = "Go forward"
    case south = "Go backward"
    case east = "Go right"
    case west = "Go left"
}
var dir2 = direction2.east
print(dir2) //getting enum var
print(dir2.rawValue) //Getting the enum variable's value
switch dir2
{
case direction2.north: //call the enum var by enum name
    print("It is north")
case .south:    //call enum var by directly because dir is from type direction enum so we dont have to write it everytime
    print("It is south")
case .east:
    print("It is east")
case .west:
    print("It is east")
}

//object oriented programming with swift
class person{
    var name : String
    var age : Int
    init(name:String,age:Int) {
        self.name = name
        self.age = age
    }
    func showdata(){
        print("name is \(self.name)\nage is \(self.age)")
    }
}
var p1 = person(name : "vrushank",age : 12)
p1.showdata()
print(p1.name)
print(p1.age)

    //inheritance and fun overriding
class parent{
    func parentmethod(){
        print("This is parent method")
    }
    func pureparent(){
        print("this is pure parent method")
    }
}
var p = parent()
p.parentmethod()

class child : parent
{
    override func parentmethod() { //write override before function declaration to override the method which is existing on parent class
        print("This is child class parent method which is overrided")
    }
    func purechild()
    {
        print("this is pure child method")
    }
}

var c = child()
c.pureparent() //this will call parent class method
c.purechild()   //this will call child class method
c.parentmethod() //this will override parent class method by child class method
