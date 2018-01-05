import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class TestCluster {
    @Test
    public void test1() throws Exception {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        HostAndPort hostAndPort = new HostAndPort("192.168.1.99", 7000);
        HostAndPort hostAndPort1 = new HostAndPort("192.168.1.99", 7001);
        HostAndPort hostAndPort2 = new HostAndPort("192.168.1.99", 7002);
        HostAndPort hostAndPort3 = new HostAndPort("192.168.1.99", 7003);
        HostAndPort hostAndPort4 = new HostAndPort("192.168.1.99", 7004);
        HostAndPort hostAndPort5 = new HostAndPort("192.168.1.99", 7005);
        nodes.add(hostAndPort);
        nodes.add(hostAndPort1);
        nodes.add(hostAndPort2);
        nodes.add(hostAndPort3);
        nodes.add(hostAndPort4);
        nodes.add(hostAndPort5);
        JedisCluster jedisCluster = new JedisCluster(nodes, poolConfig);//JedisCluster中默认分装好了连接池.
        //redis内部会创建连接池，从连接池中获取连接使用，然后再把连接返回给连接池
        String string = jedisCluster.get("a");
        System.out.println(string);            
    }
}