package com.aciel.reggie.service;

import com.aciel.reggie.entity.AddressBook;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 地址管理 服务类
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
public interface AddressBookService extends IService<AddressBook> {

    void setDefault(AddressBook addressBook);
}
