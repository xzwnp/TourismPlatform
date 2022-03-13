package com.example.tourism.mapper;

import com.example.tourism.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author xiaozhiwei
 * @since 2022-02-26
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
