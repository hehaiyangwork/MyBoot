package club.itbus.mapper;

/**
 * Desc:
 * author:HeHaiYang
 * Date:16/1/18
 */
import club.itbus.domain.City;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CityMapper {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public City selectCityById(long id) {
        return this.sqlSessionTemplate.selectOne("selectCityById", id);
    }

}