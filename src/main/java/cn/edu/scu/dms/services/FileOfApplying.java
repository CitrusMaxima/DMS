package cn.edu.scu.dms.services;

import java.util.List;

import cn.edu.scu.dms.model.Qpwj;

public interface FileOfApplying {
	
	public Boolean registerFile(Qpwj swwj);
	public List<Qpwj> getAllFile();

}
