package com.trs.rms.base.page;

import java.util.List;

public interface IBasicDao {
	public List queryObjectsToPages( final BasicPage page );
	public int queryForInt( final BasicPage page );
}
