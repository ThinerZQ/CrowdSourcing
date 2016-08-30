package com.sysu.crowdsourcing.service.impl;

import com.sysu.model.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.model.crowdsourcing.entity.JudgeTask;
import com.sysu.model.crowdsourcing.services.JudgeTaskService;

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
    JudgeTaskDao judgeTaskDao;

    public long saveJudgeTask(JudgeTask judgeTask) {
        return judgeTaskDao.saveJudgeTask(judgeTask);
    }
}
