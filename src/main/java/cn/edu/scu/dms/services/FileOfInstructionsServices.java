package cn.edu.scu.dms.services;

import java.util.List;

import cn.edu.scu.dms.model.Pswj;

public interface FileOfInstructionsServices {
	
	public Boolean registerFile(Pswj pswj);
	public List<Pswj> getAllFile();
	public Boolean deleteFile(String id);
	public Pswj getPswjById(String id);
}
