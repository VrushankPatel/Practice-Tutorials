from datetime import datetime
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///db.sqlite3'

db = SQLAlchemy(app)


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50))
    location = db.Column(db.String(50))
    date_created = db.Column(db.DateTime, default=datetime.now())


@app.route("/<name>/<location>", methods=['POST'])
def index(name, location):
    user = User(name=name, location=location)
    db.session.add(user)
    db.session.commit()
    return "<h1>Added new user</h1>", 201


@app.route("/<name>")
def get_user(name):
    # here, we'll take only frst row
    user = User.query.filter_by(name=name).first()
    # User.query.filter_by(name=name).all() # to get all the rows of that name
    if user:
        return f'<h2>{name} is located in: {user.location}</h2>'
    else:
        return '<h1>No such user exists</h1>'


if __name__ == "__main__":
    app.run(debug=True)
