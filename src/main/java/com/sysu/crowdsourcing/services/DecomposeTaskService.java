package com.sysu.crowdsourcing.services;

import com.sysu.crowdsourcing.entity.DecomposeTask;

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

    long saveDecomposeTask(DecomposeTask decomposeTask);

    boolean saveDecomposeTask(ArrayList<DecomposeTask> decomposeTasks);

    ArrayList<DecomposeTask> getDecomposeTasks(DecomposeTask decomposeTask);

    DecomposeTask getDecomposeTask(DecomposeTask decomposeTask);


}
