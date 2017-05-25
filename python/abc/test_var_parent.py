from docker import client

if hasattr(client, 'Client'):
    cls = client.Client
else:
    cls = client.DockerClient

class Driver(cls):
    def __init__(self):
        print 'in init'

    def show(self):
        print 'show msg'

driver = Driver()
driver.show()
