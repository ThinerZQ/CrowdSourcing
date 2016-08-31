package com.sysu.crowdsourcing.service.impl;


import com.sysu.crowdsourcing.manager.DecomposeTaskManager;
import com.sysu.crowdsourcing.service.DecomposeTaskService;
import com.sysu.model.crowdsourcing.DecomposeTaskEntity;
import org.springframework.stereotype.Service;

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
@Service
public class DecomposeTaskServiceImpl implements DecomposeTaskService {

    @Resource
    DecomposeTaskManager decomposeTaskManager;


    public long saveDecomposeTask(DecomposeTaskEntity decomposeTaskEntity) {

        return 0;
    }

    public boolean saveDecomposeTask(ArrayList<DecomposeTaskEntity> decomposeTaskEntities) {
        return false;
    }

    public ArrayList<DecomposeTaskEntity> getDecomposeTasks(DecomposeTaskEntity decomposeTaskEntity) {
        return null;
    }

    public DecomposeTaskEntity getDecomposeTask(DecomposeTaskEntity decomposeTaskEntity) {
        return null;
    }

    public boolean updateDecomposeTask(DecomposeTaskEntity decomposeTaskEntity) {
        return false;
    }
}
