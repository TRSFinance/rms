package com.trs.rms.rulemgr.bean;
/**
 * CKM规则频次对应的实体类。
 * @author wengjing
 *
 */
public class CkmRuleFrequency {
	//fields	---------------------------------------------------------------------
	/**
	 * 实体ID
	 */
	private Long id;
	/**
	 * 文章词数
	 */
	private Integer wordCount;
	/**
	 * 词频
	 */
	private Integer wordFrequency;
	//accessors	---------------------------------------------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public Integer getWordFrequency() {
		return wordFrequency;
	}
	public void setWordFrequency(Integer wordFrequency) {
		this.wordFrequency = wordFrequency;
	}
	
}
