from flask import Flask, jsonify

app = Flask(__name__)


@app.route("/")
def hello():
    # Below line will convert the response type to application/json
    return jsonify({
        "data": "Hello world!"
    })


if __name__ == "__main__":
    app.run(debug=True)
