from flask import Flask, jsonify, request

app = Flask(__name__)


@app.route("/", methods=['GET', 'POST'])
def index():
    if (request.method == 'POST'):
        # with POST request, we'll send some data in jsonified form, no matter what data byt we can send any data.
        some_json = request.get_json()
        # below, we'll return the json that sent to us with request,
        # also we're sending the response code as 201.
        return jsonify(some_json), 201
    else:
        return jsonify({"response": "You sent a GET request, Hello there."})


@app.route("/multi/<int:num>", methods=['GET'])
def get_multiply_10(num):
    return jsonify({"result": num*10})


if __name__ == "__main__":
    app.run(debug=True)
