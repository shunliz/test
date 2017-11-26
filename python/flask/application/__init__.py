from flask import Flask

from application.simple_page import simple_page
from application.user_page import user_page

app = Flask(__name__)

app.register_blueprint(simple_page)
app.register_blueprint(user_page)

from application import views

from application.db import db_session

@app.teardown_request
def shutdown_session(exception=None):
    db_session.remove()