package com.paloit.paloma.service.source.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paloit.paloma.domain.Source;
import com.paloit.paloma.repository.SourceRepository;
import com.paloit.paloma.service.source.SourceService;

/**
 * Source implemented service.
 * @author DTRANG
 *
 */
@Service("SourceService")
@Transactional
public class SourceServiceImpl implements SourceService{

	/**
	 * Source repository.
	 */
	@Autowired
	SourceRepository sourceRepository;
	
	public void create(String title) {
		
		Source source = new Source();
		if (null != findSource(title)){
			source.setTitle(title);
			sourceRepository.saveAndFlush(source);
		}
	}

	public void update(Long id, String title) {
		
		Source source = sourceRepository.findOne(id);		
		if (null != findSource(title)){
			source.setTitle(title);
			sourceRepository.saveAndFlush(source);
		}
		
	}

	public Source findSource(String title) {	
		
		Source source = sourceRepository.findByTitle(title);	
		return source;
	}

	public List<Source> findAll() {
		List<Source> sources = sourceRepository.findAll();
		return sources;
	}

	


	

	

}
