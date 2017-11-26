from application.db import db_session
from application.db.models import User

def add():
    u = User('admin', 'passw0rd')
    db_session.add(u)
    db_session.commit()

def get(user_id):
    user = User.query.filter(User.id == user_id).first()
    return user
