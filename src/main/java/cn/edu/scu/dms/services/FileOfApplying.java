package cn.edu.scu.dms.services;

import java.util.List;

import cn.edu.scu.dms.model.Pswj;
import cn.edu.scu.dms.model.Qpwj;

public interface FileOfApplying {
	
	public Boolean registerFile(Qpwj qpwj);
	public List<Qpwj> getAllFile();
	public Boolean deleteFile(String id);
	public Qpwj getQpwjById(String id);
	public void update(Qpwj qpsj);

}
