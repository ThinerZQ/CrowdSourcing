package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.DecomposeTaskDao;
import com.sysu.crowdsourcing.entity.DecomposeTask;
import com.sysu.crowdsourcing.services.DecomposeTaskService;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/15
 * Time: 13:23
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class DecomposeTaskServiceImpl implements DecomposeTaskService {

    @Resource(name = "decomposeTaskDao")
    DecomposeTaskDao decomposeTaskDao;


    public long saveDecomposeTask(DecomposeTask decomposeTask) {
        return decomposeTaskDao.saveDecomposeTask(decomposeTask);
    }

    public boolean saveDecomposeTask(ArrayList<DecomposeTask> decomposeTasks) {
        return decomposeTaskDao.saveDecomposeTask(decomposeTasks);
    }

    public ArrayList<DecomposeTask> getDecomposeTasks(DecomposeTask decomposeTask) {
        return decomposeTaskDao.getDecomposeTasks(decomposeTask);
    }

    public DecomposeTask getDecomposeTask(DecomposeTask decomposeTask) {
        return decomposeTaskDao.getDecomposeTask(decomposeTask);
    }
}
