package com.aciel.reggie.service.impl;

import com.aciel.reggie.common.UserContext;
import com.aciel.reggie.entity.AddressBook;
import com.aciel.reggie.mapper.AddressBookMapper;
import com.aciel.reggie.service.AddressBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址管理 服务实现类
 * </p>
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

    /**
     * 设置默认地址
     * @param addressBook
     */
    @Override
    public void setDefault(AddressBook addressBook) {
        // 首相把所有地址的 isDefault设置为 0
        Long userId = UserContext.getUserId();
        LambdaQueryWrapper<AddressBook> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AddressBook::getUserId,userId);
        AddressBook ad = new AddressBook();
        ad.setIsDefault(false);
        update(ad, wrapper);
        // 把当前id地址设置为1
        addressBook.setIsDefault(true);
        updateById(addressBook);
    }
}
