package com.sysu.crowdsourcing;

import com.sysu.workflow.engine.SCXMLInstanceManager;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/15
 * Time: 17:19
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class TestSCXMLInstanceManager {
    @Test
    public void testInstanceManager() {
        System.out.println(SCXMLInstanceManager.getRunningSCXMLInstanceExecutorMap());
    }
}
