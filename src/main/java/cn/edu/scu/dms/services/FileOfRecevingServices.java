package cn.edu.scu.dms.services;

import java.util.List;

import cn.edu.scu.dms.model.Pswj;
import cn.edu.scu.dms.model.Swwj;

public interface FileOfRecevingServices {
	
	public Boolean registerFile(Swwj swwj);
	public List<Swwj> getAllFile();
	
}
