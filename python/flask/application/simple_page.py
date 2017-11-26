from flask import render_template
from flask import Blueprint, abort
from flask import request
from flask import make_response
from jinja2 import TemplateNotFound

simple_page = Blueprint('simple_page', __name__,
                        template_folder='templates')

@simple_page.route('/', defaults={'page': 'index'})
@simple_page.route('/<page>')
def show(page):
    if not request.cookies.get('counter'):
        counter = 0
    else:
        counter = int(request.cookies.get('counter'))
    counter = counter+1

    print counter
    try:
        resp = make_response(render_template('pages/%s.html' % page))
        resp.set_cookie('counter', '0')
        return resp
    except TemplateNotFound:
        abort(404)
