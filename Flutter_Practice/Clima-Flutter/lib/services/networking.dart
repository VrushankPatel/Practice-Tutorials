import 'package:http/http.dart' as http;
import 'dart:convert';

class NetworkHelper {
  NetworkHelper(this.url);

  final String url;

  Future getData() async{
    print(url);
    http.Response response = await http.get(url);
    if(response.statusCode == 200){
      return jsonDecode(response.body);
    }else{
      print(response.statusCode);
    }
  }
}