package com.sysu.crowdsourcing.service;

import com.sysu.persistence.model.crowdsourcing.DecomposeTaskEntity;

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

public interface DecomposeTaskService {

    long saveDecomposeTask(DecomposeTaskEntity decomposeTaskEntity);

    boolean saveDecomposeTask(ArrayList<DecomposeTaskEntity> decomposeTaskEntities);

    ArrayList<DecomposeTaskEntity> getDecomposeTasks(DecomposeTaskEntity decomposeTaskEntity);

    DecomposeTaskEntity getDecomposeTask(DecomposeTaskEntity decomposeTaskEntity);

    boolean updateDecomposeTask(DecomposeTaskEntity decomposeTaskEntity);


}
