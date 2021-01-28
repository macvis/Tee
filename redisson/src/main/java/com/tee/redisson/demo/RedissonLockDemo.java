package com.tee.redisson.demo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author youchao.wen
 * @date 2020/12/27.
 */
public class RedissonLockDemo {
    @Autowired
    Redisson redisson;
    @Autowired
    Config config;

    public void tryLock() throws Exception{
        RLock lock = redisson.getLock("dist-lock");
        // 最常见的使用方法
        lock.lock();

        // 支持过期解锁功能 10秒钟以后自动解锁
        // 无需调用unlock方法手动解锁
        lock.lock(10, TimeUnit.SECONDS);

        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS); lock.unlock();

    }
}
