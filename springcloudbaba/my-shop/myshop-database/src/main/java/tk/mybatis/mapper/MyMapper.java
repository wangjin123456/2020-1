package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 该接口不能被扫描到，否则会报错
 * @autor tom
 * @date 2020/3/24 0024 17:10
 */
public interface MyMapper<T>  extends Mapper<T>, MySqlMapper<T> {
}
