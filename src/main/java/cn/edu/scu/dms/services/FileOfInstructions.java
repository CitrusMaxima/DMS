package cn.edu.scu.dms.services;

import java.util.List;

import cn.edu.scu.dms.model.Pswj;

public interface FileOfInstructions {
	
	public Boolean registerFile(Pswj pswj);
	public List<Pswj> getAllFile();
	
}
