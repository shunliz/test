from flask import Flask
from flask import render_template
from flask import request
app = Flask(__name__)

@app.route('/')
def index():
    return 'index'

@app.route('/hello')
@app.route('/hello/<name>')
def hello(name=None):
    return render_template('hello.html', name=name)

if __name__ == '__main__':
    app.debug = True
    app.run()