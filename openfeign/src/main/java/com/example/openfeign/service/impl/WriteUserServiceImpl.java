package com.example.openfeign.service.impl;

import com.example.openfeign.dao.mapper.extend.UserExtendExtMapper;
import com.example.openfeign.dao.po.UserExtend;
import com.share.foreign.dto.UserExtendDTO;
import com.example.openfeign.service.IWriteUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName WriteUserServiceImpl
 * @Description 用户信息增删改
 * @Author Mr.Cui
 * @Date 6/9/22 2:40 PM
 */
@Service
public class WriteUserServiceImpl implements IWriteUserService {

    @Resource
    private UserExtendExtMapper userExtendExtMapper;

    @Override
    public Boolean deleteUserById(UserExtendDTO userExtendDTO) {
        // 物理删除(正常不要物理删除)
        //int count = userExtendExtMapper.deleteByPrimaryKey(userExtendDTO.getId());
        // 非物理删除
        UserExtend record = new UserExtend();
        record.setId(userExtendDTO.getId());
        record.setIsDeleted(true);
        int count = userExtendExtMapper.updateByPrimaryKeySelective(record);
        return count > 0;
    }

    @Override
    public Boolean deleteUserByIdList(UserExtendDTO userExtendDTO) {
        if (CollectionUtils.isEmpty(userExtendDTO.getIdList())) {
            return false;
        }
        // 非物理删除
        Integer count = userExtendExtMapper.updateIsDeleteByIdList(userExtendDTO.getIdList(), true);
        return count > 0;
    }

    @Override
    public Boolean updateUserById(UserExtendDTO userExtendDTO) {
        if (Objects.isNull(userExtendDTO)) {
            return false;
        }
        UserExtend userExtend = new UserExtend();
        BeanUtils.copyProperties(userExtendDTO, userExtend);
        int count = userExtendExtMapper.updateByPrimaryKeySelective(userExtend);
        return count > 0;
    }

    @Override
    public Boolean insertUserContext(UserExtendDTO userExtendDTO) {
        if (Objects.isNull(userExtendDTO)) {
            return false;
        }
        UserExtend userExtend = new UserExtend();
        BeanUtils.copyProperties(userExtendDTO, userExtend);
        int count = userExtendExtMapper.insertSelective(userExtend);
        return count > 0;
    }
}
