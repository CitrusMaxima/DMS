package cn.edu.scu.dms.services;

import java.util.List;

import cn.edu.scu.dms.model.Swwj;

public interface FileOfRecevingServices {
	
	public Boolean registerFile(Swwj swwj);
	public List<Swwj> getAllFile();
	public Boolean deleteFile(String id);
	public Swwj getSwwjById(String id);
	public void update(Swwj swwj);
}
