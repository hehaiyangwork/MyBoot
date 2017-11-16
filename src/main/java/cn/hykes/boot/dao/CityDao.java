package cn.hykes.boot.dao;

/**
 * Desc:
 * author:HeHaiYang
 * Date:16/1/18
 */
import cn.hykes.boot.domain.City;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CityDao extends MyBatisDao<City> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public City selectCityById(long id) {
        return this.sqlSessionTemplate.selectOne(sqlId("selectCityById"), id);
    }

}