package ibase.test.learning;

import redis.clients.jedis.Jedis;

import java.util.*;

public class JedisTemp {

    public static void main(String [] args){
        rStrings();
        rHashs();
        rLists();
        rSets();
        rSortedSets();
    }

    //redis strings
    public static void rStrings() {
        Jedis redis = new Jedis("127.0.0.1",6379);
        redis.set("key1", "value1");
        redis.setex("key2", 5, "value1");//10秒有效期
        redis.mget("key31", "value31", "key32", "value32");//一次设置多个值
        redis.append("key33", "value33");//追加值

        String value1 = redis.get("key1");
        String value2 = redis.get("key2");
        System.out.println("value1:" + value1 + ";value2:" + value2);

        //测试过时
        try {
            Thread.sleep(5000);
            value2 = redis.get("key2");
            System.out.println("value2-10s后的值："+value2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取多个值
        List<String> list = redis.mget("key31", "key32", "key33");
        for(String s:list){
            System.out.println(s);
        }
    }

    //redis hashs
    public static void rHashs(){
        Jedis redis = new Jedis("127.0.0.1",6379);
        redis.hset("hash1","key11","value11");
        redis.hset("hash1","key12","value12");
        redis.hset("hash1", "key13", "value13");

        //一次设置多个值
        Map<String,String> map = new HashMap<String,String>();
        map.put("key21", "value21");
        map.put("key22", "value22");
        map.put("key23", "value23");
        redis.hmset("hash2", map);

        String value11 = redis.hget("hash1","key11");
        List<String> list = redis.hmget("hash1", "key12", "key13");
        Map<String, String> hash2 = redis.hgetAll("hash2");

        System.out.println(value11);
        for (String s:list){
            System.out.println("value:"+s);
        }
        Iterator iterator = hash2.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
        }
    }

    //redis lists
    public static void rLists(){
        Jedis redis = new Jedis("127.0.0.1",6379);
        //首部添加
        redis.lpush("list","value11");
        redis.lpush("list","value12");
        //尾部添加
        redis.rpush("list", "value13");
        redis.rpush("list", "value14");

        //获取指定区间的元素
        List<String> list = redis.lrange("list",0,2);
        for(String s:list){
            System.out.println("value:"+s);
        }

        redis.lpop("list");//首部删除
        redis.rpop("list");//尾部删除
        Long size = redis.llen("list");//获取list的大小
    }

    //redis sets
    public static void rSets(){
        Jedis redis = new Jedis("127.0.0.1",6379);
        redis.sadd("set","value1");//添加元素
        redis.sadd("set","value2");
        redis.sadd("set","value3");
        redis.srem("value3");//移除元素

        Set<String> set = redis.smembers("set");//枚举出所有元素
        for(String s:set){
            System.out.println(s);
        }

    }

    //redis sorted sets
    public static void rSortedSets(){
        Jedis redis = new Jedis("127.0.0.1",6379);
        redis.zadd("sset",1,"value1");
        redis.zadd("sset",2,"value2");
        redis.zadd("sset",3,"value3");
        redis.zadd("sset",4,"value4");
        redis.zadd("sset",5,"value5");

        Set<String> sset = redis.zrange("sset",1,3);//根据范围正向取set
        Set<String> rsset = redis.zrevrange("sset",1,3);//根据范围反向取set
    }
}
