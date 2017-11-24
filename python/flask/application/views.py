from flask import render_template

from application import app

@app.route('/')
def index():
    return 'index'

@app.route('/hello')
@app.route('/hello/<name>')
def hello(name=None):
    return render_template('hello.html', name=name)