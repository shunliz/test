def test(param1, param2, *args, **kwargs):
    print args


a = {'param3': 'param3'}
import pdb;pdb.set_trace()
test('param1', 'param2', a)