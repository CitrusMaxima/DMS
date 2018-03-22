package cn.edu.scu.dms.services.Iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.scu.dms.dao.QpwjMapper;
import cn.edu.scu.dms.model.Qpwj;
import cn.edu.scu.dms.services.FileOfApplyingServices;

@Service
public class FileOfApplyingIml implements FileOfApplyingServices {

	@Autowired
	QpwjMapper qpwjMapper;
	
	@Transactional
	public Boolean registerFile(Qpwj qpwj){
		qpwjMapper.insert(qpwj);
		return true;
	}

	@Override
	@Transactional
	public List<Qpwj> getAllFile() {
		// TODO Auto-generated method stub
		List<Qpwj> temp=null;
		temp=qpwjMapper.getAllFile();
		return temp;
	}

	@Override
	@Transactional
	public Boolean deleteFile(String id) {
		// TODO Auto-generated method stub
		qpwjMapper.deleteByPrimaryKey(id);
		return true;
	}

	@Override
	@Transactional
	public Qpwj getQpwjById(String id) {
		// TODO Auto-generated method stub
		Qpwj qpwj = qpwjMapper.selectByPrimaryKey(id);
		return qpwj;
	}
}
