package cn.hykes.boot.dao;

/**
 * Desc:
 * author:HeHaiYang
 * Date:16/1/18
 */

import java.lang.reflect.ParameterizedType;

public abstract class MyBatisDao<T> {

    public final String nameSpace;

    public MyBatisDao() {
        if(this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
            this.nameSpace = ((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        } else {
            this.nameSpace = ((Class)((ParameterizedType)this.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
        }

    }

    protected String sqlId(String id) {
        return this.nameSpace + "." + id;
    }
}
