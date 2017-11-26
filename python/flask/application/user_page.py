from flask import Blueprint, abort
from application.db import api

user_page = Blueprint('user_page', __name__)

@user_page.route('/user/add')
def add():
    api.add()
    return "Add user done"


@user_page.route('/user/show/<user_id>')
def show(user_id):
    user = api.get(user_id)
    return "show"+ user.name
