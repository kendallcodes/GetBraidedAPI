package com.getbraided.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getbraided.entity.Style;
import com.getbraided.entity.Stylist;
import com.getbraided.repository.StyleRepository;
import com.getbraided.repository.StylistRepository;

@Service
public class StyleService {


	@Autowired
	private StyleRepository repo;

	@Autowired
	private StylistRepository stylistRepo;

	public Iterable<Style> getAllStyles() {
		return repo.findAll();
	}

	public Iterable<Style> getStyle(String styleName) {
		return repo.findByStyleName(styleName);
	}

	public Style createStyle(Style style, Long stylistId) throws Exception {
		Stylist stylist = stylistRepo.findOne(stylistId);
		if (stylist == null) {
			throw new Exception("Stylist not found.");
		}
		style.setStylist(stylist);
		return repo.save(style);
	}

	public void deleteStyle(Long styleId) {
		repo.delete(styleId);
	}

	public Style pictureUpload(Long styleId, String url) throws Exception {
		Style style = repo.findOne(styleId);
		if (style == null) {
			throw new Exception("Style cannot be found!");
		}
		style.setPictureURL(url);
		return repo.save(style);
	}

	/*public Style getStyleById(Long styleId) throws Exception {
		Style style = repo.findByStyleId(styleId);
		if (style == null) {
			throw new Exception("Style cannot be found.");
		}
		return repo.findByStyleId(styleId);
	}*/

}
