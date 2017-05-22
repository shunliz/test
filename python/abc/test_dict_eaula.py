import collections
import unittest

class TestSOquestion(unittest.TestCase):

    def setUp(self):
        pass # whatever...

    def test_stuff(self):

        notification = {'priority': 'INFO',
		                'event_type': 'server_group.create',
						'payload': {'nova_object.data': {'name': 'test-server-group'}}}
        notification2 = {'priority': 'INFO',
		                 'event_type': 'server_group.create',
						 'payload': {'nova_object.data': {'name': 'test-server-group'}}}

        self.assertDictEqual(notification, notification2) # True

if __name__ == '__main__':
    unittest.main()