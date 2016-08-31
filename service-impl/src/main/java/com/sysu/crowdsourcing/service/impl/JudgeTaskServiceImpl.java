package com.sysu.crowdsourcing.service.impl;


import com.sysu.crowdsourcing.manager.JudgeTaskManager;
import com.sysu.crowdsourcing.service.JudgeTaskService;
import com.sysu.model.crowdsourcing.JudgeTaskEntity;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/15
 * Time: 13:23
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class JudgeTaskServiceImpl implements JudgeTaskService {

    @Resource(name = "judgeTaskDao")
    JudgeTaskManager judgeTaskManager;

    public long saveJudgeTask(JudgeTaskEntity judgeTaskEntity) {
        return 0;
    }
}
