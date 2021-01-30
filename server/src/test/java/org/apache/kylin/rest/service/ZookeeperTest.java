package org.apache.kylin.rest.service;

import org.apache.kylin.common.KylinConfig;
import org.apache.kylin.common.lock.DistributedLock;
import org.junit.Test;

public class ZookeeperTest extends ServiceTestBase {


    @Test
    public void testZkLock() {

        String path = "/basepath/123456";

        DistributedLock lock = KylinConfig.getInstanceFromEnv().getDistributedLockFactory().lockForCurrentProcess();

        if (!lock.isLocked(path)) {

            System.out.println("没有锁");
            lock.lock(path);

            if (lock.isLocked(path)) {
                System.out.println("有锁");
            } else {
                System.out.println("没有锁");
            }

            lock.unlock(path);

            if (lock.isLocked(path)) {
                System.out.println("有锁");
            } else {
                System.out.println("没有锁");
            }
        }
    }

}