package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.VotetaskEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public interface VoteTaskDao {
    boolean addVoteTask(VotetaskEntity votetaskEntity);

    boolean deleteVoteTaskById(String voteTask_id);

    boolean updateVoteTask(VotetaskEntity votetaskEntity);

    List<VotetaskEntity> findAllVoteTask();

    VotetaskEntity findVoteTaskById(String voteTask_id);

    List<VotetaskEntity> findVoteTaskByCriteria(Criteria criteria);
}
