package cn.edu.scu.dms.services.Iml;

import cn.edu.scu.dms.dao.SwwjMapper;
import cn.edu.scu.dms.model.Swwj;
import cn.edu.scu.dms.services.FileOfReceivingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 26637_000 on 2018/3/20.
 */
@Service
public class FileOfReceivingIml implements FileOfReceivingServices {

    @Autowired
    private SwwjMapper swwjMapper;

    @Transactional
    @Override
    public Boolean registerFile(Swwj swwj) {
        swwjMapper.insert(swwj);
        return true;
    }

    @Transactional
    @Override
    public List<Swwj> getAllFile() {

        List<Swwj> tempList=swwjMapper.getAllFile();
        return tempList;
    }

    @Transactional
    @Override
    public Boolean deleteFile(String id) {
        swwjMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Transactional
    @Override
    public Swwj getSwwjById(String id) {
        Swwj swwj=null;
        swwj=swwjMapper.selectByPrimaryKey(id);
        return swwj;
    }

    @Transactional
    @Override
    public void update(Swwj swwj) {
        swwjMapper.updateByPrimaryKey(swwj);
    }
}
