package cn.edu.scu.dms.services.Iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.scu.dms.dao.PswjMapper;
import cn.edu.scu.dms.model.Pswj;
import cn.edu.scu.dms.services.FileOfInstructionsServices;

@Service
public class FileOfInstructionsIml implements FileOfInstructionsServices {
    
	
	@Autowired
	PswjMapper pswjMapper;
	
	public Pswj getPswjById(String id){
		Pswj pswj=null;
		pswj=pswjMapper.selectByPrimaryKey(id);
		return pswj;
	}
	
	@Transactional
	public Boolean registerFile(Pswj pswj) {
		// TODO Auto-generated method stub
		pswjMapper.insert(pswj);
		return true;
	}
    
	@Transactional
	@Override
	public List<Pswj> getAllFile() {
		// TODO Auto-generated method stub
		List<Pswj> tempList=pswjMapper.getAllFile();
		return tempList;
	}

	@Override
	@Transactional
	public Boolean deleteFile(String id) {
		// TODO Auto-generated method stub
		pswjMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	@Transactional
	public void update(Pswj pswj) {
		// TODO Auto-generated method stub
	    pswjMapper.updateByPrimaryKey(pswj);
		
	}

}
