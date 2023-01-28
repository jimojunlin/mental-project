package com.mental.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mental.dao.AnwserDao;
import com.mental.pojo.Anwser;
import com.mental.service.AnwserService;
import org.springframework.stereotype.Service;

@Service
public class AnwserServiceImpl extends ServiceImpl<AnwserDao, Anwser> implements AnwserService {
}
