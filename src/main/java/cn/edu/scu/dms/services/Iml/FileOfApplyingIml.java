package cn.edu.scu.dms.services.Iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.scu.dms.dao.QpwjMapper;
import cn.edu.scu.dms.model.Qpwj;
import cn.edu.scu.dms.services.FileOfApplying;

@Service
public class FileOfApplyingIml implements FileOfApplying {

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
		//temp=
		
		return null;
	}

	@Override
	@Transactional
	public Boolean deleteFile(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Qpwj getQpwjById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void update(Qpwj qpsj) {
		// TODO Auto-generated method stub
		
	}

}
