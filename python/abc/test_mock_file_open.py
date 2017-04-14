data = ('MemTotal:        3882464 kB\nMemFree:         3514608 kB\n'
        'MemAvailable:    3556372 kB\n')
m_open = mock_open(read_data=data)
with mock.patch.object(six.moves.builtins, "open", m_open,
					   create=True):
	output = os_capability_linux.LinuxHost().get_host_mem()
	self.assertEqual((3882464, 3514608, 3556372), output)
