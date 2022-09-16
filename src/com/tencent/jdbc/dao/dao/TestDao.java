package com.tencent.jdbc.dao.dao;

import com.tencent.jdbc.utils.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDao {

    @Test
    public void testActorDao(){
        ActorDao actorDao = new ActorDao();
        String sql = "select * from actor where id>=?";
        List<Actor> list = actorDao.queryMuti(sql, Actor.class, 1);
        for (Actor actor : list) {
            System.out.println(actor);
        }

        Actor actor = actorDao.querySingle("select * from actor where id=?", Actor.class, 1);
        System.out.println(actor);

        Object o = actorDao.queryScalar("select name from actor where id=?", 2);
        System.out.println(o);

        int update = actorDao.update("update actor set name=? where id=?", "刘德华", 1);
        System.out.println(update);
    }
}
