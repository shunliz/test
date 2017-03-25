from docker import client
dk = client.Client(base_url='unix://var/run/docker.sock', version='1.19',timeout=120, tls=None)
ct = dk.create_container('ubuntu', command='/bin/sh', stdin_open=True, tty=True， name='test')
dk.start('test')